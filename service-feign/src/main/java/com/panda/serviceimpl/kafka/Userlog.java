package com.panda.serviceimpl.kafka;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class Userlog {
	
	private String userName;
	
	private String userId;
	
	private String state;
}
