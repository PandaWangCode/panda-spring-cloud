package com.panda.dao.user;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.panda.entity.UmsPermissionEntity;

/**
 * ��̨�û����ɫ�����Զ���Dao
 * @author DELL
 *
 */
public interface UmsAdminRoleRelationDao {
	/**
     * ��ȡ�û�����Ȩ��(����+-Ȩ��)
     */
    List<UmsPermissionEntity> getPermissionList(@Param("adminId") Long adminId);
    
}
