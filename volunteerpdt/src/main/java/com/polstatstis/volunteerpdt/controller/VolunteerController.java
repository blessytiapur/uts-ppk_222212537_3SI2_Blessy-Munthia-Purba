package com.polstatstis.volunteerpdt.controller;

/*
 * @author blessy
 */

import com.fasterxml.jackson.databind.JsonNode;
import com.polstatstis.volunteerpdt.dto.VolunteerDto;
import com.polstatstis.volunteerpdt.rpc.JsonRpcResponse;
import com.polstatstis.volunteerpdt.service.VolunteerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteers")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @Operation(
            summary = "Create a new volunteer",
            description = "Creates a new volunteer with provided parameters",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Volunteer created successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(example = """
                                    {
                                      "jsonrpc": "2.0",
                                      "result": "created",
                                      "id": "request-12345"
                                    }
                                    """)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request data",
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
                    )
            }
    )
    @PostMapping("/create")
    public ResponseEntity<Object> handleCreateVolunteer(
            @RequestBody @Schema(example = "{\"nim\":\"222212537\", \"nama\":\"Blessy Munthia\", \"status\":\"Aktif\"}") JsonNode params,
            @RequestParam @Schema(example = "request-12345") String requestId) {
        String nim = params.get("nim").asText();
        String nama = params.get("nama").asText();
        String status = params.get("status").asText();
        VolunteerDto volunteer = VolunteerDto.builder()
                .nim(nim)
                .nama(nama)
                .status(status)
                .build();
        volunteerService.createVolunteer(volunteer);
        return ResponseEntity.ok(new JsonRpcResponse("created", requestId));
    }

    @Operation(
            summary = "Update an existing volunteer",
            description = "Updates an existing volunteer's details",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Volunteer updated successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(example = """
                                    {
                                      "jsonrpc": "2.0",
                                      "result": "updated",
                                      "id": "request-67890"
                                    }
                                    """)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request data",
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
                    )
            }
    )
    @PutMapping("/update")
    public ResponseEntity<Object> handleUpdateVolunteer(
            @RequestBody @Schema(example = "{\"nim\":\"222212537\", \"nama\":\"Updated Name\", \"status\":\"Inactive\"}") JsonNode params,
            @RequestParam @Schema(example = "request-67890") String requestId) {
        String nim = params.get("nim").asText();
        String nama = params.has("nama") ? params.get("nama").asText() : null;
        String status = params.has("status") ? params.get("status").asText() : null;
        VolunteerDto volunteer = VolunteerDto.builder()
                .nim(nim)
                .nama(nama)
                .status(status)
                .build();
        volunteerService.updateVolunteer(volunteer);
        return ResponseEntity.ok(new JsonRpcResponse("updated", requestId));
    }

    @Operation(
            summary = "Delete Volunteer by Nim",
            description = "Deletes a volunteer based on the provided Nim.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Volunteer deleted successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(example = """
                                    {
                                      "jsonrpc": "2.0",
                                      "result": "deleted",
                                      "id": "request-11223"
                                    }
                                    """)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request data",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(example = """
                                    {
                                      "jsonrpc": "2.0",
                                      "error": {
                                        "code": -32602,
                                        "message": "Invalid parameters"
                                      },
                                      "id": "request-11223"
                                    }
                                    """)
                            )
                    )
            }
    )
    @DeleteMapping("/delete")
    public ResponseEntity<Object> handleDeleteVolunteer(
            @RequestBody @Schema(example = "{\"nim\":\"222212537\"}") JsonNode params,
            @RequestParam @Schema(example = "request-11223") String requestId) {
        String nim = params.get("nim").asText();
        volunteerService.deleteVolunteer(nim);
        return ResponseEntity.ok(new JsonRpcResponse("deleted", requestId));
    }

    @Operation(
            summary = "Get all volunteers",
            description = "Retrieves a list of all volunteers.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved the list of volunteers",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(example = """
                                    {
                                      "jsonrpc": "2.0",
                                      "result": [
                                        {
                                          "nim": "222212537",
                                          "nama": "Blessy Munthia",
                                          "status": "Aktif"
                                        },
                                        {
                                          "nim": "222212538",
                                          "nama": "John Doe",
                                          "status": "Inactive"
                                        }
                                      ],
                                      "id": "request-33445"
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
                                      "id": "request-33445"
                                    }
                                    """)
                            )
                    )
            }
    )
    @GetMapping("/all")
    public ResponseEntity<Object> handleGetVolunteers(
            @RequestParam @Schema(example = "request-33445") String requestId) {
        List<VolunteerDto> volunteers = volunteerService.getVolunteers();
        return ResponseEntity.ok(new JsonRpcResponse(String.valueOf(volunteers), requestId));
    }

    @Operation(
            summary = "Search volunteers",
            description = "Searches for volunteers based on a search term.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved search results",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(example = """
                                    {
                                      "jsonrpc": "2.0",
                                      "result": [
                                        {
                                          "nim": "222212537",
                                          "nama": "Blessy Munthia",
                                          "status": "Aktif"
                                        }
                                      ],
                                      "id": "request-55667"
                                    }
                                    """)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid search parameters",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(example = """
                                    {
                                      "jsonrpc": "2.0",
                                      "error": {
                                        "code": -32602,
                                        "message": "Invalid parameters"
                                      },
                                      "id": "request-55667"
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
                                      "id": "request-55667"
                                    }
                                    """)
                            )
                    )
            }
    )
    @PostMapping("/search")
    public ResponseEntity<Object> handleSearchVolunteers(
            @RequestBody @Schema(example = "{\"search term\":\"Blessy\"}") JsonNode params,
            @RequestParam @Schema(example = "request-55667") String requestId) {
        String searchTerm = params.get("search term").asText();
        List<VolunteerDto> searchResults = volunteerService.searchVolunteers(searchTerm);
        return ResponseEntity.ok(new JsonRpcResponse(String.valueOf(searchResults), requestId));
    }
}

