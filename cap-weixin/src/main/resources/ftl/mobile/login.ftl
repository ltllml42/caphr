<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <link rel="stylesheet" href="css/jquery.mobile-1.4.5.css" />
	<link rel="stylesheet" href="themes/skyd.min.css" />
	<link rel="stylesheet" href="themes/jquery.mobile.icons.min.css" />
    <link rel="stylesheet" href="css/jquery.mobile.theme-1.4.5.css" />
   	<link rel="stylesheet" href="css/jqm-demos.css" />
    

</head>
<body>




  <div data-role="page" id="login">
        <div data-role="header" data-theme="b">
            <h1>车检管理系统</h1>
        </div>
        <div data-role="content">
            <form method="post" action="#" onSubmit="return isOk();">
              <div data-role="fieldcontain">
              	<h2>用户登录</h2>
                <input type="text" name="username" id="username" placeholder="用户名">
                <input type="password" name="password" id="password" placeholder="密码">
                <select name="switch" id="switch" data-role="slider">
                  <option value="on">保存</option>
                  <option value="off">不保存</option>
                </select>
                <input type="submit" data-role="button" value="登录">
              </div>
            </form>  
        </div>
          <div data-role="footer" data-position="fixed" data-theme="b">
			    <h1>版权:北京兴通爱民机动车检测有限公司</h1>
			  </div>
		</div> 	
		
        
        
    </div>
        




	
	
	



	
</body>
	<script type="text/javascript">
		function isOk(){
			window.location.href = "/main";
		}
	
	</script>
	<script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.mobile-1.4.5.js" ></script>

</html>