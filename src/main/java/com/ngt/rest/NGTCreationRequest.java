package com.ngt.rest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NGTCreationRequest {

    private String filePath;
}
