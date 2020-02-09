<html>

	<head>
		<!-- Web page title -->
    	<title>Top Trumps</title>
    	
	<!-- Import JQuery, as it provides functions you will probably find useful (see https://jquery.com/) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/flick/jquery-ui.css">

	<!-- Optional Styling of the web page, for the demo I used Bootstrap (see https://getbootstrap.com/docs/4.0/getting-started/introduction/) -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="https://unpkg.com/nes.css/css/nes.min.css" rel="stylesheet" />
	<link href='http://fonts.googleapis.com/css?family=Press+Start+2P' rel='stylesheet' type='text/css'>
	
    <body>
    <div class="container">
    	<div class="row">
    	<div class="col-lg-12"></div>
    		<div class="row">
    		<div class="col-lg-12"></div>
    			<div class="container">
    				<div class="row"> 
    					<div class="col-lg-12">
    						<div id="setNumberOfOpponents">				
    							<h1> </h1>
								<select id="numberOfOpponents">
								</select>
 								<button class="nes-btn" style="position:relative;left:470px;" onclick="setNumberOfOpponents();">Play</button>
				    		</div>
				    				
				    		<div id="gameInfo">
				    			<h3>Round: <label id='setRoundCounter'></label></h3>
	    						<h4>Active Player: <label id='activePlayer'></label></h4>
	    						<h5>Round Winner: <label id='roundWinnerRevealed'></label></h5>
	    						<button class="nes-btn" style="position:relative;right:479px;" onclick="displayCards();">Draw Cards</button>
	    					</div>

    						<div class="row text-center" id='cardSection'>
    							<div class="col-lg-2">
    								<div class="nes-container is-rounded is-dark" id="card1">
									<div class="card-header">Human</div>
										<h6 class="card-subtitle" id="card-title"></h6>
									
										<div class="card-body">
											<button class="nes-btn" style="font-size:8px;width:130px;height:30px;" onclick="humanSelectsCategory(1)" id="stat1">
												<p class="stat"></p>
											</button>
											<button class="nes-btn" style="font-size:8px;width:130px;height:30px;" onclick="humanSelectsCategory(2)" id="stat2">
												<p class="stat"></p>
											</button>
											<button class="nes-btn" style="font-size:8px;width:130px;height:30px;" onclick="humanSelectsCategory(3)" id="stat3">
												<p class="stat"></p>
											</button>
											<button class="nes-btn" style="font-size:8px;width:130px;height:30px;" onclick="humanSelectsCategory(4)" id="stat4">
												<p class="stat"></p>
											</button>
											<button class="nes-btn" style="font-size:8px;width:130px;height:30px;" onclick="humanSelectsCategory(5)" id="stat5">
												<p class="stat"></p>
											</button>
										</div>
									</div>
								</div>
								<div class="col-lg-2">
									<div class="nes-container is-rounded is-dark" id="card2">
										<div class="card-header">Opponent 1</div>
											<h6 class="card-subtitle" id="card-title"></h6>
									
										<div class="card-body">
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat1"></p>
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat2"></p>
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat3"></p>
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat4"></p>
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat5"></p>
										</div>
									</div>
								</div>
								<div class="col-lg-2">
									<div class="nes-container is-rounded is-dark" id="card3">
											<div class="card-header">Opponent 2</div>
											<h6 class="card-subtitle" id="card-title"></h6>
											
										<div class="card-body">
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat1"></p>
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat2"></p>
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat3"></p>
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat4"></p>
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat5"></p>
										</div>
									</div>
								</div>
								<div class="col-lg-2">
									<div class="nes-container is-rounded is-dark" id="card4">
											<div class="card-header">Opponent 3</div>
											<h6 class="card-subtitle" id="card-title"></h6>
											
										<div class="card-body">
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat1"></p>
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat2"></p>
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat3"></p>
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat4"></p>
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat5"></p>
										</div>
									</div>
								</div>
								<div class="col-lg-2">
									<div class="nes-container is-rounded is-dark" id="card5">
										<div class="card-header">Opponent 4</div>
											<h6 class="card-subtitle" id="card-title"></h6>
											
										<div class="card-body">
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat1"></p>
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat2"></p>
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat3"></p>
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat4"></p>
											<p class="stat" style="font-size:8px;color:white;padding-top:14px;" id="stat5"></p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>				  

</html>
}
}