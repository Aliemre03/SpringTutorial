package com.example.springtutorial;

import com.example.springtutorial.model.Customer;
import com.example.springtutorial.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Clock;

@SpringBootApplication
public class SpringTutorialApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public SpringTutorialApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringTutorialApplication.class, args);
    }


    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }

    @Override
    public void run(String... args) {
        Customer customer = customerRepository.save(new Customer("Cagri", "Dursun"));
        Customer customer2 = customerRepository.save(new Customer("Alice", "Bob"));

        System.out.println(customer);
        System.out.println(customer2);

    }

}
