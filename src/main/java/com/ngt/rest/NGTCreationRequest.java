package com.ngt.rest;

import lombok.*;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NGTCreationRequest {

    private String filePath;
}
