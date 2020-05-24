package bts.io.server.home.service;

import bts.io.server.home.model.Message;

import java.util.List;

public interface MessageService {
    void addMessage(Message message);
    Message getMessageById(Long id);
    List<Message> getAllMessage();
}
