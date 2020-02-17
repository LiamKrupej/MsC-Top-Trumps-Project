package Model;
import java.sql.*;
import java.util.HashMap;

public class Database {

    public Database(TTModel m) {
        this.m = m;
    }

    TTModel m;

    private Connection c = null;

    public void DB() {

        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost/", "postgres", "postgres");

        } catch (Exception e) {

            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }

    }

    public void updateLastGameStats() throws SQLException {


        String yeet = "INSERT INTO Last_Game_Stats(Player_1_Rounds,yeet) VALUES (?,?);";

        PreparedStatement stmt = c.prepareStatement(yeet);
        stmt.setInt(1,m.get1rounds());
        stmt.executeUpdate();

        m.getGameWinner();
        m.getRoundsInGame();
        m.getNumOfDraws();
        m.get1rounds();
        m.getComputerwins();

        System.out.print("Logged");

    }

    public void getLastGameStats() throws SQLException {

        Statement stmt;

        HashMap<String, Integer> stats = new HashMap<>();

        String query = "SELECT (Player_1_Round_Wins), (Number_Rounds), (Number_Draws), (Computer_4_Round_Wins), (Computer_3_Round_Wins), (Computer_2_Round_Wins), (Computer_1_Round_Wins), (Game_Winner), (Computer_Wins) FROM last_game_stats;";

        try {

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                int Player_1_Round_Wins = rs.getInt("Player_1_Round_Wins");
                stats.put("Player one round wins ", Player_1_Round_Wins);

                int Computer_1_Round_Wins = rs.getInt("Computer_1_Round_Wins");
                stats.put("Computer one round wins ", Computer_1_Round_Wins);

                int Computer_2_Round_Wins = rs.getInt("Computer_2_Round_Wins");
                stats.put("Computer two round wins  ",Computer_2_Round_Wins);

                int Computer_3_Round_Wins = rs.getInt("Computer_3_Round_Wins");
                stats.put("Computer three round wins  ",Computer_3_Round_Wins);

                int Computer_4_Round_Wins = rs.getInt("Computer_4_Round_Wins");
                stats.put("Computer four round wins  ",Computer_4_Round_Wins);

                int Number_Rounds = rs.getInt("Number_Rounds");
                stats.put("Number of Rounds:  ", Number_Rounds);

                int Number_Draws = rs.getInt("Number_Draws");
                stats.put("Number of Draws:  ", Number_Draws);

                int Game_Winner = rs.getInt("Game_Winner");
                stats.put("Winner is  ", Game_Winner);

                int Computer_Wins = rs.getInt("Computer_Wins");
                stats.put("Total ",  Computer_Wins );

                System.out.println(stats);

            }

        } catch (SQLException e) { //handle error
            e.printStackTrace();
            System.out.println("Error executing query.");

        }
    }

    public void getHistoricStats()  throws SQLException {

        Statement stmt;

        HashMap<String, Integer> PersistentStats = new HashMap<>();

        String query = "SELECT MAX (Total_Games), COUNT(Player_1_Round_Wins), COUNT (Computer_Wins) FROM last_game_stats;";

        try {

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                int Total_Games = rs.getInt("Total_Games");
                PersistentStats.put("Total Number of Games is ", Total_Games);

                int Total_Human_Wins = rs.getInt("Total_Human_Wins");
                PersistentStats.put("Number of Human Wins ", Total_Human_Wins);

                int Total_Computer_Wins = rs.getInt("Total_Computer_Wins");
                PersistentStats.put("Number of Computer Wins ", Total_Computer_Wins);

                System.out.println(PersistentStats);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error executing query.");

        }
    }
}