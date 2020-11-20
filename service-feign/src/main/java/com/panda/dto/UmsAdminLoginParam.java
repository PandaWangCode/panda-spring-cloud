package com.panda.dto;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

/**
 * �û���¼����
 * @author DELL
 *
 */
public class UmsAdminLoginParam {
	
	    @ApiModelProperty(value = "�û���", required = true)
	    @NotEmpty(message = "�û�������Ϊ��")
	    private String username;
	    
	    @ApiModelProperty(value = "����", required = true)
	    @NotEmpty(message = "���벻��Ϊ��")
	    private String password;

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

}
