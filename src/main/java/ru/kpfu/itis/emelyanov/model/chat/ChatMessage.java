package ru.kpfu.itis.emelyanov.model.chat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ChatMessage {
    private String content;
    private String sender;
    private MessageType type;
}
