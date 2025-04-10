package com.libms.libms.service.impl;

import com.libms.libms.dto.request.PublisherRequestDto;
import com.libms.libms.dto.response.PublisherResponseDto;
import com.libms.libms.mapper.PublisherMapper;
import com.libms.libms.model.Publisher;
import com.libms.libms.repository.PublisherRepository;
import com.libms.libms.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;


    @Override
    public Optional<PublisherResponseDto> createPublisher(PublisherRequestDto publisherRequestDto) {
        //From publisherRequestDto, construct Publisher
        Publisher publisher = publisherMapper.publisherRequestDtoToPublisher(publisherRequestDto);
        Publisher savedPublisher = publisherRepository.save(publisher);
        //Map Publisher to PublisherResponseDto
        PublisherResponseDto publisherResponseDto = publisherMapper.publisherToPublisherResponseDto(savedPublisher);
        return Optional.ofNullable(publisherResponseDto);
    }

    @Override
    public Optional<PublisherResponseDto> findPublisherByName(String name) {
        Optional<Publisher> optionalPublisher = publisherRepository.findByName(name);
        if (optionalPublisher.isPresent()) {
            return Optional.ofNullable(publisherMapper.publisherToPublisherResponseDto(optionalPublisher.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<PublisherResponseDto> findAllPublishers() {
        List<Publisher> publishers = publisherRepository.findAll();
        List<PublisherResponseDto> publisherResponseDtoList = publisherMapper.publishersToPublisherResponseDtoList(publishers);
        return publisherResponseDtoList;
    }

    @Override
    public Optional<PublisherResponseDto> updatePublisher(String name, PublisherRequestDto publisherRequestDto) {
        Publisher publisher = publisherRepository.findByName(name).get();
        Publisher mappedPublisher = publisherMapper.publisherRequestDtoToPublisher(publisherRequestDto);
        mappedPublisher.setId(publisher.getId());
        if (mappedPublisher.getAddress() != null) {
            mappedPublisher.getAddress().setId(publisher.getAddress().getId());
        }
        Publisher updatedPublisher = publisherRepository.save(mappedPublisher);
        return Optional.ofNullable(publisherMapper.publisherToPublisherResponseDto(updatedPublisher));
    }

    @Override
    public void deletePublisher(String name) {
        publisherRepository.findByName(name).ifPresent(publisherRepository::delete);

    }
//        publisher.setName(publisherRequestDto.name());
//        publisher.setAddress(
//                new Address(
//                        publisherRequestDto.addressRequestDto().unitNo(),
//                        publisherRequestDto.addressRequestDto().street(),
//                        publisherRequestDto.addressRequestDto().city(),
//                        publisherRequestDto.addressRequestDto().state(),
//                        publisherRequestDto.addressRequestDto().zip()
//                )
//        );
//        Publisher updatedPublisher = publisherRepository.save(publisher);
//        PublisherResponseDto publisherResponseDto = new PublisherResponseDto(
//                publisher.getId(),
//                publisher.getName(),
//                new AddressResponseDto(
//                        publisher.getAddress().getId(),
//                        publisher.getAddress().getUnitNo(),
//                        publisher.getAddress().getStreet(),
//                        publisher.getAddress().getCity(),
//                        publisher.getAddress().getState(),
//                        publisher.getAddress().getZip()
//                )
//        );
//        return Optional.ofNullable(publisherResponseDto)


//    @Override
//    public Optional<PublisherResponseDto> createPublisher(PublisherRequestDto publisherRequestDto) {
//        Publisher publisher = publisherMapper.publishRequestDtoToPublisher(publisherRequestDto);
////        Publisher publisher = new Publisher(
////                publisherRequestDto.name()
////        );
////        AddressRequestDto addressRequestDto = publisherRequestDto.addressRequestDto();
////        publisher.setAddress(new Address(
////                addressRequestDto.unitNo(),
////                addressRequestDto.street(),
////                addressRequestDto.city(),
////                addressRequestDto.state(),
////                addressRequestDto.zip()
////        ));
//        Publisher savePublisher = publisherRepository.save(publisher);
//        PublisherResponseDto publisherResponseDto = publisherMapper.publisherToPublisherResponseDto(savePublisher);
////        PublisherResponseDto publisherResponseDto = new PublisherResponseDto(
////                publisher.getId(),
////                publisher.getName(),
////                new AddressResponseDto(
////                        publisher.getAddress().getId(),
////                        publisher.getAddress().getUnitNo(),
////                        publisher.getAddress().getStreet(),
////                        publisher.getAddress().getCity(),
////                        publisher.getAddress().getState(),
////                        publisher.getAddress().getZip()
////                )
////        );
//        return Optional.ofNullable(publisherResponseDto);
//    }
//
//    @Override
//    public Optional<PublisherResponseDto> findPublisherByName(String name) {
//        Optional<Publisher> optionalPublisher = publisherRepository.findByName(name);
//        if (optionalPublisher.isPresent()){
//            return Optional.ofNullable(publisherMapper.publisherToPublisherResponseDto(optionalPublisher.get()));
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<List<PublisherResponseDto>> findAllPublishers() {
//        List<Publisher> publishers = publisherRepository.findAll();
//        List<PublisherResponseDto> publisherResponseDtos = publisherMapper.publisherToPublisherResponseDtos(publishers);
//        return Optional.ofNullable(publisherResponseDtos);
//    }
//
//    @Override
//    public Optional<PublisherResponseDto> updatePublisher(String name, PublisherRequestDto publisherRequestDto) {
//        return Optional.empty();
//    }
}
