package tw.com.myproject.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
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
	
	@GetMapping(value = "/consumer/payment/getForEntity/{id}")
    public CommonResult get2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/get/" + id, CommonResult.class);
        System.out.println("status code=" + entity.getStatusCode());
        System.out.println("headers=" + entity.getHeaders());
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult(404, "查找失败");
        }
    }
}
