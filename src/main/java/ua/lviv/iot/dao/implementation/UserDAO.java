package ua.lviv.iot.dao.implementation;

import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.dao.AbstractDAO;
import ua.lviv.iot.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements AbstractDAO<User> {


    private static final String GET_ALL = "SELECT * FROM shcherba.user";

    private static final String CREATE = "INSERT shcherba.user "
            + "(`first_name`,`last_name`,"
            + "`identity_document`,`driver_license`,`mail`,`phone_number`,"
            + "`payment_card`,`security_login`) VALUES (?,?,?,?,?,?,?,?)";

    private static final String UPDATE = "UPDATE shcherba.user"
            + " SET `first_name`=?,"
            + "`last_name`=?,`identity_document`=?,"
            + "`driver_license`=?,`mail`=?,`phone_number`=?,"
            + "`payment_card`=?,`security_login`=? WHERE id = ?";

    private static final String DELETE = "DELETE FROM shcherba.user WHERE id=?";


    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("identity_document"),
                        rs.getString("driver_license"),
                        rs.getString("mail"),
                        rs.getString("phone_number"),
                        rs.getString("payment_card"),
                        rs.getString("security_login")
                );
                users.add(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;

    }

    @Override
    public void create(User user) throws SQLException {
        try (PreparedStatement statement = ConnectionManager
                .getConnection()
                .prepareStatement(CREATE)) {

            statement.setString(1, String.valueOf(user.getFirst_name()));
            statement.setString(2, String.valueOf(user.getLast_name()));
            statement.setString(3, user.getIdentity_document());
            statement.setString(4, user.getDriver_license());
            statement.setString(5, user.getMail());
            statement.setString(6, String.valueOf(user.getPhone_number()));
            statement.setString(7, user.getPayment_card());
            statement.setString(8, user.getSecurity_login());


            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, User user) throws SQLException {
        try (PreparedStatement statement = ConnectionManager
                .getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, String.valueOf(user.getFirst_name()));
            statement.setString(2, String.valueOf(user.getLast_name()));
            statement.setString(3, user.getIdentity_document());
            statement.setString(4, user.getDriver_license());
            statement.setString(5, user.getMail());
            statement.setString(6, String.valueOf(user.getPhone_number()));
            statement.setString(7, user.getPayment_card());
            statement.setString(8, user.getSecurity_login());
            statement.setInt(8, user.getId());

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
    }




}

