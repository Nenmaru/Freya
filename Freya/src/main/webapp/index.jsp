<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
<%@ include file='../WEB-INF/jspf/lib/libs.jspf'%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Freya bot</title>
</head>
<body>
	<%@ include file="../WEB-INF/jspf/header.jspf"%>
	<div class="container-fluid">
		<!--CONTAINER START-->
		<div class="row-fluid">
			<%@ include file="../WEB-INF//jspf/navigation.jspf"%>
			<!--MAIN INTERFACE START-->
			<div class="span6">
				<div class="hero-unit well">
					<textarea id="redex" maxlength="0" rows="12" style="width: 100%;"></textarea>
					<br>
					<form class="form-search btn-block pull-right"
						action="ajaxResponse" method="GET">
						<div class="input-append span12" style="width: 100%;">
							<input type="text" min="1" class="inputter search-query span12"
								style="width: 80%;">
							<button onclick="submit" class="btn btn-primary pull-right"
								style="width: 20%;">Отправить</button>
						</div>
					</form>
				</div>
				<!--DISHES LIST START-->
				<div class="row-fluid"></div>
				<!--DISHES LIST END-->
			</div>
			<!--MAIN INTERFACE END-->
			<%@ include file="../WEB-INF/jspf/image.jspf"%>
		</div>
		<!--CONTAINER END-->
		<%@ include file="../WEB-INF/jspf/footer.jspf"%>
	</div>
</body>
<style type="text/css">
#redex {
	resize: none;
}
</style>
</html>