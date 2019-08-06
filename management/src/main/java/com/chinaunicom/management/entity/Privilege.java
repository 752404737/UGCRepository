package com.chinaunicom.management.entity;

public class Privilege {
    private String privilegeId;

    private String privilegeDescription;

    public String getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(String privilegeId) {
        this.privilegeId = privilegeId == null ? null : privilegeId.trim();
    }

    public String getPrivilegeDescription() {
        return privilegeDescription;
    }

    public void setPrivilegeDescription(String privilegeDescription) {
        this.privilegeDescription = privilegeDescription == null ? null : privilegeDescription.trim();
    }
}