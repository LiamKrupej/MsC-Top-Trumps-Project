package online.dwResources;
import java.io.IOException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Model.Player;
import Model.TTModel;
import Model.TTController;
import Model.TTView;

import online.configuration.TopTrumpsJSONConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Path("/toptrumps") // Resources specified here should be hosted at http://localhost:7777/toptrumps
@Produces(MediaType.APPLICATION_JSON) // This resource returns JSON content
@Consumes(MediaType.APPLICATION_JSON) // This resource can take JSON content as input
/**
 * This is a Dropwizard Resource that specifies what to provide when a user
 * requests a particular URL. In this case, the URLs are associated to the
 * different REST API methods that you will need to expose the game commands
 * to the Web page.
 * 
 * Below are provided some sample methods that illustrate how to create
 * REST API methods in Dropwizard. You will need to replace these with
 * methods that allow a TopTrumps game to be controled from a Web page.
 */

public class TopTrumpsRESTAPI {

	/** A Jackson Object writer. It allows us to turn Java objects
	 * into JSON strings easily. */
	ObjectWriter oWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
	TTModel model;
	TTController controller;
	TTView view;

	/**
	 * Contructor method for the REST API. This is called first. It provides
	 * a TopTrumpsJSONConfiguration from which you can get the location of
	 * the deck file and the number of AI players.
	 * @param conf
	 */

	public TopTrumpsRESTAPI(TopTrumpsJSONConfiguration conf) {

		model = new TTModel();
		view = new TTView();
		controller = new TTController(model, view);

		// ----------------------------------------------------
		// Add relevant initalization here
		// ----------------------------------------------------
	}

	@GET
	@Path("/startGame")

	public void startGame() throws IOException {

		controller.startGame(true);

	}

	@GET
	@Path("/attributes")

	public ArrayList<String> getAttributes() throws IOException {

		ArrayList<String> player1 = new ArrayList<String>();

		int p1size = model.getActivePlayers().get(0).getGeo();
		String p1geo = oWriter.writeValueAsString(p1size);
		player1.add(p1geo);

		int p1Pop = model.getActivePlayers().get(0).getPop();
		String p1Population = oWriter.writeValueAsString(p1Pop);
		player1.add(p1Population);

		int p1Duration = model.getActivePlayers().get(0).getDur();
		String p1Length = oWriter.writeValueAsString(p1Duration);
		player1.add(p1Length);

		int p1Antiquity = model.getActivePlayers().get(0).getAnt();
		String p1Age = oWriter.writeValueAsString(p1Antiquity);
		player1.add(p1Age);

		int p1Cool = model.getActivePlayers().get(0).getCool();
		String p1Coolness = oWriter.writeValueAsString(p1Cool);
		player1.add(p1Coolness);

		String p1Name = model.getActivePlayers().get(0).getCardName();
		String p1name = oWriter.writeValueAsString(p1Name);
		player1.add(p1name);

		return player1;

	}

	@GET
	@Path("/player2")

	public ArrayList<String> player2() throws IOException {

		ArrayList<String> player2 = new ArrayList<String>();

		int p2size = model.getActivePlayers().get(1).getGeo();
		String p2geo = oWriter.writeValueAsString(p2size);
		player2.add(p2geo);

		int p2Pop = model.getActivePlayers().get(1).getPop();
		String p2Population = oWriter.writeValueAsString(p2Pop);
		player2.add(p2Population);

		int p2Duration = model.getActivePlayers().get(1).getDur();
		String p2Length = oWriter.writeValueAsString(p2Duration);
		player2.add(p2Length);

		int p2Antiquity = model.getActivePlayers().get(1).getAnt();
		String p2Age = oWriter.writeValueAsString(p2Antiquity);
		player2.add(p2Age);

		int p2Cool = model.getActivePlayers().get(1).getCool();
		String p2Coolness = oWriter.writeValueAsString(p2Cool);
		player2.add(p2Coolness);

		String p2Name = model.getActivePlayers().get(1).getCardName();
		String p2name = oWriter.writeValueAsString(p2Name);
		player2.add(p2name);

		return player2;

	}

	@GET
	@Path("/player3")

	public ArrayList<String> player3() throws IOException {

		ArrayList<String> player3 = new ArrayList<String>();

		int p3size = model.getActivePlayers().get(2).getGeo();
		String p3geo = oWriter.writeValueAsString(p3size);
		player3.add(p3geo);

		int p3Pop = model.getActivePlayers().get(2).getPop();
		String p3Population = oWriter.writeValueAsString(p3Pop);
		player3.add(p3Population);

		int p3Duration = model.getActivePlayers().get(2).getDur();
		String p3Length = oWriter.writeValueAsString(p3Duration);
		player3.add(p3Length);

		int p3Antiquity = model.getActivePlayers().get(2).getAnt();
		String p3Age = oWriter.writeValueAsString(p3Antiquity);
		player3.add(p3Age);

		int p3Cool = model.getActivePlayers().get(2).getCool();
		String p3Coolness = oWriter.writeValueAsString(p3Cool);
		player3.add(p3Coolness);

		String p3Name = model.getActivePlayers().get(2).getCardName();
		String p3name = oWriter.writeValueAsString(p3Name);
		player3.add(p3name);

		return player3;

	}

	@GET
	@Path("/player4")

