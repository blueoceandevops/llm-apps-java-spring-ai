package com.thomasvitale.ai.spring.model;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.model.Media;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

/**
 * Chat examples using the low-level ChatModel API.
 */
@Service
class ChatModelService {

    private final ChatModel chatModel;

    private final Resource image;

    ChatModelService(ChatModel chatModel, @Value("classpath:tabby-cat.png") Resource image) {
        this.chatModel = chatModel;
        this.image = image;
    }

    String chatFromImageFile(String question) {
        var userMessage = new UserMessage(question, new Media(MimeTypeUtils.IMAGE_PNG, image));
        var prompt = new Prompt(userMessage);
        var chatResponse = chatModel.call(prompt);
        return chatResponse.getResult().getOutput().getContent();
    }

}