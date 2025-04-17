package org.example.dentalservice.mapper;

import org.example.dentalservice.dto.request.AddressRequestDto;
import org.example.dentalservice.dto.response.AddressResponseDto;
import org.example.dentalservice.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {

    Address addressRequestDtoToAddress(AddressRequestDto addressRequestDto);


    AddressResponseDto addressToAddressResponseDto(Address address);

    List<AddressResponseDto> addressesToAddressResponseDtos(List<Address> addresses);
}
