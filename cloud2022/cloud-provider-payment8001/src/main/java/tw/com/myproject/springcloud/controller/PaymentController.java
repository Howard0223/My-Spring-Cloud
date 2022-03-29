package tw.com.myproject.springcloud.controller;

import javax.annotation.Resource;

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
	
	@PostMapping(value = "/payment/create")
	public CommonResult<Payment> create(@RequestBody Payment payment){
		int result = paymentService.create(payment);
		log.info("新增結果：" + result);
		if(result > 0) {
			return new CommonResult<Payment>(200, "新增資料成功", payment);
		}else {
			return new CommonResult<Payment>(400, "新增資料失敗");
		}
	}
	@GetMapping(value = "/payment/get/{id}")
	public CommonResult<Payment> get(@PathVariable("id") Long id){
		Payment payment = paymentService.getPaymentById(id);
		log.info("查詢結果：" + payment);
		if(payment != null) {
			return new CommonResult<Payment>(200, "查詢資料成功", payment);
		}else {
			return new CommonResult<Payment>(400, "搜尋ID：" + id + "，查無資料");
		}
	}
}
