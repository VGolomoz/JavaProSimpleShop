package simpleshop.utility;

import simpleshop.entity.Product;
import simpleshop.entity.User;
import simpleshop.service.DAO;

public class FillDB {

    public static void initDB() {

        User client = new User("client", "client", "client");
        User manager = new User("manager", "manager", "manager");
        Product coffeeArabic = new Product("Arabic Cofee", 15L);
        Product coffeeTurkey = new Product("Turkey Coffee", 10L);
        Product teaEnglish = new Product("English Tea", 5L);
        Product teaChineese = new Product("Chineese Tea", 15L);
        Product milk = new Product("Milk", 10L);

        DAO.getInstance().create(client, manager, coffeeArabic, coffeeTurkey, teaEnglish, teaChineese, milk);
    }
}
