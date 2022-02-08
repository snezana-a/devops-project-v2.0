package mk.ukim.finki.wpaudrecap.bootstrap;

import lombok.Getter;
import mk.ukim.finki.wpaudrecap.model.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Category> categories = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static List<ShoppingCart> shoppingCarts = new ArrayList<>();

    /*@PostConstruct
    public void init() {
        categories.add(new Category("Books", "Books category"));
        categories.add(new Category("Movies", "Movies category"));

        users.add(new User("snezana.a", "sa", "Snezana", "Anastasova"));
        users.add(new User("natasha.a", "na", "Natasha", "Anastasova"));

        Manufacturer manufacturer = new Manufacturer("Nike", "USA");
        manufacturers.add(manufacturer);

        Category category = new Category("Sport", "Sport Category");
        categories.add(category);

        products.add(new Product("Ball1", 56.5, 4, category, manufacturer));
        products.add(new Product("Ball2", 995.5, 47, category, manufacturer));
        products.add(new Product("Ball3", 16.5, 42, category, manufacturer));
    }*/

}
