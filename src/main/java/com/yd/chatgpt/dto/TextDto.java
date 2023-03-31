package com.yd.chatgpt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: TextDto
 * @Author: yd
 * @DateTime: 2023/2/21 13:43
 * @Description: todo
 * @Verion: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextDto {

    private String prompt;
    private String model;
    private Double temperature;
    private Long max_tokens;
    private Long top_p;
    private Double frequency_penalty;
    private Double presence_penalty;

}
