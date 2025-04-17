package org.example.dentalservice.service;

import org.example.dentalservice.dto.response.AddressPatientResponseDto;
import org.example.dentalservice.dto.response.AddressResponseDto;

import java.util.List;

public interface AddressService {
    List<AddressPatientResponseDto> getAddresses();
}
