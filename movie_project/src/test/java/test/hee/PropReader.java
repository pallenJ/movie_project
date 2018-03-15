package test.hee;
import java.io.FileInputStream;
import java.util.Properties;

public class PropReader {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
         
        try{
             
            // 프로퍼티 파일 위치
//           String propFile = "C:\\webLee\\8.spring\\sts-workspace\\kgv\\src\\main\\webapp\\WEB-INF\\properties\\database.properties";
        	 String propFile = "src/main/webapp/WEB-INF/properties/database.properties";
         	
            // 프로퍼티 객체 생성
            Properties props = new Properties();
             
            // 프로퍼티 파일 스트림에 담기
            FileInputStream fis = new FileInputStream(propFile);
             
            // 프로퍼티 파일 로딩
            props.load(new java.io.BufferedInputStream(fis));
             
            // 항목 읽기
            String msg = props.getProperty("database.driver") ;
            String maxAction = props.getProperty("database.maxAction") ;
            // 콘솔 출력
            System.out.println(msg) ;
            System.out.println(maxAction);
             
        }catch(Exception e){
            e.printStackTrace();
        }
         
         
         
 
    }
}