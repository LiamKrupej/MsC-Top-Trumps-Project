<html>

<head>
    <!-- Web page title -->
    <title>Top Trumps</title>

    <!-- Import JQuery, as it provides functions you will probably find useful (see https://jquery.com/) -->
    <script src="https://code.jquery.com/jquery-2.1.1.js"></script>
    <script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/flick/jquery-ui.css">

    <!-- Optional Styling of the Website, for the demo I used Bootstrap (see https://getbootstrap.com/docs/4.0/getting-started/introduction/) -->
    <link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/TREC_IS/bootstrap.min.css">
    <script src="http://dcs.gla.ac.uk/~richardm/vex.combined.min.js"></script>
    <script>vex.defaultOptions.className = 'vex-theme-os';</script>
    <link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex.css"/>
    <link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex-theme-os.css"/>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

</head>

<style>

     html, body {

                   min-height: 100%;

               }

               body {

                   background-image: url(https://cdn.pixabay.com/photo/2016/08/20/16/26/scotland-1607908_1280.jpg);
                   background-repeat: no-repeat;
                   background-position: 0 0;
                   background-size: cover%;
               }


               .card {

                    opacity: 0.9;
                    min-width: 250px;
                    max-width: 250px;
                    padding-left:1px;
               }

               .container {

                   padding-top:10px;
                   padding-left:1px;


               }

               .btn{
                    position: absolute;
                    top: 85%;
                    background-color: #f1f1f1;
                    color: black;
                    font-size: 16px;
                    padding: 16px 30px;
                    border: none;
                    cursor: pointer;
                    border-radius: 5px;
                    text-align: center;
                    opacity: 0.9;

              }

  </style>

<body onload="initalize()"> <!-- Call the initalize method when the page loads -->
<div class="container">
    <div class="card-deck">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title1">Game Stats<span id="GameStats"><br><br><br><br></h5>
                <div class="list-group2">
                    <h6 class="list-group-item2 list-group-item-action">Player 1 Rounds Won:<span id="p1Rounds"></span></h6>
                    <h6 class="list-group-item2 list-group-item-action">Computer 1 Rounds Won:<span id="c1Rounds"></h6>
                    <h6 class="list-group-item2 list-group-item-action">Computer 2 Rounds Won:<span id="c2Rounds"></span></h6>
                    <h6 class="list-group-item2 list-group-item-action">Computer 3 Rounds Won:<span id="c3Rounds"></span></h6>
                    <h6 class="list-group-item2 list-group-item-action">Computer 4 Rounds Won:<span id="c4Rounds"></span></h6>
                </div>
            </div>
            <div class="card-footer">
                <small class="text-muted">Historic Stats</small>
            </div>
        </div>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title1"> Historic Stats<span id="player2"><br><br><br><br></h5>
                <div class="list-group2">
                    <h6 class="list-group-item2 list-group-item-action">Total Games:<span id="TotalGames"></span></h6>
                    <h6 class="list-group-item2 list-group-item-action">Human Wins:<span id="HumanWins"></h6>
                    <h6 class="list-group-item2 list-group-item-action">AI Wins:<span id="AIWins"></span></h6>
                    <h6 class="list-group-item2 list-group-item-action">Draws:<span id="Draws"></span></h6>
                    <h6 class="list-group-item2 list-group-item-action">Longest Game:<span id="Longest Game"></span></h6>
                </div>
            </div>
            <div class="card-footer">
                <small class="text-muted">Game Stats</small>
            </div>
        </div>

    </div>
</div>
		<script type="text/javascript">

			// Method that is called on page load
			function initalize() {

                LastGameStats();

			}

			// -----------------------------------------
			// Add your other Javascript methods Here
			// -----------------------------------------

			// This is a reusable method for creating a CORS request. Do not edit this.
			function createCORSRequest(method, url) {
  				var xhr = new XMLHttpRequest();
  				if ("withCredentials" in xhr) {

    				// Check if the XMLHttpRequest object has a "withCredentials" property.
    				// "withCredentials" only exists on XMLHTTPRequest2 objects.
    				xhr.open(method, url, true);

  				} else if (typeof XDomainRequest != "undefined") {

    				// Otherwise, check if XDomainRequest.
    				// XDomainRequest only exists in IE, and is IE's way of making CORS requests.
    				xhr = new XDomainRequest();
    				xhr.open(method, url);

 				 } else {

    				// Otherwise, CORS is not supported by the browser.
    				xhr = null;

  				 }
  				 return xhr;
			}

		</script>

		<!-- Here are examples of how to call REST API Methods -->
		<script type="text/javascript">

			  // This calls the helloJSONList REST method from TopTrumpsRESTAPI
             function LastGameStats() {

                // First create a CORS request, this is the message we are going to send (a get request in this case)
                var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/getLastGameStats"); // Request type and URL

                // Message is not sent yet, but we can check that the browser supports CORS
                if (!xhr) {
                    alert("CORS not supported");

                }

                // THIS IS WHERE THE MAGIC HAPPENS!!!!!!
                xhr.onload = function(e) {

                    var responseText = xhr.response; // the text of the response
                    var response15 = JSON.parse(responseText);

                    $("#p1Rounds").text(response15[0]);
                    $("#c1Rounds").text(response15[1]);
                    $("#c2Rounds").text(response15[2]);
                    $("#c3Rounds").text(response15[3]);
                    $("#c4Rounds").text(response15[4]);

                };

                // We have done everything we need to prepare the CORS request, so send it
                xhr.send();

             }

    </script>
</body>
</html>