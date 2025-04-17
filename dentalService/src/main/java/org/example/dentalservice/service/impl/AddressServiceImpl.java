package org.example.dentalservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dentalservice.dto.response.AddressPatientResponseDto;
import org.example.dentalservice.dto.response.AddressResponseDto;
import org.example.dentalservice.mapper.AddressMapper;
import org.example.dentalservice.mapper.PatientMapper;
import org.example.dentalservice.model.Address;
import org.example.dentalservice.model.Patient;
import org.example.dentalservice.repository.AddressRespository;
import org.example.dentalservice.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRespository addressRespository;
    private final AddressMapper addressMapper;
    private final PatientMapper patientMapper;

    @Override
    public List<AddressPatientResponseDto> getAddresses() {
        List<Object[]> results = addressRespository.findAllAddressesWithPatients();
        List<AddressPatientResponseDto> addressPatientResponseDtos= new ArrayList<AddressPatientResponseDto>();
        for (Object[] result : results) {
            Address address = (Address) result[0];
            Patient patient = (Patient) result[1];
            addressPatientResponseDtos.add(
                    new AddressPatientResponseDto(
                            addressMapper.addressToAddressResponseDto(address),
                            patientMapper.patientToPatientResponseDto(patient)
                    )
            );

        }
        System.out.println(addressPatientResponseDtos);
        return addressPatientResponseDtos;
    }


//    public List<Address> getAddresses() {
//        List<Object> addresses = addressRespository.findAllAddressesWithPatients();
//        System.out.println(addresses);
////        return addressMapper.addressesToAddressResponseDtos((Address) addresses);
//        return List.of(null);
//    }
}
