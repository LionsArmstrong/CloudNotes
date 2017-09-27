package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.example.demo"})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class DemoApplication {

	/**
	 *
	 * @param args
	 *
	 *
	 *
	 @ComponentScan//开启通用注解扫描
	 public class Application extends org.springframework.boot.web.support.SpringBootServletInitializer {

	 //实现SpringBootServletInitializer可以让spring-boot项目在web容器中运行

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		builder.sources(this.getClass());
		return super.configure(builder);
	}
	 */

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}


