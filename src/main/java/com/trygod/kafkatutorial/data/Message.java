package com.trygod.kafkatutorial.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Message {

    private String message;

    private LocalDateTime createdAt;

}
