package com.yd.chatgpt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: ChatDto
 * @Author: yd
 * @DateTime: 2023/2/21 13:53
 * @Description: 发送消息
 * @Verion: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatDto {
    private String message;
}
