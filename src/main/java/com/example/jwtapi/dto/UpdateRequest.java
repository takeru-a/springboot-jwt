package com.example.jwtapi.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UpdateRequest {
    private Long id;
    
    @NotNull(message = "名前は必須です")
    @Size(min = 1, max = 100, message = "名前は1〜100文字で入力してください")
    private String name;
    
    private String description;
    
    @NotNull(message = "数量は必須です")
    private Integer quantity;
}
