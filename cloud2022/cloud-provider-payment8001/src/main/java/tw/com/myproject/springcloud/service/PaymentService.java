package tw.com.myproject.springcloud.service;

import org.apache.ibatis.annotations.Param;

import tw.com.myproject.springcloud.entities.Payment;

public interface PaymentService {
	int create(Payment payment);
	
	Payment getPaymentById(@Param("id") Long id);
}
