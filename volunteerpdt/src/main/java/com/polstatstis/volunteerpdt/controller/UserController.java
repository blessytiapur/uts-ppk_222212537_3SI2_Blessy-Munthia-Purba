package com.polstatstis.volunteerpdt.controller;

/*
 * @author blessy
 */

import com.fasterxml.jackson.databind.JsonNode;
import com.polstatstis.volunteerpdt.dto.UserDto;
import com.polstatstis.volunteerpdt.rpc.JsonRpcResponse;
import com.polstatstis.volunteerpdt.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(
            summary = "Update user",
            description = "Updates the details of an existing user.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully updated the user",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(example = """
                                    {
                                      "jsonrpc": "2.0",
                                      "result": "user updated",
                                      "id": "request-12345"
                                    }
                                    """)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid user parameters",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(example = """
                                    {
                                      "jsonrpc": "2.0",
                                      "error": {
                                        "code": -32602,
                                        "message": "Invalid parameters"
                                      },
                                      "id": "request-12345"
                                    }
                                    """)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(example = """
                                    {
                                      "jsonrpc": "2.0",
                                      "error": {
                                        "code": -32603,
                                        "message": "Internal server error"
                                      },
                                      "id": "request-12345"
                                    }
                                    """)
                            )
                    )
            }
    )
    @PutMapping("/update")
    public ResponseEntity<Object> handleUpdateUser(
            @RequestBody @Schema(example = """
            {
              "nim": "222212537",
              "email": "blessymunthia@gmail.com",
              "role": "Pengurus PDT",
              "nama": "Blessy Munthia",
              "status": "Aktif",
              "kelas": "3SI2",
              "angkatan": "64",
              "usia": 21
            }
            """) JsonNode params,
            @RequestParam @Schema(example = "request-12345") String requestId) {
        String nim = params.get("nim").asText();
        String email = params.has("email") ? params.get("email").asText() : null;
        String role = params.has("role") ? params.get("role").asText() : null;
        String nama = params.has("nama") ? params.get("nama").asText() : null;
        String status = params.has("status") ? params.get("status").asText() : null;
        String kelas = params.has("kelas") ? params.get("kelas").asText() : null;
        String angkatan = params.has("angkatan") ? params.get("angkatan").asText() : null;
        int usia = params.has("usia") ? params.get("usia").asInt() : 0;

        UserDto user = UserDto.builder()
                .nim(nim)
                .email(email)
                .role(role)
                .nama(nama)
                .status(status)
                .kelas(kelas)
                .angkatan(angkatan)
                .usia(usia)
                .build();

        userService.updateUser(nim, user);

        return ResponseEntity.ok(new JsonRpcResponse("user updated", requestId));
    }

    @Operation(
            summary = "Delete user",
            description = "Deletes an existing user based on the provided username.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully deleted the user",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(example = """
                                    {
                                      "jsonrpc": "2.0",
                                      "result": "user deleted",
                                      "id": "request-67890"
                                    }
                                    """)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid username provided",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(example = """
                                    {
                                      "jsonrpc": "2.0",
                                      "error": {
                                        "code": -32602,
                                        "message": "Invalid parameters"
                                      },
                                      "id": "request-67890"
                                    }
                                    """)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(example = """
                                    {
                                      "jsonrpc": "2.0",
                                      "error": {
                                        "code": -32603,
                                        "message": "Internal server error"
                                      },
                                      "id": "request-67890"
                                    }
                                    """)
                            )
                    )
            }
    )
    @DeleteMapping("/delete")
    public ResponseEntity<Object> handleDeleteUser(
            @RequestBody @Schema(example = """
            {
              "username": "blessy_munthia"
            }
            """) JsonNode params,
            @RequestParam @Schema(example = "request-67890") String requestId) {
        String username = params.get("username").asText();
        userService.deleteUser(username);
        return ResponseEntity.ok(new JsonRpcResponse("user deleted", requestId));
    }
}
