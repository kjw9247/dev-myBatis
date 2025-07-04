package com.example.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j2;

// 사용자가 정의한 클래스도 스프링 컨테이너로 부터 객체 주입에 대한 관리를 받을 수 있다
// 클래스 선언 앞에 @Configuration을 붙이면 된다
// 클래스 내부에 메서드를 통해서 객체를 주입받는 경우 메서드 선언 앞에
// @Bean 어노테이션을 붙인다 
// 스프링 컾ㄴ테이너가 기동하면 바로 읽는다
@Log4j2
@Configuration
@PropertySource("classpath:/application.yml")
public class DatabaseConfiguration {
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}

	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new HikariDataSource(hikariConfig());
		log.info("datasource : {}", dataSource);
		return dataSource;
	}
	@Autowired
	private ApplicationContext applicationContext;

  // Class.forName, Connection con, PreparedStatement, ResultSet
	@Bean // connection 연결하는 부분
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		//classpath는 src/main/resources이고 해당 쿼리가 있는 xml 위치는 본인의 취향대로 위치키시고 그에 맞도록 설정해주면 된다.
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
  // PreparedStatement가 제공하는 executeQuery(), executeUpdate()역할을
  // 하는 메서드를 제공하는 클래스가 SqlSessionTemplate이다
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}	
}
