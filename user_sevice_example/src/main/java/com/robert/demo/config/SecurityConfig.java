package com.robert.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler exampleAuthenticationSuccessHandler;

//    @Qualifier("dataSource")
//    @Autowired
//    DataSource dataSource;

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        /** In-memory user store demo  ******/
//        auth.inMemoryAuthentication()
//                .withUser("julia")
//                    .password("{noop}tiger")
//                    .authorities("ROLE_USER")
//                .and()
//                .withUser("james")
//                    .password("{noop}lion")
//                    .authorities("ROLE_ADMIN");
        /**************************************/
        /** JDBC-based user store ****/
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(
//                    "select username, password, enabled from Users " + "where username=?"
//                ).authoritiesByUsernameQuery(
//                    "select username, authority from User_Authorities " + "where username=?");
        //.passwordEncoder(new NoOpPasswordEncoder());
        /** JDBC-based user store end **/

        /** LDAP-based user store **/
//        auth.ldapAuthentication()
//                .userSearchBase("ou=people")
//                .userSearchFilter("(uid={0})")
//                .contextSource()
//                .url("ldap://localhost:8389/dc=didispace,dc=com")
//                .and()
//                .passwordCompare()
//                .passwordEncoder(new LdapShaPasswordEncoder())
//                .passwordAttribute("userPassword");;

//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/imooc-signIn.html")
                .loginProcessingUrl("/authentication/form")
//                .loginPage("/authentication/require")
                .successHandler(exampleAuthenticationSuccessHandler)
//                .and()
//                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/imooc-signIn.html","/user").permitAll()
                //.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                //.antMatchers("/authentication/require").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
                ;

    }
}
