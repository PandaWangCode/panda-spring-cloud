package com.panda.serviceimpl.authority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.panda.entity.UmsAdminEntity;
import com.panda.entity.UmsPermissionEntity;

public class AdminUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 7340685409671295334L;

	private UmsAdminEntity umsAdmin;
	
    private List<UmsPermissionEntity> permissionList;
    
    public AdminUserDetails(UmsAdminEntity umsAdmin, List<UmsPermissionEntity> permissionList) {
        this.umsAdmin = umsAdmin;
        this.permissionList = permissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return permissionList.stream()
        		.filter(permissionEntity -> permissionEntity.getValue()!=null)
        		.map(permissionEntity -> new SimpleGrantedAuthority(permissionEntity.getValue()))
        		.collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(1);
    }
}
