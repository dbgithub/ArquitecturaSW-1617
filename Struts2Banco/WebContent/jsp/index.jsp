<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">

  <title>DeustoBank | <s:text name="application.title"/></title>

    <style>
@import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);
@import url(http://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300);

body{
	margin: 0;
	padding: 0;
	background: #000;
	overflow: hidden;
	color: #fff;
	font-family: Arial;
	font-size: 12px;
}

.body{
	position: absolute;
	/*top: -20px;*/
	left: -20px;
	/*right: -40px;
	bottom: -40px;*/
	width: 105%;
	height: 100%;
	background-image: url(<s:url value="imgs/university.jpg"/>); /* Ojo, si pones el tag de Struts2 's:url' entonces la URI de dentro tienes que acortarla porque coge como base otro directorio. Si no pones el tag, entonces, la URI es relativa*/
	background-size: cover;
	background-size: 115% 115%;
	-webkit-filter: blur(5px);
	z-index: 0;
}

.grad{
	position: absolute;
	/*top: -20px;*/
	left: -20px;
	/*right: -40px;
	bottom: -40px;*/
	width: 105%;
	height: 100%;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65))); /* Chrome,Safari4+ */
	z-index: 1;
	opacity: 0.7;
}

.header{
	position: absolute;
	top: calc(50% - 35px);
	left: calc(50% - 255px);
	z-index: 2;
}

.header div{
	float: left;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 35px;
	font-weight: 200;
}

.header div span{
	color: #5379fa !important;
}

.inputerror {
	/*visibility: hidden;
	position:absolute;*/
	margin-top: 10px;
	padding: 9px;
	color: red;
	background-color: #0a113266;
}
.login{
	position: absolute;
	top: calc(50% - 75px);
	left: calc(50% - 50px);
	height: 150px;
	width: 350px;
	padding: 10px;
	z-index: 2;
}

.login input[type=text]{
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
}

.login input[type=password]{
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
	margin-top: 10px;
}

.login input[type=submit]{
	width: 260px;
	height: 35px;
	background: #fff;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: #a18d6c;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 6px;
	margin-top: 10px;
}

.login input[type=submit]:hover{
	opacity: 0.8;
}

.login input[type=submit]:active{
	opacity: 0.6;
}

.login input[type=text]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=password]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=submit]:focus{
	outline: none;
}

::-webkit-input-placeholder{
   color: rgba(255,255,255,0.6);
}

::-moz-input-placeholder{
   color: rgba(255,255,255,0.6);
}
</style>

    <script src="<s:url value="js/prefixfree.min.js"/>"></script> <!-- Ojo, si pones el tag de Struts2 's:url' entonces la URI de dentro tienes que acortarla porque coge como base otro directorio. Si no pones el tag, entonces, la URI es relativa-->

</head>

<body>

 	<div class="body"></div>
	<div class="grad"></div>
	<div class="header">
		<div>Deusto<span>Bank</span></div>
	</div>
	<br>
	<div class="login">
	<s:form action="doLogin" method="POST" validate="true"> 
		<s:textfield name="DNI" placeholder="DNI"/><br>
		<s:password name="PIN" placeholder="PIN"/><br>
		<s:submit type="input" value="%{getText('submit.value')}"/>
		
	</s:form>
		<div class="inputerror">
			<s:actionerror />
			<s:fielderror />
		</div>
	</div>

  <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>

</body>

</html>