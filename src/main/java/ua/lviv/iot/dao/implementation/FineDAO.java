package ua.lviv.iot.dao.implementation;

import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.dao.AbstractDAO;

import ua.lviv.iot.model.Fine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FineDAO implements AbstractDAO<Fine> {

    private static final String GET_ALL = "SELECT * FROM shcherba.fine";
    private static final String CREATE = "INSERT shcherba.fine"
            + " (`type_of_fine`,`date`,"
            + "`user_id`) VALUES (?,?,?)";

    private static final String UPDATE = "UPDATE shcherba.fine SET "
            + "`type_of_fine`=?,`date`=?,"
            + "`user_id`=? WHERE id = ?";
    private static final String DELETE = "DELETE FROM shcherba.fine WHERE id=?";

    @Override
    public List<Fine> findAll() throws SQLException {
        List<Fine> fines = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager
                .getConnection()
                .prepareStatement(GET_ALL)) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Fine fine = new Fine(
                        rs.getInt("id"),
                        rs.getString("type_of_fine"),
                        rs.getString("date"),
                        rs.getInt("user_id")
                );
                fines.add(fine);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fines;

    }


    @Override
    public void create(Fine fine) throws SQLException {
        try (PreparedStatement statement = ConnectionManager
                .getConnection()
                .prepareStatement(CREATE)) {

            statement.setString(1, String.valueOf(fine.getType_of_fine()));
            statement.setString(2, String.valueOf(fine.getDate()));
            statement.setInt(3, fine.getUser_id());


            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();


        }

    }

    @Override
    public void update(Integer id, Fine fine) throws SQLException {
        try (PreparedStatement statement = ConnectionManager
                .getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, String.valueOf(fine.getType_of_fine()));
            statement.setString(2, String.valueOf(fine.getDate()));
            statement.setInt(3, fine.getUser_id());
            statement.setInt(4, fine.getId());

            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager
                .getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}