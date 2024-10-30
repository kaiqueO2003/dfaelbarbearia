
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
    NotificacaoRepository notificacaoRepository;

    public TwilioService() {
        Twilio.init(accountSid, authToken);
    }

    public void enviarWhatsApp(String toPhoneNumber, String messageContent){

        String toWhatsApp = "whatsapp:" + toPhoneNumber;

        Message message = Message.creator(
                new PhoneNumber(toWhatsApp),
                new PhoneNumber(fromPhoneNumber),
                messageContent
        ).create();

        System.out.println("mensagem enviada ao wpp: " + message.getSid());
    }

}
