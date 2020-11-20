package com.panda.controller.authority;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panda.dto.UmsAdminLoginParam;
import com.panda.entity.UmsAdminEntity;
import com.panda.entity.UmsPermissionEntity;
import com.panda.service.authority.UmsAdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(tags = "umsAdminController", description = "后台管理")
@RequestMapping("/admin")
public class UmsAdminController {
	
	//@Autowired
    private UmsAdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    
    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> register(@RequestBody UmsAdminEntity umsAdminParam, BindingResult result) {
    	UmsAdminEntity umsAdmin = adminService.register(umsAdminParam);
        Map<String, Object> map = new ConcurrentHashMap<>();
    	if (umsAdmin == null) {
    		map.put("flag", false);
        }
    	map.put("flag", true);
        return map;
    }
    
    //@ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
    	Map<String, Object> map = new ConcurrentHashMap<>();
    	String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
        	map.put("flag", false);
        	map.put("message", "用户名或者密码错误");
        }
        map.put("token", token);
        map.put("tokenHead", tokenHead);
        return map;
    }
    
    //@ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getPermissionList(@PathVariable Long adminId) {
    	Map<String, Object> map = new ConcurrentHashMap<>();
        List<UmsPermissionEntity> permissionList = adminService.getPermissionList(adminId);
        map.put("permission", permissionList);
        return map;
    }
    
}
