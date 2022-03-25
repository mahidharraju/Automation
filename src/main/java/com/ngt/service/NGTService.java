package com.ngt.service;

import com.ngt.rest.NGTCreationRequest;
import com.ngt.rest.NGTCreationResponse;

public interface NGTService {

    public NGTCreationResponse  processNewNGTData(NGTCreationRequest ngtCreationRequest);

    public NGTCreationResponse updateNGTData(NGTCreationRequest ngtCreationRequest);
}
