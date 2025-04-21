package org.example.cs489finalexam.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.cs489finalexam.dto.request.SatelliteRequestDto;
import org.example.cs489finalexam.dto.response.SatelliteResponseDto;
import org.example.cs489finalexam.service.SatelliteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/satellites")
public class SatelliteController {
    private final SatelliteService satelliteService;

    //    @PostMapping()
//    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
//        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
//    }
    @PostMapping()
    public ResponseEntity<SatelliteResponseDto> createSatellite(@RequestBody @Valid SatelliteRequestDto satelliteRequestDto) {
        SatelliteResponseDto responseDto = satelliteService.createSatellite(satelliteRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SatelliteResponseDto> updateSatellite(@RequestBody @Valid SatelliteRequestDto satelliteRequestDto, @PathVariable String id) {
        System.out.println(Long.parseLong(id));
        SatelliteResponseDto satelliteResponseDto = satelliteService.updateSatelliteById(Long.parseLong(id), satelliteRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(satelliteResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<SatelliteResponseDto>> getAllSatellites() {
        return ResponseEntity.status(HttpStatus.OK).body(satelliteService.getAllSatellites());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSatellite(@PathVariable String id) {
        satelliteService.deleteSatelliteById(Long.parseLong(id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
