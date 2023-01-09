package com.anjaneya.spring.boot.bean.configurations;

import com.anjaneya.spring.boot.bean.configurations.entity.Customer;
import com.anjaneya.spring.boot.bean.configurations.entity.Company;
import com.anjaneya.spring.boot.bean.configurations.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootBeanConfigurationsApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(SpringBootBeanConfigurationsApplication.class, args);

		//Customer using xml configuration

		Customer customer = applicationContext.getBean(Customer.class);
		customer.setId(101);
		customer.setName("Arjan");
		customer.setAddress("Jaliya (manaji)");

		System.out.println(customer);

		//Shop using java based configuration

		Company company = applicationContext.getBean(Company.class);
		company.setId(1);
		company.setName("Anjaneya");

		System.out.println(company);

		//student using Annotation

		Student student = applicationContext.getBean(Student.class);

		student.setId(102);
		student.setName("Ajay");

		System.out.println(student);

	}

}
