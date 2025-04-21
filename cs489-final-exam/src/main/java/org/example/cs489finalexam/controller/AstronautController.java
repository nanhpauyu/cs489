package org.example.cs489finalexam.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.cs489finalexam.dto.request.AstronautRequestDto;
import org.example.cs489finalexam.dto.response.AstronautResponseDto;
import org.example.cs489finalexam.model.Astronaut;
import org.example.cs489finalexam.service.AstronautService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/astronauts")
@RequiredArgsConstructor
public class AstronautController {
    private final AstronautService astronautService;

//    @PostMapping()
//    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
//        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
//    }

    @PostMapping
    public ResponseEntity<AstronautResponseDto> createAstronaut(@RequestBody @Valid AstronautRequestDto astronautRequestDto) {
        AstronautResponseDto astronautResponseDto = astronautService.createAstronaut(astronautRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(astronautResponseDto);
    }

    @GetMapping
    public  ResponseEntity<Page<AstronautResponseDto>> getAstronauts(
            @RequestParam(required = false, defaultValue = "experienceYears") String sort,
            @RequestParam(required = false, defaultValue = "desc") String order,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        Sort.Direction direction = order.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, direction);
        Page<AstronautResponseDto> astronauts = astronautService.getAstronauts(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(astronauts);
    }

}
