package com.ngt.service;

import com.ngt.rest.GADCreationRequest;
import com.ngt.rest.GADCreationResponse;

public interface GADService {

    public GADCreationResponse processNewGADData(GADCreationRequest GADCreationRequest);


}
