package com.example.demo;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Praveen J U
 * @Date 04/12/25
 */
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TestController {
    private final DemoRepository demoRepository;

    @GetMapping
    public String rootPath(){
        return "SUCCESS";
    }

    @GetMapping("/test")
    public List<Demo> getDemo(){
        Demo demo = new Demo();
        demo.setName("new name");
        demoRepository.save(demo);
        return demoRepository.findAll();
    }
}
