package com.panda.dao.user;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.panda.entity.UmsPermissionEntity;

/**
 * 后台用户与角色管理自定义Dao
 * @author DELL
 *
 */
public interface UmsAdminRoleRelationDao {
	/**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermissionEntity> getPermissionList(@Param("adminId") Long adminId);
    
}
