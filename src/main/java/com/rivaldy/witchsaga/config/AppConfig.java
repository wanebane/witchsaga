package com.rivaldy.witchsaga.config;

import com.rivaldy.witchsaga.story.AnswerStory;
import com.rivaldy.witchsaga.story.GivenStory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public GivenStory givenStory(){
        return new GivenStory();
    }

    @Bean
    public AnswerStory answerStory(){
        return new AnswerStory();
    }
}
