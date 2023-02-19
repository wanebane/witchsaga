package com.rivaldy.witchsaga.service;

import com.rivaldy.witchsaga.dto.StoryResponse;
import com.rivaldy.witchsaga.dto.VillagerRequest;

public interface IWitch {

    StoryResponse getStory(VillagerRequest request);
}
