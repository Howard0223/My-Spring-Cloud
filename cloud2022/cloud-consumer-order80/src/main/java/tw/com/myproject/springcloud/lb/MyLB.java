package tw.com.myproject.springcloud.lb;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;


public class MyLB implements LoadBalancer{
	
	private AtomicInteger atomicInteger = new AtomicInteger(0);
	
	public final int getAndIncrement() {
		int current;
		int next;
		do {
			current = atomicInteger.get();
			next = current >= Integer.MAX_VALUE ? 0 : current + 1;
		}while(!atomicInteger.compareAndSet(current, next));
		System.out.println("next：\t" + next);
		return next;
	}
	
	@Override
	public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
		int index = getAndIncrement() % serviceInstanceList.size();
		
		return serviceInstanceList.get(index);
	}

}
