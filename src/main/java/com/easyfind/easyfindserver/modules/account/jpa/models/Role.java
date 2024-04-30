package com.easyfind.easyfindserver.modules.account.jpa.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_roles")
public class Role implements Serializable {
    protected Role() {}

    public Role(String roleName) {
        this.roleName = roleName;
        this.roleCreatedAt =  LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    private String roleName;

    private LocalDateTime roleCreatedAt;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public LocalDateTime getRoleCreatedAt() {
        return roleCreatedAt;
    }

    public void setRoleCreatedAt(LocalDateTime roleCreatedAt) {
        this.roleCreatedAt = roleCreatedAt;
    }
}
