package mp.configuration;

import javax.servlet.ServletContext;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
@Configuration
@PropertySource("classpath:/database.properties")
@ComponentScan(basePackages= {
		"mp.member.model", "mp.member.service", 
		"mp.movie.model", "mp.movie.service",
		"mp.theater.model", "mp.theater.service",
		"mp.board.model", "mp.board.service",
		"mp.schedule.model", "mp.schedule.service",
		"mp.payment.model", "mp.payment.service"
})
public class AllConfiguration {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		 return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Value("${database.driver}")
	private String driver;
	@Value("${database.url}")
	private String url;
	@Value("${database.username}")
	private String username;
	@Value("${database.password}")
	private String password;
	@Value("${database.maxAction}")
	private String maxAction;
	@Value("${database.maxIdle}")
	private String maxIdle;
	@Value("${database.maxWait}")
	private String maxWait; 
	
	@Bean
	//		형태				아이디
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(driver);
		source.setUrl(url);
		source.setUsername(username);
		source.setPassword(password);
		
		source.setMaxTotal(Integer.parseInt(maxAction));
		source.setMaxIdle(Integer.parseInt(maxIdle));
		source.setMaxWaitMillis(Integer.parseInt(maxWait));
		return source;
	}
	 
	@Bean
	public JdbcTemplate jdbcTempate() {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource());//ref 설정
		return template;
	}
	
	

}
