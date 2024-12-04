package com.ced.model;

import lombok.Data;

@Data
public class MessageRequest {
    public String to;
    public String subject;
    public String message;
    public String channel;
}