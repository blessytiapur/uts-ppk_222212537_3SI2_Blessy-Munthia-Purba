package com.polstatstis.volunteerpdt.controller;

/*
 * @author blessy
 */

import com.fasterxml.jackson.databind.JsonNode;
import com.polstatstis.volunteerpdt.auth.JwtUtil;
import com.polstatstis.volunteerpdt.dto.UserDto;
import com.polstatstis.volunteerpdt.dto.VolunteerDto;
import com.polstatstis.volunteerpdt.rpc.JsonRpcRequest;
import com.polstatstis.volunteerpdt.rpc.JsonRpcResponse;
import com.polstatstis.volunteerpdt.service.UserService;
import com.polstatstis.volunteerpdt.service.VolunteerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JsonRpcController {
    @Autowired
    private VolunteerService volunteerService;

    @Autowired
    private UserService userService;
    private Object Bearer;
    private JwtUtil jwtUtil;

    @Operation(
            summary = "Menghandle JSON-RPC",
            description = "Endpoint to handle JSON-RPC requests for book operations. Supports methods: createVolunteer, getVolunteer, searchVolunteer.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request invalid JSON-RPC request",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )

    @PostMapping("/jsonrpc")
    public ResponseEntity<Object> handleJsonRpcRequest(@RequestBody JsonRpcRequest request,
                                                       HttpServletRequest servletRequest) {
        try {
            String method = request.getMethod();
            JsonNode params = request.getParams();

//            // Mengambil header Authorization
//            String requestURI = servletRequest.getRequestURI();
//            if (requestURI.startsWith("/swagger-ui/") || requestURI.startsWith("/api-docs/")
//                    || requestURI.startsWith("/swagger-resources") || requestURI.startsWith("/webjars")
//                    || requestURI.startsWith("/register") || requestURI.startsWith("/login")) {
//                return ResponseEntity.ok("Swagger endpoint - no authentication required");
//            }
//
//            String authHeader = request.getAuthorizationHeader("Authorization");
//            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//                return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body("No Bearer token found");
//            }

//            String token = authHeader.substring(7); // Mengambil token dari header
//            if (!jwtUtil.validateAccessToken(token)) {
//                return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body("Invalid token");
//            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return null;
    }
}


