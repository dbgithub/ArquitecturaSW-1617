<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>DeustoBank</title>

		<!-- meta -->
		<meta charset="UTF-8">
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
		<link rel="stylesheet" href="js/resumen/nivo-lightbox/nivo-lightbox-theme.css">
	    <link rel="stylesheet" href="css/resumen/custom.css">

	    <!-- js -->
	    <script src="js/resumen/jquery.min.js"></script>
	    <script src="js/resumen/bootstrap.min.js"></script>
	    <script src="js/resumen/owl.carousel.min.js"></script>
		<script src="js/resumen/wow.min.js"></script>
		<script src="js/resumen/jquery.actual.min.js"></script>
	</head>

	<body data-spy="scroll" data-target="#navbar-example">

		<!-- ****************************** Preloader ************************** -->
		<div id="preloader"></div>


		<div id="wrapper">
			<div id="overlay-1">
				<section id="navigation-scroll">
					<nav class="navbar navbar-default navbar-fixed-top">
					  <div class="container">
					    <!-- Brand and toggle get grouped for better mobile display -->
					    <div class="navbar-header">
					      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-example">
					        <span class="sr-only">Toggle navigation</span>
					        <i class="fa fa-bars"></i>
					      </button>
					      <s:url var="urlCuentas" action="showResumen"></s:url>
						 <s:a href="%{urlCuentas}" class="navbar-brand" tooltip="Volver a las cuentas">DeustoBank</s:a>
<!-- 					      <a class="navbar-brand" href="#">DeustoBank</a> -->
					    </div>

					    <!-- Collect the nav links, forms, and other content for toggling -->
					    <div class="collapse navbar-collapse" id="navbar-example">
					      <ul class="nav navbar-nav navbar-right">
					        <li><a href="#about" class="active">Ingreso/Extracción</a></li>
	  						<li><a href="#our_service">Idioma</a></li>
					      </ul>
					    </div><!-- /.navbar-collapse -->
					  </div><!-- /.container-fluid -->
					</nav>	<!-- navbar -->
				</section>	<!-- #navigation -->
				

				<section id="starting">
					<div class="text-center starting-text wow animated zoomInDown">
						<h3 class="h3_header operacionesHeader">Operaciones</h3>
								<div class="cuadro_datos">
								<p>IBAN: <span><s:property value="IBAN"/></span></p>
								</div>
						<table>
						  <tr>
						    <th>Número</th>
						    <th>Fecha</th> 
						    <th>Tipo</th>
						    <th>Importe</th>
						  </tr>
						<s:iterator value="operaciones">
							<tr>
								<td><s:property value="id"/></td>
								<td><s:property value="fecha"/></td>
								<td><s:property value="tipo"/></td>
								<td><s:property value="importe"/></td>
							</tr>
						</s:iterator>
						</table>
					</div>
				</section>
				<div id="bottom" class="bottom text-center">
			        <a href="#about"><i class="ion-ios7-arrow-down"></i></a>
			    </div>
			</div><!-- overlay-1 -->
		</div>	<!-- wrapper -->		
			
		<!-- Ingreso/Extraccion -->
		<section id="about">
			<div class="container">
				<div class="row text-center heading">
					<div class="wow animated zoomInDown heading-text">
						<h3>Ingreso/Extracción</h3>
	                	<hr class="full">
	                	<br/>
					</div>
				</div>	<!-- row -->
				<div class="row about-us-text">
					<div class="col-md-12">
						<p class="text-center">Haz click sobre la opción que desea llevar a cabo :)</p>
					</div>
				</div>	<!-- row -->
				<div class="row main_content">
					<div class="col-md-4 col-sm-4 wow animated zoomIn opciones" data-wow-delay="0.1s">
						<figure>
										<!-- URL (STRUTS2) -->
										<s:url var="urlIngreso" action="showAddOperacion">
											<s:param name="IBAN" value="%{IBAN}" /> <%-- Otra forma: <s:param name="IBAN"><s:property value="IBAN"/></s:param> --%>
											<s:param name="tipooperacion">Ingreso</s:param> 
										</s:url>
							<s:a href="%{urlIngreso}" tooltip="Ingresar dinero">
								<img class="pro img-responsive center-block" src="imgs/ingreso.png" alt="image">
							</s:a>
						</figure>
						<s:a href="%{urlIngreso}" tooltip="Ingresar dinero"> 
							<h5 class="text-center">INGRESO</h5>
						</s:a>
					</div>	<!-- col-md-4 -->

					<div class="col-md-4 col-sm-4 wow animated zoomIn" data-wow-delay="0.1s">
						<figure>
										<!-- URL (STRUTS2) -->
										<s:url var="urlExtraccion" action="showAddOperacion">
											<s:param name="IBAN" value="%{IBAN}" /> <%-- Otra forma: <s:param name="IBAN"><s:property value="IBAN"/></s:param> --%>
											<s:param name="tipooperacion">Extracción</s:param> 
										</s:url>
							<s:a href="%{urlExtraccion}" tooltip="Extraer dinero">
								<img class="pro img-responsive center-block" src="imgs/extraccion.png" alt="image">
							</s:a>
						</figure>
						<s:a href="%{urlExtraccion}" tooltip="Extraer dinero"> 
							<h5 class="text-center">EXTRACCION</h5>
						</s:a>
					</div>	<!-- col-md-4 -->
				</div><!-- row main_content -->
			</div>	<!-- container -->
		</section>	<!-- about us -->

		<!-- Idioma -->
		<section id="our_service">
			<div class="container">
				<div class="row text-center heading">
	        		<div class="wow animated zoomInDown heading-text">
	        			<h3>Idioma</h3>
	                	<hr class="full">
	                	<br/>
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
				        				<p>
				        					Si prefieres ver el contenido de este resumen de la banca online en castellano, ¡haz click aquí!
				        				</p>	
			        				</div> <!-- .text-center -->
			        			</div> <!-- .service -->
			        		</div> <!-- .col-md-3 -->
			        		<div class="col-md-3 col-sm-6 idiomas2">
			        			<div class="service">
			        				<img src="imgs/service3.png" alt="service1">
			        				<div class="text-center">
				        				<h4>Inglés</h4>
				        				<p>
				        					Si prefieres ver el contenido de este resumen de la banca online en inglés porque te va ese rollo 'cool', ¡haz click aquí!
				        				</p>	
			        				</div> <!-- .text-center -->
			        			</div> <!-- .service -->
			        		</div> <!-- .col-md-3 -->
			        	</div>
					</div>	<!-- services -->
				</div>	<!-- main_content -->
			</div>	<!-- container -->
		</section>	<!-- our_service -->
			
		<!-- footer -->
		<section id="footer" class="main-footer">
			<div class="container">
				<p>&copy; 2015 themewagon.com</p>
				<a href="#starting" class="up">&uarr;</a>
			</div>
		</section><!-- footer -->

		<!-- js -->
		<script>
 			new WOW().init();
		</script>
		<script>
			$( function() {
  
			  // change is-checked class on buttons
			  	$('.button-group').each( function( i, buttonGroup ) 
			  	{
			    	var $buttonGroup =$( buttonGroup );
			    	$buttonGroup.on( 'click', 'button', function() 
			    	{
			      		$buttonGroup.find('.is-checked').removeClass('is-checked');
			      		$( this ).addClass('is-checked');
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
