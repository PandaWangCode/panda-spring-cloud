package com.panda.rabbitmq;

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
public class SenderMainTest {
    
	 @Autowired 
	 RabbitProductor rabbitProductor;
	 
	@Test
	public void mainTest() {
		for (int i = 0; i < 5; i++) {
			String msgString = " message info " + i +new Date();
			rabbitProductor.sendMessage(msgString);
		}
	}
	

}
