package ag04.errand.invoice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ComponentScan
@Configuration
@EnableAutoConfiguration
public class Config extends WebMvcConfigurerAdapter {
	
    @Bean(name = "dataSource")
 public DriverManagerDataSource dataSource() {
     DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
     driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
     driverManagerDataSource.setUrl("jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/heroku_cc915c042a3814f?reconnect=true&useUnicode=yes&characterEncoding=UTF-8");
     driverManagerDataSource.setUsername("ba5ab936b9a42b");
     driverManagerDataSource.setPassword("54e3415841bdbc5");
     return driverManagerDataSource;
 }

  
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
   //     registry.addViewController("/new").setViewName("new");
    }


    
   public static void main(String[] args) {
	SpringApplication.run(Config.class, args);
}

}
