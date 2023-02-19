package com.rivaldy.witchsaga.controller;

import com.rivaldy.witchsaga.constant.Message;
import com.rivaldy.witchsaga.dto.ApiResponse;
import com.rivaldy.witchsaga.dto.VillagerRequest;
import com.rivaldy.witchsaga.exception.TotalPersonIsNotMatchException;
import com.rivaldy.witchsaga.service.IWitch;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/witch")
@AllArgsConstructor
public class WitchController {

    private final IWitch witchService;

    @ApiOperation("Get Witch Power")
    @PostMapping
    public ResponseEntity<ApiResponse> getWitchPower(@Valid @RequestBody VillagerRequest request){
        if (request.getTotalPerson()!=request.getPersons().size()){
            throw new TotalPersonIsNotMatchException(
                    String.format(Message.ERR_REA_TOTAL_IS_NOT_MATCH, request.getTotalPerson(), request.getPersons().size())
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true, witchService.getStory(request)));
    }
}
