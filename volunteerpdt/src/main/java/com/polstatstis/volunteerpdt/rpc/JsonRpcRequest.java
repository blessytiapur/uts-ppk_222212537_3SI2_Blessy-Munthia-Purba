package com.polstatstis.volunteerpdt.rpc;

/*
 * @author blessy
 */

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonRpcRequest {
    private String jsonrpc;
    private String method;
    private JsonNode params;
    private String id;

    // Menambahkan method untuk mengambil header Authorization
    public String getAuthorizationHeader(String authorization) {
        if (authorization != null && authorization.startsWith("Bearer ")) {
            return authorization.substring(7);  // Mengambil token setelah "Bearer "
        }
        return null; // Mengembalikan null jika tidak ada token
    }
}