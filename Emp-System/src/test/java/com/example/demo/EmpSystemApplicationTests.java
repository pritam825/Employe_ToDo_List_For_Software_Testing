package com.example.demo;

import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.when;


import java.util.stream.Stream;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Test;

import com.example.demo.repository.EmpRepo;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmpService;



@SpringBootTest
class EmpSystemApplicationTests {

	
	void contextLoads() {
	}
	@Autowired
	private EmpService Service;
	
	@MockBean
	private EmpRepo repository;
	
	@Test
	public void getUserTest() {
		when(repository.findAll()).thenReturn(Stream.of(new Employee(4,"pritam","a@g","673","1000000000",45)).collect(Collectors.toList()));
		Assertions.assertEquals(1,Service.getAllEmp().size());
	}
	

}
