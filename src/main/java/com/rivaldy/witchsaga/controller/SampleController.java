package com.rivaldy.witchsaga.controller;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/sample")
public class SampleController {

    private final Bucket bucket;
    private final String fmtDate = "yyyy-MM-dd HH:mm:ss";

    public SampleController(){
        Refill refill = Refill.greedy(1, Duration.ofMinutes(1));
        Bandwidth bandwidth = Bandwidth.classic(1, refill);
        this.bucket = Bucket.builder().addLimit(bandwidth).build();
    }

    @GetMapping
    public String getMessageSample() throws InterruptedException {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern(fmtDate));
        Thread.sleep(10_000L);
        return bucket.tryConsume(1) ? "Test Berhasil => " + date : "Test Gagal => " + date;
    }

    @PostMapping
    @ResponseBody
    public String logoutAccount(@RequestBody String username){
        return "sample";
    }
}
