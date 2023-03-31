package com.yd.chatgpt.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Result
 * @Author: yd
 * @DateTime: 2023/2/22 11:42
 * @Description: todo
 * @Verion: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private Long code;
    private String msg;
    private Object data;


    public static Result success(String msg, Object data){
        return new Result(200L, msg, data);
    }

    public static Result error(String msg){
        return new Result(500L, msg, null);
    }

}
