package ru.kpfu.itis.emelyanov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.emelyanov.model.chat.ChatMessage;
import ru.kpfu.itis.emelyanov.service.BuyerService;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final BuyerService buyerService;

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

//    @MessageMapping("/chat.onConnected")
//    @SendTo("/topic/public")
//    public ChatMessage onConnected(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor, Principal principal){
//        headerAccessor.getSessionAttributes().put("username", buyerService.getBuyerByPrincipal(principal).getUsername());
//        return chatMessage;
//    }

//    @GetMapping("/message")
//    public String message(Principal principal,
//                          Model model) {
//        model.addAttribute("buyer", buyerService.getBuyerByPrincipal(principal));
//        return "chat";
//    }
}
