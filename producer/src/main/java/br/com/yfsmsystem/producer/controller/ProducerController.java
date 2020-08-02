package br.com.yfsmsystem.producer.controller;

import br.com.yfsmsystem.producer.dto.Message;
import br.com.yfsmsystem.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerService producerService;

    @PostMapping("/mail")
    public ResponseEntity sendNewEmail(@RequestBody Message message){
        return ResponseEntity.ok(producerService.sendNewMessageService(message));
    }

    @PostMapping("/sms")
    public ResponseEntity sendNemSMS(@RequestBody Message message){
        return ResponseEntity.ok(producerService.sendNewSmsService(message));
    }
}
