package Model;

import Model.TTModel;
import Model.TTController;

import java.sql.*;
import java.util.HashMap;

public class Database {

	private TTModel Model = new TTModel();
	private TTView View = new TTView();
	private TTController Controller = new TTController(Model, View);

	private Connection c = null;

	public void DB() {

		try {

			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://52.24.215.108/feelthebern", "FeeltheBern",
					"FeeltheBern");

		} catch (Exception e) {

			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);

		}

		System.out.println("Model.Database is online");

	}

	public void updateGameStatsTable() throws SQLException {

		Statement stmt;
		stmt = c.createStatement();

		String Instantiate = "INSERT INTO Last_Game_Stats VALUES ('" + Model.getNumOfDraws() + ","
				+ Model.getRoundsInGame() + " , " + "," + Model.get1rounds() + "," + Model.get2rounds() + ","
				+ Model.get3rounds() + "," + Model.get4rounds() + "," + Model.getWinner() + "," + Model.get5rounds()
				+ ")";

		try {

			stmt.executeUpdate(Instantiate);
			System.out.println("Primary Key logged");

		} catch (SQLException se) {
			se.printStackTrace();

		} catch (Exception e) {
			System.err.println("error for query " + Instantiate);

		}

	}

}
