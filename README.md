# UGC
基于RBAC的UGC应用开发设计

# 系统架构介绍&开发流程
## GitHub开发流程
1. 在 GitHub 上进行 Fork（将仓库通过GitHub提供的Fork操作添加到自己的仓库上，选择对应的分支）
2. 将❶的仓库 clone 至本地开发环境
```
git clone <url>
```
3. 在本地环境中创建特性分支
```
git checkout -b <branch-name> // 创建名为branch-name的分支, 并切换到branch-name分支
git branch // 显示本地仓库分支
git branch -a // 显示本地仓库和远程仓库的分支
```
4. 对特性分支进行代码修改并进行提交
```
git add <filename> // 添加文件名为filename的文件
git commit -m "<reason>" // 提交修改，并填写提交修改的原因reson
git commit -am "<reason>" // 添加并提交修改，并填写提交修改的原因reson

```
5. 将特性分支 push 到❶的仓库中
```
// 添加远程仓库，这里的git链接替换为开发者的github仓库链接
// <alias> 为远程仓库url的别名
git remote add <alias> <url>
// 推送至<alias>仓库下的branch分支
git push -u <alias> <branch>
```
6. 在 GitHub 上对 Fork 来源仓库发送 Pull Request
## 获取最新源代码
```
//更新源代码使用git fetch操作，不用git pull操作。git pull 一步到位的更新操作虽然方便但不安全。

// 例如 git remote add upstream git@github.com:dmw2017/UGC.git
// 给原仓库设置upstream的名称，将其作为远程仓库
git remote add <alias> <url>

// 例如git fetch upstream
// 其实结果是在本地创建了一个新的分支 upstream/master
git fetch <alias>

// 合并分支到本地仓库的当前所在分支
git merge upstream/master
```

## 常用操作命令
```
git clone <url>          // clone 已有仓库
git status               // 查看仓库状态
git add <filename>       // 文件加入暂存区
git commit -m "<reason>"  // 将暂存区的文件提交到仓库
git log [--graph]                // 查看提交日志
git reflog               // 查看当前仓库执行过的操作的日志
git remote add <alias> <url> // 连接远程仓库(url)并设置别名<alias>
git push -u <alias> <branch> // 推送至远程仓库的<branch>分支
git pull <alias> <branch>// 将本地的branch分支更新为最新的远程仓库分支
git fetch <alias>        // 获取最新源代码，其实是获取远程仓库的主干分支
git log -p [filename]    // 查看文件提交带来的改动
git diff                 // 查看工作树和暂存区之间的差别
git diff HEAD            // 查看与最新提交的差别
git branch               // 显示分支一览表
git branch <branch>      // 创建分支branch
git checkout <branch>    // 将工作树切换到branch分支
git checkout -b <branch> // 创建名为branch的分支，并转到分支
git merge --no-ff <branch> // 将分支branch合并到主干master
```

