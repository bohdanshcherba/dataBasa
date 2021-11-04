package ua.lviv.iot.view;

import ua.lviv.iot.controller.implementation.CarController;
import ua.lviv.iot.controller.implementation.FineController;
import ua.lviv.iot.controller.implementation.LocationController;
import ua.lviv.iot.controller.implementation.UserController;
import ua.lviv.iot.model.Car;
import ua.lviv.iot.model.Fine;
import ua.lviv.iot.model.Location;
import ua.lviv.iot.model.User;

import java.sql.SQLException;
import java.util.*;

public class MyView {
    private final Scanner input = new Scanner(System.in);
    private final Map<String, Printable> menu = new LinkedHashMap<>();

    private final CarController carController = new CarController();
    private final LocationController locationController
            = new LocationController();
    private final FineController fineController = new FineController();
    private final UserController userController = new UserController();

    public MyView() {
        menu.put("11", this::getAllCar);
        menu.put("12", this::createCar);
        menu.put("13", this::updateCar);
        menu.put("14", this::deleteCar);

        menu.put("21", this::getAllLocation);
        menu.put("22", this::createLocation);
        menu.put("23", this::updateLocation);
        menu.put("24", this::deleteLocation);

        menu.put("31", this::getAllUser);
        menu.put("32", this::createUser);
        menu.put("33", this::updateUser);
        menu.put("34", this::deleteUser);

        menu.put("41", this::getAllFine);
        menu.put("42", this::createFine);
        menu.put("43", this::updateFine);
        menu.put("44", this::deleteFine);

        menu.put("00", this::exit);

    }

    public final void show() {
        String scan;
        ShowMenu showMenu = new ShowMenu();

        do {
            showMenu.displayMenu();
            System.out.println("\n Chose number: ");
            try {

                scan = input.next();
                menu.get(scan).print();
            } catch (Exception ignored) {
            }
        } while (true);
    }

    private void exit() {
        System.out.println("App closed");
        System.exit(0);

    }

    private void getAllCar() throws SQLException {

        List<Car> cars = carController.findAll();

        System.out.format("| %3s | %-30s | %-20s | %-15s |"
                        + " %-5s | %-8s | %-15s | %-10s | %-10s |\n", "id", "name",
                "car_body_style", "price_for_day", "seats",
                "doors", "gearbox type",
                "accessible", "location_id");
        System.out.print("-------------------------------------"
                + "-----------------------------------------------------"
                + "--------------------------------------------------------\n");
        for (Car entity : cars) {
            System.out.print(entity.toString());
        }
        System.out.print("------------------------------------------"
                + "------------------------------------------------"
                + "--------------------------------------------------------\n");

    }

    private Car getCarInputs() {
        System.out.print("\nEnter car name: ");
        String name = input.next();
        System.out.print("\nEnter car body style: ");
        String carBodyStyle = input.next();
        System.out.print("\nEnter price for day: ");
        Float priceForDay = Float.valueOf(input.next());
        System.out.print("\nEnter seats: ");
        Integer seats = Integer.valueOf(input.next());
        System.out.print("\nEnter doors: ");
        Integer doors = Integer.valueOf(input.next());
        System.out.print("\nEnter gearbox type: ");
        String gearboxType = input.next();
        System.out.print("\nEnter accessible (true/false): ");
        Boolean accessible = Boolean.valueOf(input.next());
        System.out.print("\nEnter location id: ");
        Integer locationId = Integer.valueOf(input.next());

        return new Car(name, carBodyStyle, priceForDay,
                seats, doors, gearboxType, accessible, locationId);
    }

    private void createCar() throws SQLException {
        Car car = getCarInputs();
        carController.create(car);
        System.out.println("Car was created");
        System.out.println(car.toString());

    }

    private void updateCar() throws SQLException {
        System.out.println("\n Enter ID for updating");
        Integer id = input.nextInt();
        Car car = getCarInputs();
        car.setId(id);
        carController.update(car.getId(), car);
        System.out.println("Id: " + id + " was updated");
        System.out.println(car.toString());


    }

    private void deleteCar() throws SQLException {
        System.out.println("\n Enter ID for delete");
        Integer id = input.nextInt();
        carController.delete(id);
        System.out.println("Id: " + id + " was delete");
    }


    private void getAllLocation() throws SQLException {
        System.out.println(locationController.findAll());
    }

