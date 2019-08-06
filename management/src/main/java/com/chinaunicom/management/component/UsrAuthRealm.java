package com.chinaunicom.management.component;

import com.chinaunicom.management.entity.RolePrivilegeKey;
import com.chinaunicom.management.entity.Usr;
import com.chinaunicom.management.entity.UsrRoleKey;
import com.chinaunicom.management.orm.RolePrivilegeDao;
import com.chinaunicom.management.orm.UsrDao;
import com.chinaunicom.management.orm.UsrRoleDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-5 下午3:27
 */
@Component
public class UsrAuthRealm extends AuthorizingRealm {

    private static final Logger logger = LogManager.getLogger(UsrAuthRealm.class);

    @Autowired
    private UsrRoleDao usrRoleDao;
    @Autowired
    private RolePrivilegeDao rolePrivilegeDao;
    @Autowired
    private UsrDao usrDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取当前登录的用户账户
        String usrAccount = (String)principalCollection.getPrimaryPrincipal();

        // 获取用户所拥有的角色和权限
        List<String> roleIdList = new ArrayList<>();
        List<String> privilegeIdList = new ArrayList<>();

        // 从数据库获取当前登录用户的详细信息
        List<UsrRoleKey> usrRoleKeyList = usrRoleDao.getRoleIdByUsrAccount(usrAccount);
        for(UsrRoleKey usrRoleKey : usrRoleKeyList) {
            roleIdList.add(usrRoleKey.getRoleId());
        }
        List<RolePrivilegeKey> rolePrivilegeKeyList = rolePrivilegeDao.selectPrivilegeIdByRoleIdList(roleIdList);
        for(RolePrivilegeKey rolePrivilegeKey : rolePrivilegeKeyList) {
            privilegeIdList.add(rolePrivilegeKey.getPrivilegeId());
        }

        // 为当前用户设置角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roleIdList);
        simpleAuthorizationInfo.addStringPermissions(privilegeIdList);
        return simpleAuthorizationInfo;
    }

    /**
     * 验证当前登录的Subject
     * 该方法的调用时机为Subject.login()方法执行时
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 账号查询
        String usrAccount = (String)authenticationToken.getPrincipal();
        Usr usr = usrDao.selectByPrimaryKey(usrAccount);

        // 没有找到账号
        if(usr == null) {
            throw new UnknownAccountException();
        }

        // 交给AuthenticationRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo= new SimpleAuthenticationInfo(
                usr.getUsrAccount(),
                usr.getUsrPassword(),
                ByteSource.Util.bytes(usr.getUsrAccount() + "salt"),
                getName()
        );
        return authenticationInfo;
    }

    /**
     * 设置 realm的 HashedCredentialsMatcher
     */
    @PostConstruct
    public void setHashedCredentialsMatcher() {
        this.setCredentialsMatcher(hashedCredentialsMatcher());
    }

    /**
     * 凭证匹配：指定 加密算法，散列算法，散列次数
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 散列算法：这里使用MD5算法
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        // 散列的次数，比如散列两次，相当于md5(md5(""))
        hashedCredentialsMatcher.setHashIterations(2);
        // storedCredentialsHexEncoded默认是true,此时用的密码加密用的是Hex编码，false时用Base64编码
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }
}
