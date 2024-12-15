package com.nightlos.backendexp.exception;

import com.nightlos.backendexp.exception.Code;
import lombok.*;

@EqualsAndHashCode(callSuper=true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class XException extends RuntimeException {
    private Code code;
    private int number;
    private String message;
}
