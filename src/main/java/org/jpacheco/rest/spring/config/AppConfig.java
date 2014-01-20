package org.jpacheco.rest.spring.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("org.jpacheco.rest.spring.mapper") 
@ComponentScan( basePackages = "org.jpacheco.rest" )
//@ImportResource( { "classpath*:persistenceContext.xml" } )
//@PropertySource({ "classpath:rest.properties", "classpath:web.properties" })
@Configuration
@EnableTransactionManagement
public class AppConfig{
 

@Bean
   public static PropertySourcesPlaceholderConfigurer properties() {
      return new PropertySourcesPlaceholderConfigurer();
   }
   
   
   @Bean
   public DataSource dataSource() {
       EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
       builder.setType(EmbeddedDatabaseType.H2).addScript("classpath:db/schema/schema.sql").addScript("classpath:db/schema/data.sql");
       return builder.build();
   }
   
   @Bean   
   public DataSourceTransactionManager transactionManager() 
   {     
        return new DataSourceTransactionManager(dataSource());   
   }  
   
   
   @Bean   
   public SqlSessionFactory sqlSessionFactory() throws Exception 
   {     
	   Resource [] resources = new Resource [] {new ClassPathResource("mappers/ProfesorMapper.xml"), new ClassPathResource("mappers/CursosMapper.xml")};
       SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean(); 
       sessionFactory.setDataSource(dataSource());    
       sessionFactory.setMapperLocations(resources);
       return sessionFactory.getObject();   
   }
}