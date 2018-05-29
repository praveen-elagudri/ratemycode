package com.ratemycode;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.ratemycode.domain.LoginCredentialsEntity;
import com.ratemycode.model.Customer;
import com.ratemycode.repositories.LoginCredentialsRepository;
import com.ratemycode.repository.CustomerRepository;

@SpringBootApplication
public class SpringDataCassandraApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	LoginCredentialsRepository loginRepository;
	
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.getServletRegistration(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
                .setInitParameter("dispatchOptionsRequest", "true");
    }
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringDataCassandraApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringDataCassandraApplication.class, args);
    }

    @Override
	public void run(String... args) throws Exception {
		/*clearData();
		saveData();
		lookup();*/
	}
	
	public void clearData(){
		customerRepository.deleteAll();
	}
	
	public void saveData(){
		System.out.println("===================Save Customers to Cassandra===================");
		Customer cust_1 = new Customer(1, "Peter", "Smith", 20);
        Customer cust_2 = new Customer(2, "Mary", "Taylor", 25);
        Customer cust_3 = new Customer(3, "Peter", "Brown", 30);
        Customer cust_4 = new Customer(4, "Lauren", "Taylor", 20);
        Customer cust_5 = new Customer(5, "Lauren", "Flores", 45);
        Customer cust_6 = new Customer(6, "Peter", "Williams", 20);
        
        
        
        // save customers to ElasticSearch
        customerRepository.save(cust_1);
        customerRepository.save(cust_2);
        customerRepository.save(cust_3);
        customerRepository.save(cust_4);
        customerRepository.save(cust_5);
        customerRepository.save(cust_6);
        
       /* LoginCredentialsEntity login1 = new LoginCredentialsEntity();
        login1.setId(UUID.randomUUID());
        login1.setEmail("test1@gmail.com");
        login1.setPassword("test");
        
        LoginCredentialsEntity login2 = new LoginCredentialsEntity();
        login2.setId(UUID.randomUUID());
        login2.setEmail("test2@gmail.com");
        login2.setPassword("test");
        
        LoginCredentialsEntity login3 = new LoginCredentialsEntity();
        login3.setId(UUID.randomUUID());
        login3.setEmail("test3@gmail.com");
        login3.setPassword("test");
        
        loginRepository.save(login1);
        loginRepository.save(login2);
        loginRepository.save(login3);*/
        
	}
	
	public void lookup(){
		System.out.println("===================Lookup Customers from Cassandra by Firstname===================");
		List<Customer> peters = customerRepository.findByFirstname("Peter");
		peters.forEach(System.out::println);

		System.out.println("===================Lookup Customers from Cassandra by Age===================");
		Customer customer = customerRepository.findCustomerHasAgeGreaterThan("Peter", "Williams");
		System.out.println(customer.toString());
		//List<Customer> custsAgeGreaterThan25 = customerRepository.findCustomerHasAgeGreaterThan(25);
		//custsAgeGreaterThan25.forEach(System.out::println);
	}
	
	
	
}

