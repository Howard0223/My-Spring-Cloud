package tw.com.myproject.springcloud.service;

import org.apache.ibatis.annotations.Param;

import tw.com.myproject.springcloud.entities.Payment;

public interface PaymentService {
	public int create(Payment payment);
	
	public Payment getPaymentById(@Param("id") Long id);
}
