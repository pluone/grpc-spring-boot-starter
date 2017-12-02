import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEurekaClient
@SpringBootApplication
public class GreeterServiceConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GreeterServiceConsumerApplication.class, args);
    }
}