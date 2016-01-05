package ag04.errand.invoice.main;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;


@EnableWebMvcSecurity
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
	@Autowired
	DataSource datasource;
	/// accessing users and passwords
	 @Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	   auth.jdbcAuthentication().dataSource((javax.sql.DataSource) this.datasource)
	  .usersByUsernameQuery(
	   "select user_name,password, 'true' from users where user_name=?")
	  .authoritiesByUsernameQuery(
  
	"select user_name ,'ROLE_USERS'	 from users where user_name=?");
	   
	   
	 } 
	 
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter,CsrfFilter.class);
		
        
		
	
		
	  http.authorizeRequests()
.antMatchers("/invoice/*").access("hasRole('ROLE_USERS')")
.antMatchers("/invoice").access("hasRole('ROLE_USERS')")
.anyRequest().permitAll()
.and()
  .formLogin().loginPage("/login")
  .usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/invoice", true)
  .failureUrl("/login?error")
  
.and()
  .logout().logoutSuccessUrl("/login?logout") 
 .and()
 .exceptionHandling().accessDeniedPage("/login?error")
.and()
  .csrf();
	  
	
	}}
