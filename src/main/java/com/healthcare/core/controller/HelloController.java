package com.healthcare.core.controller;

import java.security.Timestamp;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.core.dto.UserDto;
import com.healthcare.core.utils.SignUtils;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        Long timestamp = System.currentTimeMillis();
        System.out.println(timestamp);
        String originalSign = "app1-sign1-" + timestamp;
        return SignUtils.signWithHmacSha1("sign1", originalSign);
    }

    @GetMapping("/app/1")
    public String app() {
        return "app";
    }

    @GetMapping("/verify")
    public String verify(@Validated UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // 处理校验失败情况
            System.out.println(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return "200";
    }
}
