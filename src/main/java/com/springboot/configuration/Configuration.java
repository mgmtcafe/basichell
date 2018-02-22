package com.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@SuppressWarnings("deprecation")
@org.springframework.context.annotation.Configuration
public class Configuration {

	@SuppressWarnings("deprecation")
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
	    return new HibernateJpaSessionFactoryBean();
	}

}
