package com.springbootsunilblog.springbootsunilblog.configeration.auth;


import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.springbootsunilblog.springbootsunilblog.model.Users;
import com.springbootsunilblog.springbootsunilblog.repository.UserRepository;

//import static org.springframework.security.config.Customizer.withDefaults;

@EnableMethodSecurity
@Configuration
public class springSecurityHandling  implements UserDetailsService{
	@Autowired
	  private  UserRepository userRepository;
/*
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
         .csrf().disable()
         .authorizeHttpRequests() 
         .requestMatchers("/blog.api/**").hasRole("user")
         .anyRequest().authenticated()
         .and()
         .httpBasic();
 return httpSecurity.build();
}
	*/
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests((authorize) ->
        authorize.requestMatchers(HttpMethod.GET,"/blog/api/user/**").permitAll()
        .requestMatchers(HttpMethod.POST,"/blog/api/**").permitAll()   //  .hasRole("ADMIN")
           	.anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	/*
	@Bean
	public void configureGlobal(AuthenticationManagerBuilder auth) 
			  throws Exception {
			    auth.jdbcAuthentication()
			      .dataSource(datasourse())
			      .usersByUsernameQuery("select username,password "
			        + "from  user "
			        + "where username = ?")
			      .authoritiesByUsernameQuery("select username,authority  "
			        + "from authorities "
			        + "where username = ?");
			}
	//username, password, enabled
	//username, authority
	
	@Bean
	JdbcUserDetailsManager jdbcUserDetailsManager(DataSource datasource) {
		JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(datasource);
		return jdbcUserDetailsManager;
		
	}

	@Bean	
	public DataSource	datasourse() {
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/bookstore");
		dataSource.setUsername("root");
		dataSource.setPassword("sunil123");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.5Driver");
		return dataSource;
		
	}
	
	
	
	
	
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.builder().username("sunil").password(passwordEncoder().encode("101")).roles("ADMIN")
				.build();
		UserDetails user1 = User.builder().username("kumar").password(passwordEncoder().encode("102")).roles("user")
				.build();
	
		return new InMemoryUserDetailsManager(user, user1);

	}
	*/
	
	
	
	
	 @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
	            throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByEmail(username);

		Set<GrantedAuthority> authorities = user.getRoles().stream()
				.map((role) -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toSet());

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}
	
	
	
	
	
	
}
	
	
	


