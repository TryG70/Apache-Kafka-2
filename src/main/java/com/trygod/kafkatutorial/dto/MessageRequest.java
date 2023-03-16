package com.trygod.kafkatutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageRequest {

    private String message;

    private String createdAt;
}
