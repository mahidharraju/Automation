package com.ngt.controller;

import com.ngt.rest.GADCreationRequest;
import com.ngt.rest.GADCreationResponse;
import com.ngt.rest.NGTCreationRequest;
import com.ngt.rest.NGTCreationResponse;
import com.ngt.service.GADService;
import com.ngt.service.NGTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class DataReadController {


    @Autowired
    GADService gadService;

    @Autowired
    NGTService ngtService;

    @PostMapping(value = "/gad-file")
    public ResponseEntity<GADCreationResponse> processGADData(@RequestBody GADCreationRequest GADCreationRequest)
    {
        log.debug("Stated processing ngt data {}", GADCreationRequest.getFilePath());

        return new ResponseEntity<>(gadService.processNewGADData(GADCreationRequest), HttpStatus.OK);
    }

    @PostMapping(value = "/ngt-file")
    public ResponseEntity<NGTCreationResponse> processNewNGTData(@RequestBody NGTCreationRequest ngtCreationRequest)
    {
        log.debug("Stated processing ngt data {}",ngtCreationRequest.getFilePath());

        return new ResponseEntity<>(ngtService.processNewNGTData(ngtCreationRequest), HttpStatus.OK);
    }
}
