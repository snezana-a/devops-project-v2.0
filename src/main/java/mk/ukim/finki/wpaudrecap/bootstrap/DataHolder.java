package mk.ukim.finki.wpaudrecap.bootstrap;

import mk.ukim.finki.wpaudrecap.model.Category;
import mk.ukim.finki.wpaudrecap.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Category> categories = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        categories.add(new Category("Books", "Books category"));
        categories.add(new Category("Movies", "Movies category"));

        users.add(new User("snezana.a", "sa", "Snezana", "Anastasova"));
        users.add(new User("natasha.a", "na", "Natasha", "Anastasova"));
    }

}
