package ua.lviv.iot.dao.implementation;

import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.dao.AbstractDAO;
import ua.lviv.iot.model.Car;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements AbstractDAO<Car> {

    private static final String GET_ALL = "SELECT * FROM shcherba.car";
    private static final String CREATE = "INSERT shcherba.car "
            + "(`name`,`car_body_style`,"
            + "`price_for_day`,`seats`,`doors`,`gearbox type`,`accessible`,"
            + "`location_id`) VALUES (?,?,?,?,?,?,?,?)";

    private static final String UPDATE = "UPDATE shcherba.car SET `name`=?,"
            + "`car_body_style`=?,`price_for_day`=?,"
            + "`seats`=?,`doors`=?,`gearbox type`=?,`accessible`=?,"
            + "`location_id`=? WHERE id = ?";
    private static final String DELETE = "DELETE FROM shcherba.car WHERE id=?";

    @Override
    public List<Car> findAll() throws SQLException {
        List<Car> cars = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager
                .getConnection()
                .prepareStatement(GET_ALL)) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Car car = new Car(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("car_body_style"),
                        rs.getFloat("price_for_day"),
                        rs.getInt("seats"),
                        rs.getInt("doors"),
                        rs.getString("gearbox type"),
                        rs.getBoolean("accessible"),
                        rs.getInt("location_id")
                );
                cars.add(car);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cars;

    }

    @Override
    public void create(Car car) throws SQLException {
        try (PreparedStatement statement = ConnectionManager
                .getConnection()
                .prepareStatement(CREATE)) {

            statement.setString(1, String.valueOf(car.getName()));
            statement.setString(2, String.valueOf(car.getCar_body_style()));
            statement.setFloat(3, car.getPrice_for_day());
            statement.setInt(4, car.getSeats());
            statement.setInt(5, car.getDoors());
            statement.setString(6, String.valueOf(car.getGearbox_type()));
            statement.setBoolean(7, car.getAccessible());
            statement.setInt(8, car.getLocation());

            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Car car) throws SQLException {
        try (PreparedStatement statement = ConnectionManager
                .getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, String.valueOf(car.getName()));
            statement.setString(2, String.valueOf(car.getCar_body_style()));
            statement.setFloat(3, car.getPrice_for_day());
            statement.setInt(4, car.getSeats());
            statement.setInt(5, car.getDoors());
            statement.setString(6, String.valueOf(car.getGearbox_type()));
            statement.setBoolean(7, car.getAccessible());
            statement.setInt(8, car.getLocation());
            statement.setInt(9, car.getId());

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
