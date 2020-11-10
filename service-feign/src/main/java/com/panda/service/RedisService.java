package com.panda.service;

/**
 * Redis��������������鶼��Json��ʽ�洢
 * @author DELL
 *
 */
public interface RedisService {
	/**
     * �洢����
     */
    void set(String key, String value);

    /**
     * ��ȡ����
     */
    String get(String key);

    /**
     * ���ó���ʱ��
     */
    boolean expire(String key, long expire);

    /**
     * ɾ������
     */
    void remove(String key);

    /**
     * ��������
     * @param delta ��������
     */
    Long increment(String key, long delta);
    
}
