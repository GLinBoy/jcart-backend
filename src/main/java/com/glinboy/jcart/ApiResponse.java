package com.glinboy.jcart;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ApiResponse {
    private Boolean success;
    private String message;
    private Boolean login;
}