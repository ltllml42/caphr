<!DOCTYPE html>
<html>
  <head>
    <title>车辆历史记录</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="description" content="车辆历史记录">

<link rel="stylesheet" href="${re.contextPath}/plugin/lib/weui.css">
<link rel="stylesheet" href="${re.contextPath}/plugin/css/jquery-weui.css">
<link rel="stylesheet" href="${re.contextPath}/plugin/css/demos.css">

</head>

  <body>
	  	<div class="weui-cells weui-cells_form">
		  <div class="weui-cells__title">车辆基本信息</div>

			<div class="weui-cell " >
				<div class="weui-cell__hd" >
					<label class="weui-label">车牌号</label>
				</div>
				<div class="weui-cell__bd">
					<label class="weui-label">京A-CD123</label>
				</div>
				<div class="weui-cell__ft">
					<i class="weui-icon-warn"></i>
				</div>
			</div>
			<div class="weui-cell ">
				<div class="weui-cell__hd">
					<label class="weui-label">购车日期</label>
				</div>
				<div class="weui-cell__bd">
					<label class="weui-label">2010-12-23</label>
				</div>
				<div class="weui-cell__ft">
					<i class="weui-icon-warn"></i>
				</div>
			</div>
			<div class="weui-cells__title">验车时间</div>
			<div class="weui-cells">
				<a class="weui-cell weui-cell_access" href="javascript:void(0);">
					<div class="weui-cell__bd">
						<p>2019-12-23</p>
					</div>
					<div class="weui-cell__ft">
					</div>
				</a>
				<a class="weui-cell weui-cell_access" href="javascript:void(0)">
					<div class="weui-cell__bd">
						<p>2018-7-12</p>
					</div>
					<div class="weui-cell__ft">
					</div>
				</a>
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

    <script type="text/javascript">
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
