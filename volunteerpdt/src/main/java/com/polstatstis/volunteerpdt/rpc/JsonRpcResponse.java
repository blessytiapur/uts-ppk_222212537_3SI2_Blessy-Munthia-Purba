package com.polstatstis.volunteerpdt.rpc;

/*
 * @author blessy
 */

import com.polstatstis.volunteerpdt.dto.VolunteerDto;
import com.polstatstis.volunteerpdt.rpc.JsonRpcError;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class JsonRpcResponse {
    private String jsonrpc;
    private Object result;
    private Object error;
    private String id;

    // Constructor untuk response dengan hasil berupa list
    public JsonRpcResponse(List<VolunteerDto> result, String id) {
        this.jsonrpc = "2.0";
        this.result = result;
        this.id = id;
    }

    // Constructor untuk response dengan hasil berupa string (misalnya error message)
    public JsonRpcResponse(String result, String id) {
        this.jsonrpc = "2.0";
        this.result = result;
        this.id = id;
    }

    // Constructor untuk error response
    public JsonRpcResponse(Object error, String id, int code) {
        this.jsonrpc = "2.0";
        this.error = new JsonRpcError(code, error);
        this.id = id;
    }
}
