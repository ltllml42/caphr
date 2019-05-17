<!DOCTYPE html>
<html>
  <head>
<title>车辆绑定</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="description" content="车辆查询">
<link rel="stylesheet" href="${re.contextPath}/plugin/lib/weui.css">
<link rel="stylesheet" href="${re.contextPath}/plugin/css/jquery-weui.css">
<link rel="stylesheet" href="${re.contextPath}/plugin/css/demos.css">

</head>
  <body>
	  	<div class="weui-cells weui-cells_form">
		  <div class="weui-cells__title">个人信息</div>
			<div class="weui-cells">
			<a class="weui-cell weui-cell_access" href="javascript:void(0);">
			  <div class="weui-cell__hd"><img height="80px" width="80px" src="${fans.headImgUrl}"></div>
			  <div class="weui-cell__bd">
				<p>${fans.nick_name}</p>
			  </div>
			  <div class="weui-cell__ft">
			  </div>
			</a>
		</div>
	  <div class="weui-cell">
		  <div class="weui-cell__hd"><label class="weui-label">姓名</label></div>
		  <div class="weui-cell__bd">
		  		${fans.name}
		  </div>
	    <div class="weui-cell__ft">
	      <i class="weui-icon-warn"></i>
	    </div>
	   </div>
		 <div class="weui-cell">
		  <div class="weui-cell__hd"><label class="weui-label">性别</label></div>
		  <div class="weui-cell__bd">
		  		${fans.sexDesc}
		  </div>
		 </div>
		 <!--weui-cell_vcode-->
		 <div class="weui-cell ">
		 	
		  <div class="weui-cell__hd"><label class="weui-label">手机</label></div>
		  <div class="weui-cell__bd">
		  		${fans.telPhone}
		  </div>
		  <div class="weui-cell__ft">
	      <i class="weui-icon-warn"></i>
	   </div>
		 </div>
	</div>

        <div class="weui-cells__title">车辆信息</div>
        <div class="weui-cells">
          <div class="weui-cell">
            <div class="weui-cell__hd">
              <p>车牌号</p>
            </div>
            <div class="weui-cell__bd left_150">
              <p>年检次数</p>
            </div>
            <div class="weui-cell__ft">向左滑动编辑</div>
          </div>
          <div class="weui-cell weui-cell_swiped">
            <div class="weui-cell__bd">
              <div class="weui-cell">
              	<div class="weui-cell__hd">
					<p>${cvInfo.plateNo}</p>
              	</div>
                <div class="weui-cell__bd left_150 " >
					<#assign wxUser = Session["weiXinUser"]>
                 	 <p><a href="${re.contextPath}/oauth2/${wxUser.appid}/${cvInfo.id}/hisTestMsg">${cvInfo.yearCheckCount}</a></p>
                </div>

                <div class="weui-cell__ft"></div>
              </div>
            </div>
            <div class="weui-cell__ft">
              <a class="weui-swiped-btn weui-swiped-btn_warn delete-swipeout" href="${re.contextPath}/oauth2/${wxUser.appid}/${cvInfo.id}/del">解除</a>
            </div>
         </div>
        </div>
  
	    <style>
	      .weui-footer {
	        margin: 25px 0 10px 0;
	      }
	    </style>
	<script src="${re.contextPath}/plugin/lib/jquery-2.1.4.js"></script>
	<script src="${re.contextPath}/plugin/js/jquery-weui.js"></script>
	<script src="${re.contextPath}/plugin/js/carnum-picker.js"></script>
	<script src="${re.contextPath}/plugin/lib/fastclick.js"></script>

    <script>
      $('.delete-swipeout').click(function () {
      		var delEle=$(this);
      	$.confirm("您确定要删除吗", function() {
		   	$(delEle).parents('.weui-cell').remove();
		  }, function() {
		   	$(delEle).parents('.weui-cell').swipeout('close')
		});
      })
      $('.close-swipeout').click(function () {
        	$(this).parents('.weui-cell').swipeout('close')
      })
    </script>

<script>
  $(function() {
  	
    FastClick.attach(document.body);
  });
</script>
  </body>
</html>
