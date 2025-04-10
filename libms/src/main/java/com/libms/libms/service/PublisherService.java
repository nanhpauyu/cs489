package com.libms.libms.service;


import com.libms.libms.dto.request.PublisherRequestDto;
import com.libms.libms.dto.response.PublisherResponseDto;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    Optional<PublisherResponseDto> createPublisher(PublisherRequestDto publisherRequestDto);
    Optional<PublisherResponseDto> findPublisherByName(String name);
    List<PublisherResponseDto> findAllPublishers();
    Optional<PublisherResponseDto> updatePublisher(String name, PublisherRequestDto publisherRequestDto);

    void deletePublisher(String name);

}
