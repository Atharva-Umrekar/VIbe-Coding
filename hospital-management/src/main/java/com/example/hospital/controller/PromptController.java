package com.example.hospital.controller;

import com.example.hospital.model.PromptOutput;
import com.example.hospital.service.PromptService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class PromptController {

    private final PromptService promptService;

    public PromptController(PromptService promptService) {
        this.promptService = promptService;
    }

    @PostMapping("/query")
    public String handlePrompt(@RequestBody String prompt) {
        return promptService.processPrompt(prompt);
    }

    @GetMapping("/output")
    public PromptOutput getLatestOutput(@RequestParam String prompt) {
        return promptService.getLatestOutputForPrompt(prompt);
    }
}
