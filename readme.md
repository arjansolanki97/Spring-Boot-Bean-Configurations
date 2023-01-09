# Java Annotation and XML Bean Configurations with Spring Boot

Spring allows you to configure your beans using Java and XML. In this project, we will explore how to use XML and Java Configurations with Spring Boot. We will understand how to load these configurations into a Spring Application Context.


#### A few details

| File | Description |
| ------ | ------ |
| `SpringBootBeanConfigurationsApplication.java` | The Spring Boot Application class generated with Spring Initializer. This class acts as the launching point for application |
| `pom.xml` | Contains all the dependencies needed to build this project. We will use Spring Boot Starter AOP. |
| `JavaConfiguration.java` | Java Configuration file that contains the bean definitions. |
| `XmlConfiguration.java` | Defines Configuration based on the applicationContext.xml |
| `applicationContext.xml` | XML Configuration file that contains the bean definitions. |

### [Customer.java](src/main/java/com/anjaneya/spring/boot/bean/configurations/entity/Student.java)
```java
public class Customer {

    int id;
    String name;
    String address;

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String
    toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
```

### [Student.java](src/main/java/com/anjaneya/spring/boot/bean/configurations/entity/Student.java)
```java
@Component
public class Student {

    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
```

### [Company.java](src/main/java/com/anjaneya/spring/boot/bean/configurations/entity/Company.java)
```java
public class Company {

    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

```

### [SpringBootBeanConfigurationsApplication.java](src/main/java/com/anjaneya/spring/boot/bean/configurations/SpringBootBeanConfigurationsApplication.java)

```java
@SpringBootApplication
public class SpringBootBeanConfigurationsApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(SpringBootBeanConfigurationsApplication.class, args);

        //Customer

        Customer customer = applicationContext.getBean(Customer.class);
        customer.setId(101);
        customer.setName("Arjan");
        customer.setAddress("Jaliya (manaji)");

        System.out.println(customer);
        
        //student

        Student student = applicationContext.getBean(Student.class);

        student.setId(102);
        student.setName("Ajay");

        System.out.println(student);

    }

}@SpringBootApplication
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

```
```
Customer{id=101, name='Arjan', address='Jaliya (manaji)'}
Shop{id=1, name='Anjaneya'}
Student{id=102, name='Ajay'}
```

### [JavaConfiguration.java](src/main/java/com/anjaneya/spring/boot/bean/configurations/JavaConfiguration.java)

```java
@Configuration
public class JavaConfiguration {

    @Bean
    public Company getCustomer() {
        return new Company();
    }
}
```
### [XmlConfiguration.java](src/main/java/com/anjaneya/spring/boot/bean/configurations/XmlConfiguration.java)

```java
@Configuration
@ImportResource({"classpath*:applicationContext.xml"})
public class XmlConfiguration {
}
```

### [applicationContext.xml](src/main/resources/applicationContext.xml)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="customer" class="com.anjaneya.spring.boot.bean.configurations.entity.Customer"/>

</beans>
```

### Should you use XML or Annotation based bean definitions?

Which is better depends on

- context
- preference of the team.

If you are maintaining an old project with XML bean definitions, the choice is already made for you.

If you are creating a new project and if the configuration is specific to auto-wiring or declaring a bean - for example @Service, @Component, @Autowired - I prefer annotations.