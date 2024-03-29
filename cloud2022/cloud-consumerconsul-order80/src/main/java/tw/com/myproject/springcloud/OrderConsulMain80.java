package tw.com.myproject.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain80 {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(OrderConsulMain80.class, args);
	}

}
