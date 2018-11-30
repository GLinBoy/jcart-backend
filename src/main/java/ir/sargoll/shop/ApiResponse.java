package ir.sargoll.shop;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ApiResponse {
    private Boolean success;
    private String message;
    private Boolean login;
}