package com.barbearia.dfael.service;

import com.barbearia.dfael.repository.NotificacaoRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {


    @Autowired
    NotificacaoRepository noficacaoRepository;


    public TwilioService(){
        Twilio.init(accountSid, authToken);
    }

    public void sendWhatsMensage(String toPhoneNumber, String messageContent){
        Message message = Message.creator(
                new PhoneNumber("whatsapp" + toPhoneNumber),
                new PhoneNumber("whatsapp" + fromPhoneNumber),
                messageContent
        ).create();
        System.out.println("mensagem envidada ao wpp:"+message.getSid());
    }
    public void sendSMS(String toPhoneNumber, String messageContent) {
        Message message = Message.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(fromPhoneNumber),
                messageContent
        ).create();
        System.out.println("mensagem envidada via sms:" + message.getSid());
    }
}
