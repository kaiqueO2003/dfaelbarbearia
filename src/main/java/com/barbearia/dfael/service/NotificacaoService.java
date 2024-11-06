package com.barbearia.dfael.service;


import com.barbearia.dfael.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class NotificacaoService {
    @Autowired
    TwilioService twilioService;
    @Autowired
    NotificacaoRepository notificacaoRepository;

    public void enviarNotificacao(String toPhoneNumber, String messageContent) {
        twilioService.enviarWhatsApp(toPhoneNumber, messageContent);
    }

}
