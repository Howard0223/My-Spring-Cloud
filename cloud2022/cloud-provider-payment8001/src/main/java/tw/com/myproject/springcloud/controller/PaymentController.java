package tw.com.myproject.springcloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tw.com.myproject.springcloud.entities.CommonResult;
import tw.com.myproject.springcloud.entities.Payment;
import tw.com.myproject.springcloud.service.PaymentService;

@RestController
@Slf4j
public class PaymentController {
	@Resource
	private PaymentService paymentService;
	@Resource
	private DiscoveryClient discoveryclient; 
	@Value("${server.port}")
	private String THIS_PORT;
	
	@PostMapping(value = "/payment/create")
	public CommonResult<Payment> create(@RequestBody Payment payment){
		int result = paymentService.create(payment);
		log.info("新增結果：" + result);
		if(result > 0) {
			return new CommonResult<Payment>(200, THIS_PORT + "新增資料成功", payment);
		}else {
			return new CommonResult<Payment>(400, THIS_PORT + "新增資料失敗");
		}
	}
	@GetMapping(value = "/payment/get/{id}")
	public CommonResult<Payment> get(@PathVariable("id") Long id){
		Payment payment = paymentService.getPaymentById(id);
		log.info("查詢結果：" + payment);
		if(payment != null) {
			return new CommonResult<Payment>(200, THIS_PORT + "查詢資料成功", payment);
		}else {
			return new CommonResult<Payment>(400, THIS_PORT + "搜尋ID：" + id + "，查無資料");
		}
	}
	@GetMapping(value = "/payment/discovery")
	public Object discovery() {
		List<String> services = discoveryclient.getServices();
		for(String service : services) {
			log.info("*********" + service);
		}
		List<ServiceInstance> instances = discoveryclient.getInstances("cloud-payment-service");
		for(ServiceInstance instance : instances) {
			log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
		}
		return this.discoveryclient;
	}
}
