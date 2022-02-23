package vie.pie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan (basePackages = {"vie.pi.web","vie.pi.service","vie.pi.config"})

public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}


