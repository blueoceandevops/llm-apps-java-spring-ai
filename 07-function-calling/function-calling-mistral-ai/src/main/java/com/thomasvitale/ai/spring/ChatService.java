package com.thomasvitale.ai.spring;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
class ChatService {

    private final ChatClient chatClient;

    ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    String getAvailableBooksBy(String authorName) {
        var userPromptTemplate = "What books written by {author} are available to read?";
        return chatClient.prompt()
                .user(userSpec -> userSpec
                        .text(userPromptTemplate)
                        .param("author", authorName)
                )
                .functions("booksByAuthor")
                .call()
                .content();
    }

}
