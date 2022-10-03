package com.example.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.Message;

@RestController
public class WebSocketController {
	
	@Autowired
	private WebSocketService service;

	@PostMapping("/send-message")
	public void sendMessages(@RequestBody final Message message) {
		service.notifyFrontend(message.getMessageContent());
	}
}
