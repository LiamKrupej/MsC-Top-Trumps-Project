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

                   background-image: url(https://cdn.pixabay.com/photo/2016/11/22/19/17/architecture-1850129_1280.jpg);
                   background-repeat: no-repeat;
                   background-position: 0 0;
                   background-size: 100%;

               }

               th {

                 color: black;

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

    </div>
            	<div class="container">
        		<table class="table" id="table1">
        		<div class="container">
        		<button class="btn" style="left: 7%;" onclick="window.location.href ='http://localhost:7777/toptrumps';">Back</button>

          <thead>
            <tr>
              <th scope="col">Total of Games</th> "class="list-group-item3 list-group-item-action">Size:<span id="totalgames"></span>
              <th scope="col">Human Wins</th>
              <th scope="col">AI Wins</th>
              <th scope="col">Draws Per Game</th>
              <th scope="col">Longest Game</th>
              <th scope="col">Rounds Won Per Player</th>
              <th scope="col">Winner of Game </th>
              <th scope="col">Number of Draws</th>
              <th scope="col">Longest Game</th>

            </tr>
          </thead>

        </table>

		</div>

		<script type="text/javascript">

			// Method that is called on page load
			function initalize() {

				// --------------------------------------------------------------------------
				// You can call other methods you want to run when the page first loads here
				// --------------------------------------------------------------------------

			}
			
			getLastGameStats();
			getOverallStats();


			
			function createCORSRequest(method, url) {
  				var xhr = new XMLHttpRequest();
  				if ("withCredentials" in xhr) {

    				xhr.open(method, url, true);

  				} else if (typeof XDomainRequest != "undefined") {

 
    				xhr = new XDomainRequest();
    				xhr.open(method, url);

 				 } else {

    				// Otherwise, CORS is not supported by the browser.
    				xhr = null;

  				 }
  				 return xhr;
			}

		</script>

		<script type="text/javascript">

			
			function helloJSONList() {

			
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/helloJSONList"); // Request type and URL

		
				if (!xhr) {
  					alert("CORS not supported");
				}

				xhr.onload = function(e) {
 					var responseText = xhr.response; 
					var response = JSON.parse(responseText);
					
					$("#totalgames").text(" " + response[0]);
					
				};

				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();
			}

			// This calls the helloJSONList REST method from TopTrumpsRESTAPI
			function helloWord(word) {

				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/helloWord?Word="+word); // Request type and URL+parameters

				// Message is not sent yet, but we can check that the browser supports CORS
				if (!xhr) {
  					alert("CORS not supported");
				}

				// CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
				// to do when the response arrives
				xhr.onload = function(e) {
 					var responseText = xhr.response; // the text of the response
					alert(responseText); // lets produce an alert
				};

				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();
			}

		</script>

		</body>
</html>