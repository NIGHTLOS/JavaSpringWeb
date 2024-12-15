package com.nightlos.backendexp.vo;

import com.nightlos.backendexp.exception.Code;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO {
    private int code;
    private String message;
    private Object data;

    //对于前端发送的请求回复，常见的成功，失败码
    private static final ResultVO EMPTY= ResultVO.builder()
            .code(200)
            .build();
    public static ResultVO ok() {
        return EMPTY;
    }

    public  static ResultVO success(Object data) {
        return ResultVO.builder().
                code(200)
                .data(data)
                .build();
    }

    public  static ResultVO error(Code code) {
        return ResultVO.builder()
                .code(code.getCode())
                .message(code.getMessage())
                .build();
    }

    public static ResultVO error(int code, String message) {
        return ResultVO.builder()
                .code(code)
                .message(message)
                .build();
    }
}

