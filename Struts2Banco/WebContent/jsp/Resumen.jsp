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
					      <a class="navbar-brand" href="#">DeustoBank</a>
					    </div>

					    <!-- Collect the nav links, forms, and other content for toggling -->
					    <div class="collapse navbar-collapse" id="navbar-example">
					      <ul class="nav navbar-nav navbar-right">
					        <li><a href="#about" class="active"><s:text name="li.quepuedo"/></a></li>
	  						<li><a href="#our_service"><s:text name="li.idioma"/></a></li>
					      </ul>
					    </div><!-- /.navbar-collapse -->
					  </div><!-- /.container-fluid -->
					</nav>	<!-- navbar -->
				</section>	<!-- #navigation -->
				

				<section id="starting">
					<div class="text-center starting-text wow animated zoomInDown">
						<h2><s:text name="welcome"/>, <s:if test="nombre == null"><s:property value="#session.nombre"/></s:if><s:else><s:property value="nombre"/></s:else></h2>
						<h3 class="h3_header"><s:text name="header.cuentas"/></h3>
								<div class="cuadro_datos">
								<!-- Dentro de un 'if' statement en Struts2 no hace falta poner un s.property, porque Struts2 entiende que estas accediendo ahi.
								Mas info en: http://stackoverflow.com/questions/8656698/struts-property-tag-inside-struts-if-tag -->
								<!-- No es necesario poner la almohadilla delante de la variable, pero puedes ponerlo si quieres, ej. #DNI -->
								<p><s:text name="p.DNI"/>: <span><s:if test="DNI == null"><s:property value="#session.dni"/></s:if><s:else><s:property value="DNI"/></s:else></span></p>
								<p><s:text name="p.Email"/>: <span><s:if test="Email == null"><s:property value="#session.email"/></s:if><s:else><s:property value="Email"/></s:else></span></p>
								<p><s:text name="p.Movil"/>: <span><s:if test="Movil == null"><s:property value="#session.movil"/></s:if><s:else><s:property value="Movil"/></s:else></span></p>
								</div>
						<table>
						  <tr>
						    <th>IBAN</th>
						    <th>SWIFT</th> 
						    <th><s:text name="th.fechaapertura"/></th>
						    <th><s:text name="th.activa"/></th>
						    <th><s:text name="th.saldo"/></th>
						    <th><s:text name="th.interes"/></th>
						  </tr>
						<s:iterator value="cuentas">
							<tr>
								<td>
								<s:url var="urlIBAN" action="showOperaciones">
									<s:param name="IBAN" value="%{IBAN}" /> <%-- Otra forma: <s:param name="IBAN"><s:property value="IBAN"/></s:param> --%>
								</s:url>
								<s:a href="%{urlIBAN}" tooltip="%{getText('tooltip.veroperaciones')}"><s:property value="IBAN"/></s:a>
								</td>
								<td><s:property value="SWIFT"/></td>
								<td><s:property value="fechaApertura"/></td>
								<td><s:property value="activa"/></td>
								<td><s:property value="saldoActual"/></td>
								<td><s:property value="interes"/></td>
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
			
		<!-- Que puedo hacer -->
		<section id="about">
			<div class="container">
				<div class="row text-center heading">
					<div class="wow animated zoomInDown heading-text">
						<h3><s:text name="li.quepuedo"/></h3>
	                	<hr class="full">
	                	<br/>
					</div>
				</div>	<!-- row -->
				<div class="row about-us-text">
					<div class="col-md-12">
						<p class="text-center"><s:text name="application.explicacion"/></p>
					</div>
				</div>	<!-- row -->
				<div class="row main_content">
					<div class="col-md-4 col-sm-4 wow animated zoomIn" data-wow-delay="0.1s">
						<figure>
							<img class="pro img-responsive center-block" src="imgs/3-col-icons-web.png" alt="image">
						</figure>
						<h5 class="text-center"><s:text name="application.feature1"/></h5>
					</div>	<!-- col-md-4 -->

					<div class="col-md-4 col-sm-4 wow animated zoomIn" data-wow-delay="0.1s">
						<figure>
							<img class="pro img-responsive center-block" src="imgs/3-col-icons-android.png" alt="image">
						</figure>
						<h5 class="text-center"><s:text name="application.feature2"/></h5>
					</div>	<!-- col-md-4 -->

					<div class="col-md-4 col-sm-4 wow animated zoomIn" data-wow-delay="0.1s">
						<figure>
							<img class="pro img-responsive center-block" src="imgs/3-col-icons-iphone.png" alt="image">
						</figure>
						<h5 class="text-center"><s:text name="application.feature3"/></h5>
					</div>	<!-- col-md-4 -->
				</div><!-- row main_content -->
			</div>	<!-- container -->
		</section>	<!-- about us -->

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
													<s:param name="jsp">resumen</s:param>
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
													<s:param name="jsp">resumen</s:param>
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
