package com.panda.rabbitmq.a;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.panda.EureakClientApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EureakClientApplication.class)
public class SenderTest {
    
	 @Autowired 
	 RabbitProductorA rabbitProductorA;
	 
	@Test
	public void mainTest() {
			rabbitProductorA.sendMessage1();
	}
	

}
