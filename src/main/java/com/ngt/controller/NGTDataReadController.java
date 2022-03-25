package com.ngt.controller;

import com.ngt.rest.NGTCreationRequest;
import com.ngt.rest.NGTCreationResponse;
import com.ngt.service.NGTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ngt")
@Slf4j
public class NGTDataReadController {


    @Autowired
    NGTService ngtService;

    @PostMapping(value = "/file")
    public ResponseEntity<NGTCreationResponse> processNewNGTData(@RequestBody NGTCreationRequest ngtCreationRequest)
    {
        log.debug("Stated processing ngt data {}",ngtCreationRequest.getFilePath());

        return new ResponseEntity<>(ngtService.processNewNGTData(ngtCreationRequest), HttpStatus.OK);
    }

    @PutMapping(value = "/file")
    public ResponseEntity<NGTCreationResponse> updateNewNGTData(@RequestBody NGTCreationRequest ngtCreationRequest)
    {
        log.debug("Stated processing ngt data {}",ngtCreationRequest.getFilePath());

        return new ResponseEntity<>(ngtService.updateNGTData(ngtCreationRequest), HttpStatus.OK);
    }
}
