package com.customer.repository;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.customer.dto.Customer;

//4.11 버전부터 메소드 순서 지정 가능 
//4.12 버전부터 @RunWith 사용가능
//maven에서 4.12로 변경바란다.

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="customer-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerRepositoryTest {
	
	@Autowired
	CustomerRepository customerRepository;
		
	@Test 
	public void test01(){ //insert()
		Customer  customer = new Customer();
		
		customer.setId("hong");
		customer.setName("홍길동");
		customer.setPassword("12345789");
		customer.setPostcode("12345");
		customer.setAddress("서울 동작구 흑석동");
		customer.setAddress2("250-1");
		customer.setPhone("0100000000");
		customer.setEmail("hong@naver.com");
		
		assertEquals(1, customerRepository.insert(customer));	
	}
		
	@Test 
	public void test02(){  //selectAll()
		assertEquals(3, customerRepository.selectAll().size());	
	}

	@Test 
	public void test03(){	//delete() 
		assertEquals(1, customerRepository.delete(4));	
	}

	@Test 
	public void test04(){  //selectAll()
		assertEquals(3, customerRepository.selectAll().size());	
	}
}
