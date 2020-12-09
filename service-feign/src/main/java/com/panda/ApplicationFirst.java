package com.panda;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ApplicationFirst implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("spring boot 开始启动，初始化代码执行！");
	}

}
