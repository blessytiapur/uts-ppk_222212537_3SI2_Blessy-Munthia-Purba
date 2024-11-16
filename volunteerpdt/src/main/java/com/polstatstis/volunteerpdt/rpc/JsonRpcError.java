package com.polstatstis.volunteerpdt.rpc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonRpcError {
    private int code;
    private Object message;

    public JsonRpcError(int code, Object message) {
        this.code = code;
        this.message = message;
    }
}