    private Location getLocationInputs() throws SQLException {
        System.out.print("\nEnter location name: ");
        String name = input.next();
        System.out.print("\nEnter Country: ");
        String country = input.next();
        System.out.print("\nEnter city: ");
        String city = String.valueOf(input.next());
        System.out.print("\nEnter street: ");
        String street = String.valueOf(input.next());
        System.out.print("\nEnter number: ");
        String number = String.valueOf(input.next());
        System.out.print("\nEnter zip_code: ");
        String zipCode = input.next();
        System.out.print("\nEnter number_available_cars: ");
        Integer numberAvailableCars = Integer.valueOf(input.next());

        return new Location(name, country, city,
                street, number,
                zipCode, numberAvailableCars);
    }

    private void createLocation() throws SQLException {
        Location location = getLocationInputs();
        locationController.create(location);
        System.out.println("location was created");
        System.out.println(location.toString());
    }

    private void updateLocation() throws SQLException {
        System.out.println("\n Enter ID for updating");
        Integer id = input.nextInt();
        Location location = getLocationInputs();

        location.setId(id);
        locationController.update(location.getId(), location);
        System.out.println("Id: " + id + " was updated");
        System.out.println(location.toString());
    }

    private void deleteLocation() throws SQLException {
        System.out.println("\n Enter ID for delete");
        Integer id = input.nextInt();
        locationController.delete(id);
        System.out.println("Id: " + id + " was delete");
    }


    private void getAllUser() throws SQLException {
        System.out.println(userController.findAll());
    }

    private User getUserInputs() throws SQLException {
        System.out.print("\nEnter first name: ");
        String firstName = input.next();
        System.out.print("\nEnter last name: ");
        String lastName = input.next();
        System.out.print("\nEnter identity document: ");
        String identityDocument = String.valueOf(input.next());
        System.out.print("\nEnter  driver license: ");
        String driverLicense = String.valueOf(input.next());
        System.out.print("\nEnter mail: ");
        String mail = String.valueOf(input.next());
        System.out.print("\nEnter phone_number: ");
        String phoneNumber = input.next();
        System.out.print("\nEnter payment card: ");
        String paymentCard = String.valueOf(input.next());
        System.out.print("\nEnter security login: ");
        String securityLogin = String.valueOf(input.next());
        return new User(firstName, lastName, identityDocument,
                driverLicense, mail,
                phoneNumber, paymentCard, securityLogin);
    }

    private void createUser() throws SQLException {
        User user = getUserInputs();
        try {
            userController.create(user);
            System.out.println("User was created");
            System.out.println(user.toString());
        } catch (Exception e) {
            System.out.println("not correct entry");
        }


    }

    private void updateUser() throws SQLException {
        System.out.println("\n Enter ID for updating");
        Integer id = input.nextInt();
        User user = getUserInputs();

        user.setId(id);
        userController.update(user.getId(), user);
        System.out.println("Id: " + id + " was updated");
        System.out.println(user.toString());

    }

    private void deleteUser() throws SQLException {
        System.out.println("\n Enter ID for delete");
        Integer id = input.nextInt();
        userController.delete(id);
        System.out.println("Id: " + id + " was delete");
    }


    private void getAllFine() throws SQLException {
        System.out.println(fineController.findAll());
    }

    private Fine getFineInputs() throws SQLException {
        System.out.print("\nEnter type of fine: ");
        String typeOfFine = input.next();
        System.out.print("\nEnter date: ");
        String date = input.next();
        System.out.print("\nEnter identity document(user_id): ");
        Integer userId = Integer.valueOf(input.next());

        return new Fine(typeOfFine, date, userId);
    }

    private void createFine() throws SQLException {
        Fine fine = getFineInputs();
        fineController.create(fine);
        System.out.println("location was created");
        System.out.println(fine.toString());
    }

    private void updateFine() throws SQLException {
        System.out.println("\n Enter ID for updating");
        Integer id = input.nextInt();
        Fine fine = getFineInputs();

        fine.setId(id);
        fineController.update(fine.getId(), fine);
        System.out.println("Id: " + id + " was updated");
        System.out.println(fine.toString());
    }

    private void deleteFine() throws SQLException {
        System.out.println("\n Enter ID for delete");
        Integer id = input.nextInt();
        fineController.delete(id);
        System.out.println("Id: " + id + " was delete");
    }
}
