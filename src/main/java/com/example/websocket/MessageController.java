package com.example.websocket;

import java.security.Principal;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import dto.Message;
import dto.ResponseMessage;

@Controller
public class MessageController {
	
	@MessageMapping("/message")
	@SendTo("/topic/messages")
	public ResponseMessage getMessage(final Message message) {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseMessage(HtmlUtils.htmlEscape(message.getMessageContent()));	
	}
	
	@MessageMapping("/private-message")
	@SendToUser("/topic/private-messages")
	public ResponseMessage getPrivateMessage(final Message message, final Principal principal) throws InterruptedException {	
		Thread.sleep(1000);
		return new ResponseMessage(HtmlUtils.htmlEscape( "Sending private message to user " + principal.getName() + " : "+message.getMessageContent()));	
	}

}
