package pl.kosteklvp.transfermarkt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class TransfermarktApplication {

  public static void main(String[] args) {
    SpringApplication.run(TransfermarktApplication.class, args);
  }

}
