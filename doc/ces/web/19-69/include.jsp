<%@ page language="java" import="java.util.ResourceBundle" contentType="text/html; charset=UTF-8" %>
<%
  String path = request.getContextPath(); 
  String basePath = ""; 
  String sessionID = session.getId();
  String serverName = request.getServerName();
  String addr = request.getRemoteAddr();
  String servrPort = String.valueOf(request.getServerPort());
  /**
  	CLOUD:云平台；
  	CLOUD-TEST：云平台测试；
  	PUBCEN：来源NCS，或者直接访问信息发布中心PUBCEN；
  	PUBCEN-TEST:来源NCS测试系统，或者直接访问信息发布中心PUBCEN测试系统；
  	LOCALHOST：来源本地调试；
  	DSIS：来源DSIS生产；
  **/
  String userSource = ""; //保存用户访问来源的平台 
  
/*   ResourceBundle resource = ResourceBundle.getBundle("setting");
     String vistorHttpIp = resource.getString("VISTOR_HTTP_IP"); 
  } */
  
  /*特殊处理的原因：云平台的：request.getContextPath() 获取的值：pubcen/ncsrpt/view/003/ ,
        正常获取的：request.getContextPath() 获取的值：pubcen/   */
  
  /* 一、原始：https协议 (因DSIS和CLOUD都是以https协议为主)
     1、云平台生产:IP和域名访问 (10.1.21.203,cloud.acca.com.cn)*/
  basePath = "https://"+request.getServerName()+"/pubcen/";
  userSource = "CLOUD";
		  
  /* 二、https协议 特殊处理原因：必须带8443端口，获取到的端口是80，这里写死处理：8443
     1、云平台测试:IP访问 (10.1.17.140)  */
  if("10.1.17.140".contains(serverName)){ 
	  basePath = "https://"+request.getServerName()+":8443/pubcen/";
	  userSource = "CLOUD-TEST";
  } 
  
  /* 三、http协议
    1、清算生产访问、
    2、10.1.21.246直接访问  */
  if("10.1.21.246,10.1.19.69".contains(serverName)){ 
		 basePath = "http://"+request.getServerName()+":"+request.getServerPort()+"/pubcen/";
		 if("10.1.21.246".contains(serverName)){
		 	userSource = "PUBCEN";
		 }
		 if("10.1.19.69".contains(serverName)){
			 userSource = "PUBCEN-TEST";
		 }
	  } 
  
   /* 四、http协议
        本地localhost访问，路径更换  */
   if("localhost".contains(serverName)){ 
		 basePath = "http://"+request.getServerName()+":"+request.getServerPort()+"/pubcen-web/";
		 userSource = "LOCALHOST";
    }
   
   /* 五、DSIS生产：域名访问 (dsis.acca.com.cn) 一定要放在最后处理,
              此时servername = 10.1.21.246,对第三步重新覆写，根据address IP地址判断  */
   if("10.8.21.11".contains(addr)){ 
	   basePath = "https://dsis.acca.com.cn/pubcen/";
	   userSource = "DSIS";
   } 
   
   String requstUrl = request.getRequestURL().toString();
  
%>
<!DOCTYPE html>
<html lang="cn" class="panel-fit">
<base href="<%=basePath%>">

<!-- Meta -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="新清算系统-NCS" />
<meta name="description" content="新清算系统-NCS" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<!-- 解决跨域问题  -->
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<!-- 如果安装了GCF，则使用GCF来渲染页面，如果为安装GCF，则使用最高版本的IE内核进行渲染  -->
<!-- End of Meta -->

<title>清算信息发布中心</title>
<link rel="icon" href="./img/logo/travelsky.ico" type="image/x-icon" />
<link rel="shortcut icon" href="./img/logo/travelsky.ico" type="image/x-icon" />

<!-- Libraries -->

<!-- Themes -->
<link rel="stylesheet" type="text/css" href="./css/generic.css">
<link rel="stylesheet" type="text/css" href="./themes/metro-blue/easyui.css">
<link rel="stylesheet" type="text/css" href="./themes/icon.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">


<script type="text/javascript" src="./js/lib/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="./js/lib/jquery.easyui.min.js"></script>
<script type="text/javascript" src="./js/lib/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="./js/lib/cookie.js"></script>


<script type="text/javascript" src="./js/base/settings.js"></script>
<script type="text/javascript" src="./js/base/window.js"></script>
<script type="text/javascript" src="./js/base/datagrid.js"></script>
<script type="text/javascript" src="./js/base/messager.js"></script>
<script type="text/javascript" src="./js/base/validatebox.js"></script>
<script type="text/javascript" src="./js/base/object.js"></script>
<script type="text/javascript" src="./js/base/format.js"></script>
<script type="text/javascript" src="./js/base/easyui.datebox.js"></script>
<script type="text/javascript" src="./js/base/easyui.datebox.yearmonth.js"></script>
<script type="text/javascript" src="./js/base/datagrid-detailview.js"></script>
<script type="text/javascript" src="./js/base/easyui.combobox.multiple.js"></script>
<script type="text/javascript" src="./js/base/datagrid-export.js"></script>

 <script type="text/javascript">
 	var basePath = '<%=basePath%>';
 	var sessionID = '<%=sessionID%>';
 	var addr = '<%=addr%>';
 	var serverName = '<%=serverName%>';
 	var requstUrl = '<%=requstUrl%>';
 	var userSource = '<%=userSource%>';
	<!-- End of Libraries -->
 </script>
