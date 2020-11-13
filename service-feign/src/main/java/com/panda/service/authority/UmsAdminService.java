package com.panda.service.authority;

import java.util.List;

import com.panda.entity.UmsAdminEntity;
import com.panda.entity.UmsPermissionEntity;

/**
 * ��̨����ԱService
 */
public interface UmsAdminService {
    /**
     * �����û�����ȡ��̨����Ա
     */
    UmsAdminEntity getAdminByUsername(String username);

    /**
     * ע�Ṧ��
     */
    UmsAdminEntity register(UmsAdminEntity umsAdminParamEntity);

    /**
     * ��¼����
     * @param username �û���
     * @param password ����
     * @return ���ɵ�JWT��token
     */
    String login(String username, String password);

    /**
     * ��ȡ�û�����Ȩ�ޣ�������ɫȨ�޺�+-Ȩ�ޣ�
     */
    List<UmsPermissionEntity> getPermissionList(Long adminId);
}
