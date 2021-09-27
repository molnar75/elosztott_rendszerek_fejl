package hu.me.iit.osztott.kafkaproducer.impl;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hu.me.iit.osztott.kafkaproducer.MessageDto;

@Service
public class KafkaService implements hu.me.iit.osztott.kafkaproducer.KafkaService {
	
	private final KafkaTemplate<Long, String> kafkaTemplate;
	private final ObjectMapper objectMapper;
	private final String topicName = "chat-rooms";

	public KafkaService(KafkaTemplate<Long, String> kafkaTemplate, ObjectMapper objectMapper) {
		super();
		this.kafkaTemplate = kafkaTemplate;
		this.objectMapper = objectMapper;
	}

	@Override
	public void sendMessage(MessageDto messageDto) throws JsonProcessingException {
		String message = objectMapper.writeValueAsString(messageDto);
		Long key = 0L;
		
		ProducerRecord<Long, String> producerRecord = builProducerRecord(key, message, topicName);
		ListenableFuture<SendResult<Long, String>> resultListenabledFuture = kafkaTemplate.send(producerRecord);
		
		resultListenabledFuture.addCallback(new ListenableFutureCallback<>(){

			@Override
			public void onSuccess(SendResult<Long, String> result) {
				System.out.println(String.format("Success message %s", result.toString()));
				
			}

			@Override
			public void onFailure(Throwable ex) {
				System.out.println(String.format("Failed message %s", ex.toString()));
				
			}
			
		});
		
	}
	
	private ProducerRecord<Long, String> builProducerRecord(Long key, String value, String kafkaTopic) {
		return new ProducerRecord<Long, String>(kafkaTopic, null, key, value, null);
	}
}
