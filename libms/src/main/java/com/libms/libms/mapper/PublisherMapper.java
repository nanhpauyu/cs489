package com.libms.libms.mapper;


import com.libms.libms.dto.request.PublisherRequestDto;
import com.libms.libms.dto.response.PublisherResponseDto;
import com.libms.libms.model.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PublisherMapper {
    //
//    @Mapping(source = "addressRequestDto", target = "address")
//    Publisher publishRequestDtoToPublisher(PublisherRequestDto publisherRequestDto);
//
//    @Mapping(source = "address", target = "addressResponseDto")
//    PublisherResponseDto publisherToPublisherResponseDto(Publisher publisher);
//
//
//    @Mapping(source = "address", target = "addressResponseDto")
//    List<PublisherResponseDto> publisherToPublisherResponseDtos(List<Publisher> publishers);
    @Mapping(source = "addressRequestDto", target = "address")
    Publisher publisherRequestDtoToPublisher(PublisherRequestDto publisherRequestDto);

    //mapper method => map from Publisher to PublisherResponseDto
    @Mapping(source = "address", target = "addressResponseDto")
    PublisherResponseDto publisherToPublisherResponseDto(Publisher publisher);

    //mapping from List<Publisher> to List<PublisherResponseDto
    @Mapping(source = "address", target = "addressResponseDto")
    List<PublisherResponseDto> publishersToPublisherResponseDtoList(List<Publisher> publishers);
}
