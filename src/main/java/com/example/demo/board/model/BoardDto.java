package com.example.demo.board.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardDto {
    private Long idx;
    private String title;
    private String content;
}