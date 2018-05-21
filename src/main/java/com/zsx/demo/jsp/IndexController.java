package com.zsx.demo.jsp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * This is {@link IndexController}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Controller
public class IndexController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "hello";
    }

    @RequestMapping("/foo2")
    public String foo(Map<String, Object> model) {
        throw new RuntimeException("Foo");
    }

}
