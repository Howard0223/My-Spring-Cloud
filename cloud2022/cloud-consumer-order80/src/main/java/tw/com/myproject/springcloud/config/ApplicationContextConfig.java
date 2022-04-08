package tw.com.myproject.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import tw.com.myproject.springcloud.lb.LoadBalancer;
import tw.com.myproject.springcloud.lb.MyLB;

@Configuration
public class ApplicationContextConfig {
	
	@Bean
	//@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public LoadBalancer getLoadBalancer() {
		return new MyLB();
	}
}
