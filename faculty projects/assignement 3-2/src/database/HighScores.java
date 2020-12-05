package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class HighScores {
    int maxScores;
    PreparedStatement insertStatement;
    PreparedStatement deleteStatement;
    Connection connection;

    public HighScores(int maxScores) throws SQLException{
        this.maxScores = maxScores;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "tanulo");
        connectionProps.put("password", "asd123") ;
        connectionProps.put("serverTimezone", "UTC");
        String dbURL = "jdbc:mysql://localhost:3306/highscore";
        connection = DriverManager.getConnection(dbURL, connectionProps);

        String insertQuery = "INSERT INTO HIGHSCORE (TIMESTAMP, NAME, SCORE) VALUES (?,?,?)";
        insertStatement = connection.prepareStatement(insertQuery);
        String deleteQuery = "DELETE FROM HIGHSCORE WHERE SCORE=?";
        deleteStatement = connection.prepareStatement(deleteQuery);
    }

    public ArrayList<HighScore> getHighScores() throws SQLException {
        String query = "SELECT * FROM HIGHSCORE ORDER by score desc ";
        ArrayList<HighScore> highScores = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet results = stmt.executeQuery(query);
        while (results.next()) {
            String name = results.getString("Name");
            int score = results.getInt("score");
            highScores.add(new HighScore(name, score));
        }
        return highScores;
    }

    public void putHighScore(String name , int score) throws SQLException {
        ArrayList<HighScore> highScores = getHighScores();
        if (highScores.size() < maxScores) {
            insertScore(name, score);
        }
        else {
            int leastScore = highScores.get(highScores.size() - 1).getScore();
            if (leastScore < score) {
                deleteScores(leastScore);
                insertScore(name, score);
            }
        }
    }

    private void insertScore(String name, int score) throws SQLException {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        insertStatement.setTimestamp(1, ts);
        insertStatement.setString(2, name);
        insertStatement.setInt(3, score);
        insertStatement.executeUpdate();
    }

    private void deleteScores(int score) throws SQLException{
        deleteStatement.setInt(1, score);
        deleteStatement.executeUpdate();
    }




}
