package edu.scoalainformala.homework12;

import java.sql.*;

public class Writter {
    public static int insertAccommodationTypes(Connection connection, int index, String type, String bedType, int maxGuest, String description) {
        if (index < 0)
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO accommodation values(?,?,?,?,?)");

                preparedStatement.setInt(1, index);
                preparedStatement.setString(2, type);
                preparedStatement.setString(3, bedType);
                preparedStatement.setInt(4, maxGuest);
                preparedStatement.setString(5, description);
                return preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);

            }
        return 0;
    }

    public static int insertRoomFair(Connection connection, int id, double value, String Season) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO accommodation values(?,?,?)")){

                preparedStatement.setInt(1, id);
                preparedStatement.setDouble(2, value);
                preparedStatement.setString(3, Season);

                return preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);

            }

        return 0;
    }

    public static int insertAccommodationTypesRoomFairRelation(Connection connection, int id, String accommodableId, String roomFairId) {

            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO accommodation values(?,?,?)")){

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, accommodableId);
                preparedStatement.setString(3, roomFairId);
                return preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);

            }
        return 0;
    }
}
