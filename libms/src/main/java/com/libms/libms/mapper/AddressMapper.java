package com.libms.libms.mapper;


import com.libms.libms.dto.request.AddressRequestDto;
import com.libms.libms.dto.response.AddressResponseDto;
import com.libms.libms.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {

    // map from addressRequestDto -> address
    Address addressRequestDtoToAddress(AddressRequestDto addressRequestDto);

    // map from address - > addressResponseDto
    AddressResponseDto addressToAddressResponseDto(Address address);
}
