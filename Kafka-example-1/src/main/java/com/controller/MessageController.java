package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

	@Autowired
	private KafkaProducer kp;
	

	
	public MessageController(KafkaProducer kp) {
		super();
		this.kp = kp;
	}



	@GetMapping("/publish")
	public ResponseEntity<String> sentMsg(@RequestParam("msg")String msg){
		kp.sendMsg(msg);
		
		return ResponseEntity.ok("Message sent to Topics");
	}
	

}
