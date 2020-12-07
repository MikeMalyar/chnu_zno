package com.chnu.zno.controller;

import com.chnu.zno.dto.EntrantDto;
import com.chnu.zno.model.Entrant;
import com.chnu.zno.model.School;
import com.chnu.zno.model.User;
import com.chnu.zno.repository.EntrantRepository;
import com.chnu.zno.repository.SchoolRepository;
import com.chnu.zno.repository.UserRepository;
import com.chnu.zno.rest.GenericResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Api(description = "Controller for operations with Entrants")
@RestController
@RequestMapping(value = "/entrant")
@Transactional
public class EntrantController {

    private final UserRepository userRepository;
    private final SchoolRepository schoolRepository;
    private final EntrantRepository entrantRepository;

    @Autowired
    public EntrantController(UserRepository userRepository, SchoolRepository schoolRepository,
                             EntrantRepository entrantRepository) {
        this.userRepository = userRepository;
        this.schoolRepository = schoolRepository;
        this.entrantRepository = entrantRepository;
    }

    @ApiOperation(value = "Endpoint for getting all Entrants")
    @GetMapping("/")
    public GenericResponse getEntrants() {
        return GenericResponse.of(entrantRepository.findAll());
    }

    @ApiOperation(value = "Endpoint for getting Entrant by ID")
    @GetMapping("/{id}")
    public GenericResponse getEntrantById(@PathVariable Integer id) {
        return GenericResponse.of(entrantRepository.findById(id));
    }

    @ApiOperation(value = "Endpoint for adding a new Entrant")
    @PostMapping("/")
    public GenericResponse addEntrant(@RequestBody EntrantDto entrantDto) {
        School school = schoolRepository.findById(entrantDto.getSchoolId()).orElse(null);
        User user = userRepository.findById(entrantDto.getUserId()).orElse(null);
        return GenericResponse.of(entrantRepository.save(new Entrant().setName(entrantDto.getName())
                .setSurname(entrantDto.getSurname())
                .setDateOfBirth(entrantDto.getDateOfBirth())
                .setPassport_id(entrantDto.getPassport_id())
                .setUser(user)
                .setSchool(school)
        ));
    }

    @ApiOperation(value = "Endpoint for deleting a Entrant by ID")
    @DeleteMapping("/{id}")
    public GenericResponse deleteEntrantById(@PathVariable Integer id) {
        entrantRepository.deleteById(id);
        return GenericResponse.empty();
    }
}
