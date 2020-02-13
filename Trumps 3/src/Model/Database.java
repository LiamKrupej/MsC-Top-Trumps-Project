//package Model;
//
//import Model.TTModel;
//
//import java.sql.*;
//import java.util.HashMap;
//
//public class Database {
//
//    private Connection c = null;
//
//    public void DB() {
//
//        try {
//
//            Class.forName("org.postgresql.Driver");
//            c = DriverManager.getConnection("jdbc:postgresql://localhost/", "postgres", "postgres");
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
//
//        }
//
//        System.out.println("Model.Database is online");
//
//    }
//
//    public void createGameStatsTable() throws SQLException {
//
//        Statement stmt;
//        stmt = c.createStatement();
//
//        String sql = "CREATE TABLE Game_Stats " +
//                "(Winner_ID VARCHAR, " +
//                " Number_Rounds INTEGER, " +
//                " Round_Draws INTEGER, " +
//                " PRIMARY KEY (Winner_ID ))";
//
//        try {
//
//            stmt.executeUpdate(sql);
//            System.out.println("Stats logged");
//
//        } catch (SQLException se) {
//            se.printStackTrace();
//
//        } catch (Exception e) {
//            System.err.println("error for query " + sql);
//
//        }
//    }
//
//    public void updateGameStatsTable() throws SQLException {
//
//        Statement stmt;
//        stmt = c.createStatement();
//
//        //String Instantiate = "INSERT INTO Game_Stats VALUES ('" + TTModel.getWinner() + "' , " + TTModel.getNumberDraws() + ", "
//                //+ TTModel.getNumberRounds() + ")";
//
//        try {
//
//            stmt.executeUpdate(Instantiate);
//            System.out.println("Primary Key logged");
//
//        } catch (SQLException se) {
//            se.printStackTrace();
//
//        } catch (Exception e) {
//            System.err.println("error for query " + Instantiate);
//
//        }
//
//    }
//
//    public void createHistoricStatsTable() throws SQLException {
//
//        Statement stmt;
//        stmt = c.createStatement();
//
//        String sql = "CREATE TABLE Historic_Stats " +
//                "(Total_Games INTEGER, " +
//                " Total_Human_Wins INTEGER, " +
//                " Total_Computer_Wins INTEGER, " +
//                " PRIMARY KEY ( Total_Games ))";
//
//        try {
//
//            stmt.executeUpdate(sql);
//            System.out.println("Stats logged");
//
//        } catch (SQLException se) {
//            se.printStackTrace();
//
//        } catch (Exception e) {
//            System.err.println("error for query " + sql);
//
//        }
//
//    }
//
//   public void updateHistoricStatsTable() throws SQLException {
//
//        Statement stmt;
//        stmt = c.createStatement();
//
//       String Instantiate = "INSERT INTO Game_Stats VALUES ('" + TTModel.getTotalGames() + "' , " + TTModel.getTotalHumanWins() + ", "
//               + TTModel.getTotalComputerWins() + ")";
//
//        try {
//
//            stmt.executeUpdate(Instantiate);
//            System.out.println("Stats logged");
//
//         } catch (SQLException se) {
//            se.printStackTrace();
//
//        } catch (Exception e) {
//           System.err.println("error for query " + Instantiate);
//
//       }
//
//    }
//
//    public void getGameStats() throws Exception {
//
//        Statement stmt;
//
//        HashMap<String, Integer> stats = new HashMap<>();
//
//        String query = "SELECT (Winner_ID), (Number_Rounds), (Round_Draws) FROM Game_Stats;";
//
//        try {
//
//            stmt = c.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//
//            while (rs.next()) {
//
//                String Winner_ID = rs.getString("Winner_ID");
//                stats.put("Winner is " + Winner_ID + " ", null);
//
//                int Number_Rounds = rs.getInt("Number_Rounds");
//                stats.put("Number of rounds ", Number_Rounds);
//
//                int Round_Draws = rs.getInt("Round_Draws");
//                stats.put("Number of round draws ", Round_Draws);
//
//                System.out.println(stats);
//
//            }
//
//        } catch (SQLException e) { //handle error
//            e.printStackTrace();
//            System.out.println("Error executing query.");
//
//        }
//    }
//
//    public void getHistoricStats() throws Exception {
//
//        Statement stmt;
//
//        HashMap<String, Integer> PersistentStats = new HashMap<>();
//
//        String query = "SELECT (Total_Games), (Total_Human_Wins), (Total_Computer_Wins) FROM Historic_Stats;";
//
//        try {
//
//            stmt = c.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//
//            while (rs.next()) {
//
//                int Total_Games = rs.getInt("Total_Games");
//                PersistentStats.put("Total Number of Games is ", Total_Games);
//
//                int Total_Human_Wins = rs.getInt("Total_Human_Wins");
//                PersistentStats.put("Number of Human Wins ", Total_Human_Wins);
//
//                int Total_Computer_Wins = rs.getInt("Total_Computer_Wins");
//                PersistentStats.put("Number of Computer Wins ", Total_Computer_Wins);
//
//                System.out.println(PersistentStats);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Error executing query.");
//
//        }
//    }
//}