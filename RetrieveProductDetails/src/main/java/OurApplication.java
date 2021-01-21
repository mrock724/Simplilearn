import desserts.*;

import java.sql.*;
import java.util.*;

public class OurApplication {

    public static void main(String[] args) {
        
    }

    static int counter = 0;
/*
    public static void createReadUpdateDelete() {

        DrinkDAO drinkDAO = new DrinkDAOImpl();
        DrinkDTO drink = drinkDAO.create(new DrinkDTO(
                "orange juice",
                true
        ));

        drinkDAO.remove(4L);

        drink.setName("not orange juice");
        drinkDAO.update(drink);

        List<DrinkDTO> drinks = drinkDAO.getAll();
        drinks.forEach((d) -> System.out.println(d.toString()));

    }
*/
    public static void dbLifeCycleExample() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root")) {

            String ourDatabase = "mynewdatabase";
            try (Statement statement = conn.createStatement()) {

                int affectedRows = statement.executeUpdate("CREATE DATABASE " + ourDatabase);
                if (affectedRows == 0) {
                    System.out.println("no changes");
                } else {
                    System.out.println("database[" + ourDatabase + "] created");
                }

                useDatabase(ourDatabase, statement);

                dropDatabase(ourDatabase, statement);
            }

        } catch (SQLException e) {
            System.out.println("SQL exception");
            e.printStackTrace();
        }
    }

    public static void dropDatabase(String db, Statement statement) {
        try {
            statement.execute("DROP DATABASE " + db);
            System.out.println("database [" + db + "] dropped");
        } catch (SQLException e) {
            System.out.println("Unable to run query");
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());
            e.printStackTrace();
        }
    }

    public static void useDatabase(String db, Statement statement) {
        try {
            statement.execute("USE " + db);
            System.out.println("switched");
        } catch (SQLException e) {
            System.out.println("Unable to run query");
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());
            e.printStackTrace();
        }
    }

    public static void storedProcedureExample() {
        DessertDAOImpl dessertDAO = new DessertDAOImpl();
        String art = dessertDAO.getGoodDesserts("Totallygood", true);
        System.out.println(art);

        System.out.println(dessertDAO.isGood(1L));
    }

    public static void dbConnectExample() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/desserts?createDatabaseIfNotExist=true", "root", "root")) {
            if (conn != null) {
                System.out.println("Connected to the database!");
                String query = "select id, name from goodstuff";
                try (Statement stmt = conn.createStatement()) {
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        System.out.println(id + ", " + name);
                    }
                }
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void daoExample() {

        GenericDAO<DessertDTO> dessertDAO = new DessertDAOImpl();
        List<DessertDTO> desserts = dessertDAO.getAll();

        DessertDTO pudding = new DessertDTO(
                12L, "pudding", false
        );

        dessertDAO.create(pudding);
        System.out.println("List size: " + dessertDAO.count());
        dessertDAO.remove(pudding);
        System.out.println("List size: " + dessertDAO.count());

        for (DessertDTO dessert : desserts) {
            System.out.println(dessert);
        }

    }


}
