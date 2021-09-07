package com.example.demo.client;

import com.example.demo.model.Example;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@Component
public class CallRestService implements CommandLineRunner {

    private static final String url1 = "https://opentdb.com/api.php?amount=5&category=11";
    private static final String url2 = "https://opentdb.com/api.php?amount=5&category=12";

    public static Example example;
    public static Example example2;

    private static void callRest(){
        RestTemplate restTemplate = new RestTemplate();
         example = restTemplate.getForObject(url1,Example.class);
         example2 = restTemplate.getForObject(url2,Example.class);
        System.out.println(example.getResults());
    }

    @GetMapping("/coding/exercise/quiz")
    public List<Example> getMovies(){
        return List.of(example,example2);
    }

    @Override
    public void run(String... args) throws Exception {
        callRest();
    }
}
