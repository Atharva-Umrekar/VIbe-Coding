package com.example.hospital.service;

import com.example.hospital.model.PromptOutput;
import com.example.hospital.repository.PromptOutputRepository;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PromptService {

    private final PromptOutputRepository outputRepository;
    private final OpenAiChatModel chatModel;

    public PromptService(PromptOutputRepository outputRepository,
                         @Value("${spring.ai.openai.api-key}") String openAiApiKey) {
        this.outputRepository = outputRepository;
        this.chatModel = OpenAiChatModel.builder()
                .apiKey(openAiApiKey)
                .build();
    }

    public String processPrompt(String prompt) {
        String output = chatModel.generate(prompt);
        PromptOutput promptOutput = new PromptOutput(prompt, output);
        outputRepository.save(promptOutput);
        return output;
    }

    public PromptOutput getLatestOutputForPrompt(String prompt) {
        return outputRepository.findFirstByPromptOrderByCreatedAtDesc(prompt);
    }
}




















