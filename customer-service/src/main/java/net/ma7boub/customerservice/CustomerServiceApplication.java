package net.ma7boub.customerservice;

import net.ma7boub.customerservice.config.CustomerConfigParams;
import net.ma7boub.customerservice.entities.Customer;
import net.ma7boub.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository ){
		return args -> {
			customerRepository.save(Customer.builder()
							.name("Mahboub Marouane").email("marouane.ma7boub@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("Imane").email("imane@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("Yassine").email("yassine@gmail.com")
					.build());
			customerRepository.findAll().forEach(c->{
				System.out.println("======================");
				System.out.println(c.getId());
				System.out.println(c.getName());
				System.out.println(c.getEmail());
				System.out.println("=======================");
			});
		};
	}

}
