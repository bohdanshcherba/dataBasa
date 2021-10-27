package ua.lviv.iot.dao.implementation;

import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.dao.AbstractDAO;
import ua.lviv.iot.model.Location;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO implements AbstractDAO<Location> {

    private static final String GET_ALL = "SELECT * FROM shcherba.location";

    private static final String CREATE = "INSERT shcherba.location "
            + "(`name`,`country`,"
            + "`city`,`street`,`number`,`zip_code`,"
            + "`number_available_cars`) VALUES (?,?,?,?,?,?,?)";

    private static final String UPDATE = "UPDATE shcherba.location SET "
            + "`name`=?,`country`=?,`city`=?,"
            + "`street`=?,`number`=?,`zip_code`=?,"
            + "`number_available_cars`=? WHERE id = ?";

    private static final String DELETE = "DELETE FROM "
            + "shcherba.location WHERE id=?";

    @Override
    public List<Location> findAll() throws SQLException {
        List<Location> locations = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Location location = new Location(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("country"),
                        rs.getString("city"),
                        rs.getString("street"),
                        rs.getString("number"),
                        rs.getString("zip_code"),
                        rs.getInt("number_available_cars"));
                locations.add(location);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locations;

    }

    @Override
    public void create(Location location) throws SQLException {
        try (PreparedStatement statement = ConnectionManager
                .getConnection()
                .prepareStatement(CREATE)) {

            statement.setString(1, String.valueOf(location.getName()));
            statement.setString(2, String.valueOf(location.getCountry()));
            statement.setString(3, location.getCity());
            statement.setString(4, location.getStreet());
            statement.setString(5, location.getNumber());
            statement.setString(6, String.valueOf(location.getZip_code()));
            statement.setInt(7, location.getNumber_available_cars());


            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Location location) throws SQLException {
        try (PreparedStatement statement = ConnectionManager
                .getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, String.valueOf(location.getName()));
            statement.setString(2, String.valueOf(location.getCountry()));
            statement.setString(3, location.getCity());
            statement.setString(4, location.getStreet());
            statement.setString(5, location.getNumber());
            statement.setString(6, String.valueOf(location.getZip_code()));
            statement.setInt(7, location.getNumber_available_cars());
            statement.setInt(8, location.getId());

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
