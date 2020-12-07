package com.chnu.zno.controller;

import com.chnu.zno.model.Session;
import com.chnu.zno.repository.SessionRepository;
import com.chnu.zno.rest.GenericResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Api(description = "Controller for operations with Sessions")
@RestController
@RequestMapping(value = "/session")
@Transactional
public class SessionController {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionController(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @ApiOperation(value = "Endpoint for getting all Sessions")
    @GetMapping("/")
    public GenericResponse getSessions() {
        return GenericResponse.of(sessionRepository.findAll());
    }

    @ApiOperation(value = "Endpoint for getting Session by ID")
    @GetMapping("/{id}")
    public GenericResponse getSessionById(@PathVariable Integer id) {
        return GenericResponse.of(sessionRepository.findById(id));
    }

    @ApiOperation(value = "Endpoint for adding a new Session")
    @PostMapping("/")
    public GenericResponse addSession(@RequestBody Session session) {
        return GenericResponse.of(sessionRepository.save(session));
    }

    @ApiOperation(value = "Endpoint for deleting a Session by ID")
    @DeleteMapping("/{id}")
    public GenericResponse deleteSessionById(@PathVariable Integer id) {
        sessionRepository.deleteById(id);
        return GenericResponse.empty();
    }
}
