package com.yd.chatgpt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: MessageVo
 * @Author: yd
 * @DateTime: 2023/2/21 16:31
 * @Description: todo
 * @Verion: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageVo {
    private Long code;
    private String msg;
}
