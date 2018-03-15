package mp.configuration;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
//@ComponentScan(basePackages= {})
public class JdbcConfiguration {
	private String driver;
	private String url;
	private String username;
	private String password;
	private String maxAction;
	private String maxIdle;
	private String maxWait; 
	
	//자바 코드로 프로퍼티 파일의 내용을 받아와야한다.
	private void getPropertyfile() {
        try{
            // 프로퍼티 파일 위치
        	 String propFile = "src/main/webapp/WEB-INF/properties/database.properties";
            // 프로퍼티 객체 생성
            Properties props = new Properties();
            // 프로퍼티 파일 스트림에 담기
            FileInputStream fis = new FileInputStream(propFile);
            // 프로퍼티 파일 로딩
            props.load(new java.io.BufferedInputStream(fis));
            // 항목 읽기
            driver = props.getProperty("database.driver") ;
            url = props.getProperty("database.url") ;
            username = props.getProperty("database.username") ;
            password = props.getProperty("database.password") ;
            maxAction = props.getProperty("database.maxAction") ;
            maxIdle = props.getProperty("database.maxIdle") ;
            maxWait = props.getProperty("database.maxWait") ;
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	 
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
