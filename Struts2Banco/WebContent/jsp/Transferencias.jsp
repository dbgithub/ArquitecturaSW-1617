<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- css -->
<link rel="stylesheet" href="css/resumen/bootstrap.min.css">
<!-- <link rel="stylesheet" href="css/ionicons.min.css"> -->
<link rel="stylesheet" href="css/resumen/font-awesome.min.css">
<link rel="stylesheet" href="css/resumen/owl.carousel.css">
<link rel="stylesheet" href="css/resumen/owl.theme.css">
<link rel="stylesheet" href="css/resumen/owl.transitions.css">
<link rel="stylesheet" href="css/resumen/animate.css">
<link rel="stylesheet" href="js/resumen/nivo-lightbox/nivo-lightbox.css">
<link rel="stylesheet"
	href="js/resumen/nivo-lightbox/nivo-lightbox-theme.css">
<link rel="stylesheet" href="css/resumen/custom.css">

<!-- js -->
<script src="js/resumen/jquery.min.js"></script>
<script src="js/resumen/bootstrap.min.js"></script>
<script src="js/resumen/owl.carousel.min.js"></script>
<script src="js/resumen/wow.min.js"></script>
<script src="js/resumen/jquery.actual.min.js"></script>
</head>
<title>Deusto Bank</title>
</head>
<body data-spy="scroll" data-target="#navbar-example">
	<!-- ****************************** Preloader ************************** -->

	<div id="wrapper">
		<div id="overlay-1">
			<section id="navigation-scroll">
				<nav class="navbar navbar-default navbar-fixed-top">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse" data-target="#navbar-example">
								<span class="sr-only">Toggle navigation</span> <i
									class="fa fa-bars"></i>
							</button>
							<s:url var="urlCuentas" action="showResumen"></s:url>
							<s:a href="%{urlCuentas}" class="navbar-brand" tooltip="Volver a las cuentas">DeustoBank</s:a>
							<!-- <a class="navbar-brand" href="#">DeustoBank</a> -->
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="navbar-example">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="#about" class="active">¿Qué puedo hacer?</a></li>
								<li><a href="#our_service">Idioma</a></li>
							</ul>
						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
				<!-- navbar -->

			</section>

			<section id="starting">
				<div class="starting-text wow animated zoomInDown">

					<h2 class="text-center ">Area de transferencias</h2>

					<s:form action="addIngreso" method="POST" validate="true">

						<s:select label="Tranferir desde la cuenta" class="form-control"
							list="ibanescliente" name="cuentaorigen">
						</s:select>

						<s:select label="CuentaDestino" class="form-control"
							list="todosibanes" name="cuentadestino">

						</s:select>

						<s:textfield label="Importe" name="importe" />


						<s:submit class="btn btn-primary" value="Transferir"></s:submit>

						<div class="inputerror">
							<s:actionerror />
							<s:fielderror />
						</div>

					</s:form>
				</div>
			</section>
		</div>

		<!-- Que puedo hacer -->
		<section id="about">
			<div class="container">
				<div class="row text-center heading">
					<div class="wow animated zoomInDown heading-text">
						<h3>¿Qué puedo hacer?</h3>
						<hr class="full">
						<br />
					</div>
				</div>
				<!-- row -->
				<div class="row about-us-text">
					<div class="col-md-12">
						<p class="text-center">¡Esta es tu página de banca online!
							Aquí puedes visualizar que cuentas tienes habilitadas con
							DeustoBank. Puedes consultar las operaciones de las mismas y ver
							detalles de la cuenta. Si accedes a las operaciones de cada
							cuenta, podrás ingresar y extraer dinero cómodamente. :)</p>
					</div>
				</div>
				<!-- row -->
				<div class="row main_content">
					<div class="col-md-4 col-sm-4 wow animated zoomIn"
						data-wow-delay="0.1s">
						<figure>
							<img class="pro img-responsive center-block"
								src="imgs/3-col-icons-web.png" alt="image">
						</figure>
						<h5 class="text-center">VER DETALLES</h5>
					</div>
					<!-- col-md-4 -->

					<div class="col-md-4 col-sm-4 wow animated zoomIn"
						data-wow-delay="0.1s">
						<figure>
							<img class="pro img-responsive center-block"
								src="imgs/3-col-icons-android.png" alt="image">
						</figure>
						<h5 class="text-center">OPERACIONES</h5>
					</div>
					<!-- col-md-4 -->

					<div class="col-md-4 col-sm-4 wow animated zoomIn"
						data-wow-delay="0.1s">
						<figure>
							<img class="pro img-responsive center-block"
								src="imgs/3-col-icons-iphone.png" alt="image">
						</figure>
						<h5 class="text-center">CUENTAS</h5>
					</div>
					<!-- col-md-4 -->
				</div>
				<!-- row main_content -->
			</div>
			<!-- container -->
		</section>
		<!-- about us -->

		<!-- Idioma -->
		<section id="our_service">
			<div class="container">
				<div class="row text-center heading">
					<div class="wow animated zoomInDown heading-text">
						<h3>Idioma</h3>
						<hr class="full">
						<br />
					</div>
				</div>
				<div class="main_content">
					<div class="services">
						<div class="row">
							<div class="col-md-3 col-sm-6 idiomas1 idiomas2">
								<div class="service">
									<img src="imgs/service2.png" alt="service1">
									<div class="text-center">
										<h4>Español</h4>
										<p>Si prefieres ver el contenido de este resumen de la
											banca online en castellano, ¡haz click aquí!</p>
									</div>
									<!-- .text-center -->
								</div>
								<!-- .service -->
							</div>
							<!-- .col-md-3 -->
							<div class="col-md-3 col-sm-6 idiomas2">
								<div class="service">
									<img src="imgs/service3.png" alt="service1">
									<div class="text-center">
										<h4>Inglés</h4>
										<p>Si prefieres ver el contenido de este resumen de la
											banca online en inglés porque te va ese rollo 'cool', ¡haz
											click aquí!</p>
									</div>
									<!-- .text-center -->
								</div>
								<!-- .service -->
							</div>
							<!-- .col-md-3 -->
						</div>
					</div>
					<!-- services -->
				</div>
				<!-- main_content -->
			</div>
			<!-- container -->
		</section>
		<!-- our_service -->

		<!-- footer -->
		<section id="footer" class="main-footer">
			<div class="container">
				<p>&copy; 2015 themewagon.com</p>
				<a href="#starting" class="up">&uarr;</a>
			</div>
		</section>
		<!-- footer -->

		<!-- js -->
		<script>
			new WOW().init();
		</script>
		<script>
			$(function() {

				// change is-checked class on buttons
				$('.button-group').each(
						function(i, buttonGroup) {
							var $buttonGroup = $(buttonGroup);
							$buttonGroup.on('click', 'button', function() {
								$buttonGroup.find('.is-checked').removeClass(
										'is-checked');
								$(this).addClass('is-checked');
							});
						});

			});
		</script>
		<script src="js/resumen/jquery-ui-1.10.3.min.js"></script>
		<script src="js/resumen/jquery.knob.js"></script>
		<script src="js/resumen/daterangepicker.js"></script>
		<script src="js/resumen/bootstrap3-wysihtml5.all.min.js"></script>
		<script src="js/resumen/smoothscroll.js"></script>
		<script src="js/resumen/nivo-lightbox/nivo-lightbox.min.js"></script>
		<script src="js/resumen/script.js"></script>
</body>
</html>