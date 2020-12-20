package nx.panda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationNX {
	
  public static void main(String[] args) {
	  SpringApplication.run(ApplicationNX.class, args);
	  System.out.println("hello,panda 启动项目成功");
  }
}
