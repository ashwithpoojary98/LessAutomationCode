package io.github.ashwith.lesscode.api.controller;


import io.github.ashwith.lesscode.api.common.ErrorResponse;
import io.github.ashwith.lesscode.api.dto.SuiteDTO;
import io.github.ashwith.lesscode.application.command.SuiteCommandService;
import io.github.ashwith.lesscode.application.query.SuiteQueryService;
import io.github.ashwith.lesscode.model.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/suite")
public class SuiteController {

    @Autowired
    private SuiteQueryService suiteQueryService;

    @Autowired
    private SuiteCommandService suiteCommandService;

    @GetMapping("/getByID")
    public ResponseEntity<?> getSuite(@RequestParam(name = "id") long id) {
        Suite suiteResponse = suiteQueryService.getSuiteById(id);
       return suiteResponse==null?ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(String.format("suite id %s not found",id), HttpStatus.NOT_FOUND.value())):
                ResponseEntity.ok(suiteResponse);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Suite>> getAllSuite() {
        return ResponseEntity.ok(suiteQueryService.getAllSuite());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSuite(@RequestBody SuiteDTO suiteDTO){
        try {
            SuiteDTO createdSuiteId = suiteCommandService.createSuite(suiteDTO);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdSuiteId)
                    .toUri();
            return ResponseEntity.created(location).body(suiteDTO);
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse("Failed to create suite", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }


}
