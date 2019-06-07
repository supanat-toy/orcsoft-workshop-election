package th.co.orcsoft.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@ComponentScan("th.co.orcsoft.training")
public class SpringBootsDemo {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootsDemo.class, args);
	}
	//Test By Ice
}
