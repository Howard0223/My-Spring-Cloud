package tw.com.myproject.springcloud.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {

	@Value("${server.port}")
	private String THIS_PORT;

	@RequestMapping(value = "/payment/consul")
	public String paymentConsul() {
		return "Spring Cloud With Consul：" + THIS_PORT + "\t" + UUID.randomUUID();
		
	}

}
