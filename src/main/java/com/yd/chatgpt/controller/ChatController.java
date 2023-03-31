package com.yd.chatgpt.controller;

import com.alibaba.fastjson.JSONObject;
import com.yd.chatgpt.common.Result;
import com.yd.chatgpt.dto.ChatDto;
import com.yd.chatgpt.dto.TextDto;
import com.yd.chatgpt.vo.MessageVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: ChatController
 * @Author: yd
 * @DateTime: 2023/2/21 13:31
 * @Description: todo
 * @Verion: 1.0
 */
@Slf4j
@RestController
public class ChatController {

    @Autowired
    private RestTemplate restTemplate;

    private final static String INVOKE_URL = "https://api.openai.com/v1/completions";

    @PostMapping(value = "/chat")
    public Result chat(@RequestBody ChatDto chatDto){

        log.info("******提问：" + chatDto.getMessage());

        TextDto textDto = new TextDto();
        textDto.setPrompt(chatDto.getMessage());
        textDto.setModel("text-davinci-003");
        textDto.setTemperature(0.9);
        textDto.setMax_tokens(4000L);
        textDto.setTop_p(1L);
        textDto.setFrequency_penalty(0.0);
        textDto.setPresence_penalty(0.6);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization", "Bearer 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");

        HttpEntity<TextDto> request = new HttpEntity<>(textDto, httpHeaders);

        JSONObject jsonObject = restTemplate.postForObject(INVOKE_URL, request, JSONObject.class);
        System.out.println("回答响应：" + jsonObject);
        if(!jsonObject.containsKey("error")){
            return Result.success("正常回答！", jsonObject);
        }else{
            return Result.error("出问题了，请联系管理员！Jack Dong");
        }
    }

    @PostMapping(value = "/test")
    public Object test(@RequestBody ChatDto chatDto){
        System.out.println("sendMessage = " + chatDto.getMessage());
        MessageVo messageVo = new MessageVo();
        messageVo.setCode(200L);
        messageVo.setMsg("你是个好人！");
        return messageVo;
    }
}
