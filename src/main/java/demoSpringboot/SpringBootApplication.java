package demoSpringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration; 
import org.springframework.context.annotation.ComponentScan;
 
@EnableAutoConfiguration
@ComponentScan(basePackages={"demoSpringboot"})

public class SpringBootApplication{
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class); 
    }
  
}