package com.home.moongidevback;

import com.home.moongidevback.util.AwsSesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final AwsSesUtil awsSesUtil;

    @GetMapping("sendMail")
    public String sendMail() {
        Map<String,Object> map = new HashMap<>();
        map.put("data", "본문 내용입니다");

        String to = "moongidev@gmail.com";

        awsSesUtil.send("메시지 테스트", map, to);

        return "통신성공";
    }
}
