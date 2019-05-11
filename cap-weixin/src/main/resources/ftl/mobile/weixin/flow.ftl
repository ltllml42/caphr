<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>检测项目</title>
<link rel="stylesheet" href="${re.contextPath}/plugin/lib/weui.css">
    <link rel="stylesheet" href="${re.contextPath}/plugin/css/jquery-weui.css">
    <link rel="stylesheet" href="${re.contextPath}/plugin/css/demos.css">
<link href="${re.contextPath}/plugin/css/timeline.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${re.contextPath}/plugin/js/modernizr.js"></script>
<script type="text/javascript" src="${re.contextPath}/plugin/js/jquery-1.8.3.min.js"></script>

</head>
<body>

<header class="wy-header">
    <a href="http://www.baidu.com"><div class="wy-header-icon-back"><span></span></div></a>
    <div class="wy-header-title"><h3>历史查询</h3></div>
</header>



	<section id="cd-timeline" class="cd-container">
		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-picture">
				<img src="${re.contextPath}/plugin/images/cd-icon-movie.svg" alt="Picture">
			</div><!-- cd-timeline-img -->

			<div class="cd-timeline-content">
				<h2> 9:10:15 </h2>
				<p>入场检查</p>
				<span class="cd-date">2019-12-23</span>
			</div> <!-- cd-timeline-content -->
		</div> <!-- cd-timeline-block -->

		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-picture">
				<img src="${re.contextPath}/plugin/images/cd-icon-movie.svg" alt="Movie">
			</div> <!-- cd-timeline-img -->
			<div class="cd-timeline-content">
				<h2>9:30:15</h2>
				<p>外观检测</p>
				<span class="cd-date">2019-12-23</span>
			</div> <!-- cd-timeline-content -->
		</div> <!-- cd-timeline-block -->

		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-picture">
				<img src="${re.contextPath}/plugin/images/cd-icon-movie.svg" alt="Movie">
			</div> <!-- cd-timeline-img -->
			<div class="cd-timeline-content">
				<h2>9:30:15</h2>
				<p>上线检测</p>
				<span class="cd-date">2019-12-23</span>
			</div> <!-- cd-timeline-content -->
		</div> <!-- cd-timeline-block -->
		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-picture">
				<img src="${re.contextPath}/plugin/images/cd-icon-movie.svg" alt="Movie">
			</div> <!-- cd-timeline-img -->
			<div class="cd-timeline-content">
				<h2>9:30:15</h2>
				<p>进入停车场</p>
				<span class="cd-date">2019-12-23</span>
			</div> <!-- cd-timeline-content -->
		</div> <!-- cd-timeline-block -->
		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-picture">
				<img src="${re.contextPath}/plugin/images/cd-icon-movie.svg" alt="Movie">
			</div> <!-- cd-timeline-img -->
			<div class="cd-timeline-content">
				<h2>9:30:15</h2>
				<p>缴费核算</p>
				<span class="cd-date">2019-12-23</span>
			</div> <!-- cd-timeline-content -->
		</div> <!-- cd-timeline-block -->
		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-picture">
				<img src="${re.contextPath}/plugin/images/cd-icon-movie.svg" alt="Movie">
			</div> <!-- cd-timeline-img -->
			<div class="cd-timeline-content">
				<h2>9:30:15</h2>
				<p>完成</p>
				<span class="cd-date">2019-12-23</span>
			</div> <!-- cd-timeline-content -->
		</div> <!-- cd-timeline-block -->

	</section> <!-- cd-timeline -->
	
<script type="text/javascript">
$(function(){
	var $timeline_block = $('.cd-timeline-block');
	//hide timeline blocks which are outside the viewport
	$timeline_block.each(function(){
		if($(this).offset().top > $(window).scrollTop()+$(window).height()*0.75) {
			$(this).find('.cd-timeline-img, .cd-timeline-content').addClass('is-hidden');
		}
	});
	//on scolling, show/animate timeline blocks when enter the viewport
	$(window).on('scroll', function(){
		$timeline_block.each(function(){
			if( $(this).offset().top <= $(window).scrollTop()+$(window).height()*0.75 && $(this).find('.cd-timeline-img').hasClass('is-hidden') ) {
				$(this).find('.cd-timeline-img, .cd-timeline-content').removeClass('is-hidden').addClass('bounce-in');
			}
		});
	});
});
</script>

</body>
</html>
