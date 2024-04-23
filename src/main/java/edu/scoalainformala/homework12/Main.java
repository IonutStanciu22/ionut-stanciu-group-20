package edu.scoalainformala.homework12;


import java.sql.*;



public class Main {

    public static void main(String[] args) throws SQLException {

        String url = new StringBuilder()
                .append("jdbc:")
                .append("postgresql")
                .append("://")
                .append("localhost")
                .append(":")
                .append("5432")
                .append("/")
                .append("homework")
                .append("?user=")
                .append("postgres")
                .append("&password=")
                .append("ionut").toString();


        System.out.println("URL " + url);


        final Connection connection = DriverManager.getConnection(url);


        if (connection == null) {
            return;
        }
        Statement statement = null;
        ResultSet resultSet = null;
        final String format = "%10s%20s%20s%15s%40s\n";

        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery("select * from accommodation");
            boolean hasResults = resultSet.next();
            if (hasResults) {
                System.out.format(format, "id", "type", "bed_type", "max_guests", "description");

                do {
                    System.out.format(format,
                            resultSet.getInt("id"),
                            resultSet.getString("type"),
                            resultSet.getString("bed_type"),
                            resultSet.getInt("max_guests"),
                            resultSet.getString("description")
                    );
                } while (resultSet.next());
            } else {
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (resultSet != null) try {
                resultSet.close();
            } catch (SQLException e) {
            }
            if (statement != null) try {
                statement.close();
            } catch (SQLException e) {
            }
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }


    }

}