	public ArrayList<String> player4() throws IOException {

		ArrayList<String> player4 = new ArrayList<String>();

		int p4size = model.getActivePlayers().get(3).getGeo();
		String p4geo = oWriter.writeValueAsString(p4size);
		player4.add(p4geo);

		int p4Pop = model.getActivePlayers().get(3).getPop();
		String p4Population = oWriter.writeValueAsString(p4Pop);
		player4.add(p4Population);

		int p4Duration = model.getActivePlayers().get(3).getDur();
		String p4Length = oWriter.writeValueAsString(p4Duration);
		player4.add(p4Length);

		int p4Antiquity = model.getActivePlayers().get(3).getAnt();
		String p4Age = oWriter.writeValueAsString(p4Antiquity);
		player4.add(p4Age);

		int p4Cool = model.getActivePlayers().get(3).getCool();
		String p4Coolness = oWriter.writeValueAsString(p4Cool);
		player4.add(p4Coolness);

		String p4Name = model.getActivePlayers().get(3).getCardName();
		String p4name = oWriter.writeValueAsString(p4Name);
		player4.add(p4name);

		return player4;

	}

	@GET
	@Path("/player5")

	public ArrayList<String> player5() throws IOException {

		ArrayList<String> player5 = new ArrayList<String>();

		int p5size = model.getActivePlayers().get(4).getGeo();
		String p5geo = oWriter.writeValueAsString(p5size);
		player5.add(p5geo);

		int p5Pop = model.getActivePlayers().get(4).getPop();
		String p5Population = oWriter.writeValueAsString(p5Pop);
		player5.add(p5Population);

		int p3Duration = model.getActivePlayers().get(4).getDur();
		String p3Length = oWriter.writeValueAsString(p3Duration);
		player5.add(p3Length);

		int p5Antiquity = model.getActivePlayers().get(4).getAnt();
		String p5Age = oWriter.writeValueAsString(p5Antiquity);
		player5.add(p5Age);

		int p5Cool = model.getActivePlayers().get(4).getCool();
		String p5Coolness = oWriter.writeValueAsString(p5Cool);
		player5.add(p5Coolness);

		String p5Name = model.getActivePlayers().get(4).getCardName();
		String p5name = oWriter.writeValueAsString(p5Name);
		player5.add(p5name);

		return player5;

	}

	@GET
	@Path("/value")

	public String KeyboardSize() throws IOException {

		ArrayList<Player> currentHighest = new ArrayList<Player>();

		model.compareCards(1, model.getActivePlayers());

		for (int j = 0; j < model.getActivePlayers().size(); j++) {
			System.out.println(String.format("%s has %s with size %01d", model.getActivePlayers().get(j).getPlayerName(), model.getActivePlayers().get(j).getCardName(), model.getActivePlayers().get(j).getGeo()));
			if (j == 0) {
				currentHighest.add(0, model.getActivePlayers().get(j));
			} else if (j == 1) {
				currentHighest.add(1, model.getActivePlayers().get(j));
			}

		}

		return String.format(model.getRoundWinner());

	}

	@GET
	@Path("/value1")

	public String KeyboardDur() throws IOException {

		ArrayList<Player> currentHighest = new ArrayList<Player>();

		model.compareCards(2, model.getActivePlayers());

		for (int j = 0; j < model.getActivePlayers().size(); j++) {
			System.out.println(String.format("%s has %s with size %01d", model.getActivePlayers().get(j).getPlayerName(), model.getActivePlayers().get(j).getCardName(), model.getActivePlayers().get(j).getDur()));
			if (j == 0) {
				currentHighest.add(0, model.getActivePlayers().get(j));
			} else if (j == 1) {
				currentHighest.add(1, model.getActivePlayers().get(j));
			}

		}

		return String.format(model.getRoundWinner());

	}

	@GET
	@Path("/value2")

	public String KeyboardPop() throws IOException {

		ArrayList<Player> currentHighest = new ArrayList<Player>();

		model.compareCards(3, model.getActivePlayers());

		for (int j = 0; j < model.getActivePlayers().size(); j++) {
			System.out.println(String.format("%s has %s with size %01d", model.getActivePlayers().get(j).getPlayerName(), model.getActivePlayers().get(j).getCardName(), model.getActivePlayers().get(j).getPop()));
			if (j == 0) {
				currentHighest.add(0, model.getActivePlayers().get(j));
			} else if (j == 1) {
				currentHighest.add(1, model.getActivePlayers().get(j));
			}

		}

		return String.format(model.getRoundWinner());

	}

	@GET
	@Path("/value3")

	public String KeyboardAnt() throws IOException {

		ArrayList<Player> currentHighest = new ArrayList<Player>();

		model.compareCards(4, model.getActivePlayers());

		for (int j = 0; j < model.getActivePlayers().size(); j++) {
			System.out.println(String.format("%s has %s with size %01d", model.getActivePlayers().get(j).getPlayerName(), model.getActivePlayers().get(j).getCardName(), model.getActivePlayers().get(j).getAnt()));
			if (j == 0) {
				currentHighest.add(0, model.getActivePlayers().get(j));
			} else if (j == 1) {
				currentHighest.add(1, model.getActivePlayers().get(j));
			}

		}

		return String.format(model.getRoundWinner());

	}

	@GET
	@Path("/value4")

	public String KeyboardCool() throws IOException {

		ArrayList<Player> currentHighest = new ArrayList<Player>();

		model.compareCards(5, model.getActivePlayers());

		for (int j = 0; j < model.getActivePlayers().size(); j++) {
			System.out.println(String.format("%s has %s with size %01d", model.getActivePlayers().get(j).getPlayerName(), model.getActivePlayers().get(j).getCardName(), model.getActivePlayers().get(j).getCool()));
			if (j == 0) {
				currentHighest.add(0, model.getActivePlayers().get(j));
			} else if (j == 1) {
				currentHighest.add(1, model.getActivePlayers().get(j));
			}

		}

		return String.format(model.getRoundWinner());

	}

}

