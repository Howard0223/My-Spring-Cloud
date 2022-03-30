package tw.com.myproject.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import tw.com.myproject.springcloud.entities.CommonResult;
import tw.com.myproject.springcloud.entities.Payment;

@RestController
public class OrderController {
	
	//private static final String PAYMENT_URL = "http://localhost:8001/payment";
	private static final String PAYMENT_URL = "http://cloud-payment-service/payment";
	@Resource
	private RestTemplate restTemplate;
	
	@PostMapping(value = "/consumer/create")
	public CommonResult create(Payment payment){
		return restTemplate.postForObject(PAYMENT_URL + "/create", payment, CommonResult.class);
	}
	
	@GetMapping(value = "/consumer/get/{id}")
	public CommonResult get(@PathVariable Long id){
		return restTemplate.getForObject(PAYMENT_URL + "/get/" + id, CommonResult.class);
	}
}
