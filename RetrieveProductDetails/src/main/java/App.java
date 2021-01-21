import desserts.GenericDAO;
import desserts.DessertDAOImpl;
import desserts.DessertDTO;

import java.io.*;

public class App {

    static int counter = 0;

    public static void main(String[] args) throws IOException {

        GenericDAO<DessertDTO> dessertDAO = new DessertDAOImpl();
        //List<DessertDTO> desserts = dessertDAO.getDesserts();

        DessertDTO pudding = new DessertDTO(
                "pudding", false
        );

        dessertDAO.create(pudding);
        System.out.println("List size: " + dessertDAO.count());
        //dessertDAO.eat(pudding);
        System.out.println("List size: " + dessertDAO.count());
/*
        for (DessertDTO dessert : desserts) {
            System.out.println(dessert);
        }
*/



    }

}
