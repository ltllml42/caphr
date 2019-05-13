<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <link rel="stylesheet" href="${re.contextPath}/plugin/jmq/css/jquery.mobile-1.4.5.css"/>
    <link rel="stylesheet" href="${re.contextPath}/plugin/jmq/css/jquery.mobile.theme-1.4.5.css"/>
    <link rel="stylesheet" href="${re.contextPath}/plugin/jmq/css/jqm-demos.css"/>
</head>
<body>
<!-- Session -->
  <div data-role="page" data-ajax = "false" id="login">
        <div data-role="header" data-theme="b">
            <h1>车检管理系统</h1>
        </div>
        <div data-role="content">
            <form id="logFrom" method="post" data-ajax="false" action="${re.contextPath}/login">
              <div data-role="fieldcontain">
              	<h2>用户登录</h2>
                  <input type="text" name="username" id="username" data-required="true" data-descriptions="username" data-describedby="username-description" placeholder="请输入用户名"><div id="username-description"></div>
                  <input type="password" name="password" id="password" data-required="true" data-descriptions="password" data-descriptions="password-description" placeholder="请输入密码"><div id="password-description"></div>
                  <input type="text" name="code"  data-required="true" data-descriptions="code" data-descriptions="code-description" style="width:150px;height:35px;" autocomplete="off" placeholder="输入验证码">
                  <div id="code-description"></div>
                  <img src="" id="code">
                  <input type="submit" data-role="button" value="登录">
              </div>
            </form>  
        </div>
          <div data-role="footer" data-position="fixed" data-theme="b">
			    <h1>版权:北京兴通爱民机动车检测有限公司</h1>
			  </div>
		</div>
          <div data-role="popup" id="messagePopup" class="ui-content" data-arrow="r">
              <p>在左边框有个方向。</p>
          </div>

    </div>
        




	
	
	



	
</body>
	<script type="text/javascript">


	</script>
    <script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/jmq/js/jquery-mvalidate.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/jmq/js/jquery.mobile-1.4.5.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/jmq/js/laytpl.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#code").click(function(){
                var url = "${re.contextPath}/getCode?"+new Date().getTime();
                this.src = url;
            }).click().show();
        });

        $("#logFrom").mvalidate({
            type:2,
            onKeyup:true,
            sendForm:true,
            firstInvalidFocus:true,
            valid:function(event,options){
                $("#logFrom").submit();
                //event.preventDefault();
            },
            invalid:function(event, status, options){
                //点击提交按钮时,表单未通过验证触发函数
            },
            eachField:function(event,status,options){
                //点击提交按钮时,表单每个输入域触发这个函数 this 执向当前表单输入域，是jquery对象
            },
            descriptions:{
                username:{
                    required : '<font color=red>请输入用户名</font>',
                    valid : '<font color=green>验证通过</font>'
                },
                password:{
                    required : '<font color=red>请输入密码</font>',
                    valid : '<font color=green>验证通过</font>'
                }
            },
            eachValidField:function(val){},
            eachInvalidField:function(event, status, options){}
        });

    </script>

</html>