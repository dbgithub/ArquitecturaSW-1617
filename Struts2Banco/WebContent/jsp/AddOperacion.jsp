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
	  						<li><a href="#our_service"><s:text name="li.idioma"/></a></li>
					      </ul>
					    </div><!-- /.navbar-collapse -->
					  </div><!-- /.container-fluid -->
					</nav>	<!-- navbar -->
				</section>	<!-- #navigation -->
				

				<section id="starting">
					<div class="text-center starting-text wow animated zoomInDown">
						<h3 class="h3_header operacionesHeader"><s:text name="header.realizaroperacion"/></h3>
								<div class="cuadro_datos">
								<p>IBAN: <span><s:property value="IBAN"/></span></p>
								</div>
								
					<s:form action="addOperacion" method="POST" validate="true">
						<s:textfield label="%{getText('p.importecantidad')}" name="importe" placeholder="Importe" tooltip="%{getText('tooltip.importeeuros')}" />
						<br>
						<s:select label="%{getText('p.tipo')}" name="tipo" list="tipos" value="tipos[tipooperacion]" headerKey="" headerValue="%{getText('form.select.tipo')}"></s:select>
						<br>
						<s:submit type="input" value="%{getText('submit.enviar')}" />
						<s:reset value="%{getText('submit.resetear')}" />
						<s:hidden name="IBAN" value="%{IBAN}" />
					</s:form>
					<div class="inputerror">
						<s:actionerror />
						<s:fielderror />
					</div>
					</div>
				</section>
				<div id="bottom" class="bottom text-center">
			        <a href="#about"><i class="ion-ios7-arrow-down"></i></a>
			    </div>
			</div><!-- overlay-1 -->
		</div>	<!-- wrapper -->		
			
		<!-- Idioma -->
		<section id="our_service">
			<div class="container">
				<div class="row text-center heading">
	        		<div class="wow animated zoomInDown heading-text">
	        			<h3><s:text name="li.idioma"/></h3>
	                	<hr class="full">
	                	<br/>
	        		</div>
		        </div>
			    <div class="main_content">
				    <div class="services">
			        	<div class="row">
			        		<div class="col-md-3 col-sm-6 idiomas1 idiomas2">
			        			<div class="service">
			        							<!-- URL (STRUTS2) -->
												<s:url var="i18n_es" action="i18n">
													<s:param name="request_locale">es</s:param>
													<s:param name="jsp">addoperacion</s:param>
												</s:url>
								<s:a href="%{i18n_es}" tooltip="">
									<img src="imgs/service2.png" alt="service1">									
								</s:a>
			        				<div class="text-center">
				        				<h4><s:text name="idioma.espanol"/></h4>
				        				<p>
				        					<s:text name="idioma.espanol.explicacion"/>
				        				</p>	
			        				</div> <!-- .text-center -->
			        			</div> <!-- .service -->
			        		</div> <!-- .col-md-3 -->
			        		<div class="col-md-3 col-sm-6 idiomas2">
			        			<div class="service">
			        							<!-- URL (STRUTS2) -->
												<s:url var="i18n_en" action="i18n">
													<s:param name="request_locale">en</s:param>
													<s:param name="jsp">addoperacion</s:param>
												</s:url>
								<s:a href="%{i18n_en}" tooltip="">							
			        				<img src="imgs/service3.png" alt="service1">
								</s:a>
			        				<div class="text-center">
				        				<h4><s:text name="idioma.english"/></h4>
				        				<p>
				        					<s:text name="idioma.english.explicacion"/>
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
