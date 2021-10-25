package com.example.demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
	
	@MessageMapping("/chat")
	@SendTo("/chat/message")
	public OutGoingChatMessage greeting(IncomingChatMessage message) throws InterruptedException {
		Thread.sleep(1000); //simulate delay
		return new OutGoingChatMessage(message);
	}

}
