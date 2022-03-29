package tw.com.myproject.springcloud.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tw.com.myproject.springcloud.dao.PaymentDao;
import tw.com.myproject.springcloud.entities.Payment;
import tw.com.myproject.springcloud.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Resource
	private PaymentDao paymentDao;
	
	public int create(Payment payment) {
		return paymentDao.create(payment);
	}
	
	public Payment getPaymentById(Long id) {
		return paymentDao.getPaymentById(id);
	}
}
