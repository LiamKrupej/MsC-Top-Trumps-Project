import java.sql.*;
import java.util.HashMap;

public class DatabaseConnectionTest {

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

        System.out.println("Database is online");

    }

    public void createPlayerStatsTable() throws SQLException {

        Statement stmt;
        stmt = c.createStatement();

        String sql = "CREATE TABLE Player_Stats " +
                "(Player_ID INTEGER, " +
                " Round_Wins INTEGER, " +
                " Round_Draws INTEGER, " +
                " PRIMARY KEY ( Player_ID ))";

        try {

            stmt.executeUpdate(sql);
            System.out.println("Stats logged");

        } catch (SQLException se) {
            se.printStackTrace();

        } catch (Exception e) {
            System.err.println("error for query " + sql);

        }

        String Instantiate = "INSERT INTO Player_Stats (player_id)" + "VALUES ('1')";
        String Instantiate2 = "INSERT INTO Player_Stats (player_id)" + "VALUES ('2')";
        String Instantiate3 = "INSERT INTO Player_Stats (player_id)" + "VALUES ('3')";
        String Instantiate4 = "INSERT INTO Player_Stats (player_id)" + "VALUES ('4')";
        String Instantiate5 = "INSERT INTO Player_Stats (player_id)" + "VALUES ('5')";

        try {

            stmt.executeUpdate(Instantiate);
            stmt.executeUpdate(Instantiate2);
            stmt.executeUpdate(Instantiate3);
            stmt.executeUpdate(Instantiate4);
            stmt.executeUpdate(Instantiate5);
            System.out.println("Stats logged");

        } catch (SQLException se) {
            se.printStackTrace();

        } catch (Exception e) {
            System.err.println("error for query " + Instantiate);

        }

    }

    public void createHistoricStatsTable() throws SQLException {

        Statement stmt;
        stmt = c.createStatement();

        String sql = "CREATE TABLE Historic_Stats " +
                "(Player_ID INTEGER, " +
                " Total_Games INTEGER, " +
                " Total_Human_Wins INTEGER, " +
                " Total_Computer_Wins INTEGER, " +
                " PRIMARY KEY ( Player_ID ))";

        try {

            stmt.executeUpdate(sql);
            System.out.println("Stats logged");

        } catch (SQLException se) {
            se.printStackTrace();

        } catch (Exception e) {
            System.err.println("error for query " + sql);

        }

        String Instantiate = "INSERT INTO Historic_Stats (player_id)" + "VALUES ('1')";
        String Instantiate2 = "INSERT INTO Historic_Stats (player_id)" + "VALUES ('2')";
        String Instantiate3 = "INSERT INTO Historic_Stats (player_id)" + "VALUES ('3')";
        String Instantiate4 = "INSERT INTO Historic_Stats (player_id)" + "VALUES ('4')";
        String Instantiate5 = "INSERT INTO Historic_Stats (player_id)" + "VALUES ('5')";

        try {

            stmt.executeUpdate(Instantiate);
            stmt.executeUpdate(Instantiate2);
            stmt.executeUpdate(Instantiate3);
            stmt.executeUpdate(Instantiate4);
            stmt.executeUpdate(Instantiate5);
            System.out.println("Stats logged");

        } catch (SQLException se) {
            se.printStackTrace();

        } catch (Exception e) {
            System.err.println("error for query " + Instantiate);

        }

    }

    public void createHistoricGameTable() throws SQLException {

        Statement stmt;
        stmt = c.createStatement();

        String sql = "CREATE TABLE Historic_Game_Stats " +
                "(Game_ID VARCHAR, " +
                " Player_ID INTEGER, " +
                " PRIMARY KEY ( Game_ID  ))";

        try {

            stmt.executeUpdate(sql);
            System.out.println("Stats logged");

        } catch (SQLException se) {
            se.printStackTrace();

        } catch (Exception e) {
            System.err.println("error for query " + sql);

        }
    }

    public void getPlayerStats() throws Exception {

        Statement stmt;

        HashMap<String, Integer> stats = new HashMap<>();

        String query = "SELECT (Player_ID), (Round_Wins), (Round_Draws) FROM Player_Stats;";

        try {

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                String Player_ID = rs.getString("Player_ID");
                stats.put("winner is " + Player_ID + " ", null);

                int Round_Wins = rs.getInt("Round_Wins");
                stats.put("Number of draws ", Round_Wins);

                int Round_Draws = rs.getInt("Round_Draws");
                stats.put("Number of rounds ", Round_Draws);

                System.out.println(stats);

            }

        } catch (SQLException e) { //handle error
            e.printStackTrace();
            System.out.println("Error executing query.");

        }
    }

    public void getHistoricStats() throws Exception {

        Statement stmt;

        HashMap<String, Integer> PersistentStats = new HashMap<>();

        String query = "SELECT (Player_ID), (Total_Games), (Total_Human_Wins), (Total_Computer_Wins) FROM Historic_Stats;";

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

        } catch (SQLException e) { //handle error
            e.printStackTrace();
            System.out.println("Error executing query.");
        }
    }
}