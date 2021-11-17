package mk.ukim.finki.wpaudrecap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class WpAudRecapApplication {

    public static void main(String[] args) {
        SpringApplication.run(WpAudRecapApplication.class, args);
    }

}
