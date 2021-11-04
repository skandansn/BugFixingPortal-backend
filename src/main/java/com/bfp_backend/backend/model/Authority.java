package com.bfp_backend.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Table(name = "authorities")
@Entity
public class Authority implements GrantedAuthority {

    @Override
    public String getAuthority() {
        return roleCode;
    }

    

    public Authority() {
    }



    public Authority(String roleCode, String roleDescription) {
        this.roleCode = roleCode;
        this.roleDescription = roleDescription;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String roleCode;

    private String roleDescription;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    

    
}
