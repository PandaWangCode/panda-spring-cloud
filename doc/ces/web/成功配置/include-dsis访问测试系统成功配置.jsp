<%@ page language="java" import="java.util.ResourceBundle" contentType="text/html; charset=UTF-8" %>
<%
  String path = request.getContextPath(); 
  String basePath = ""; 
  String sessionID = session.getId();
  String serverName = request.getServerName();
  String addr = request.getRemoteAddr();

  ResourceBundle resource = ResourceBundle.getBundle("setting");
  String vistorHttpIp = resource.getString("VISTOR_HTTP_IP"); 
  String vistorHttpsIp = resource.getString("VISTOR_HTTPS_IP");
  if(vistorHttpIp.contains(serverName)){   // http局域网请求格式：https//10.1.19.69:8081/pubcen/
		basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	}
  if(vistorHttpsIp.contains(serverName) ){   //https代理请求格式：https://10.1.21.203/pubcen/
	    basePath = "https://" + serverName+ path + "/";
	}
  basePath = "https://10.8.21.11/pubcen/";
  basePath = "https://dsis.acca.com.cn/pubcen/";
  
%>
<!DOCTYPE html>
<html lang="cn">
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

 <script type="text/javascript">
 var basePath = '<%=basePath%>';
 var sessionID = '<%=sessionID%>';
 var addr = '<%=addr%>';
</script> 


<!-- End of Libraries -->