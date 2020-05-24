package bts.io.server.home.service.impl;

import bts.io.server.home.dao.MessageRepo;
import bts.io.server.home.model.Message;
import bts.io.server.home.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepo messageRepo;
    @Override
    public void addMessage(Message message) {
        messageRepo.save(message);
    }

    @Override
    public Message getMessageById(Long id) {
        return messageRepo.findById(id)
                .orElse(new Message(0, "ERROR"));
    }

    @Override
    public List<Message> getAllMessage() {
        return (List) messageRepo.findAll();
    }
}
