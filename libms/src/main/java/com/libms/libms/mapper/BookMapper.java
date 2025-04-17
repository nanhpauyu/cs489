package com.libms.libms.mapper;

import com.libms.libms.dto.request.BookRequestDto;
import com.libms.libms.dto.response.BookResponseDto;
import com.libms.libms.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {PublisherMapper.class})
public interface BookMapper {
    @Mappings(
            {
                    @Mapping(source = "authorRequestDtos", target = "authors"),
                    @Mapping(source = "publisherRequestDto", target = "publisher")
            }
    )
    Book bookRequestDtoToBook(BookRequestDto bookRequestDto);

    @Mappings(
            {
                    @Mapping(target = "authorResponseDtos", source = "authors"),
                    @Mapping(target = "publisherResponseDto", source = "publisher")
            }
    )
    BookResponseDto bookToBookResponseDto(Book book);

    @Mappings(
            {
                    @Mapping(target = "authorResponseDtos", source = "authors"),
                    @Mapping(target = "publisherResponseDtos", source = "publisher")
            }
    )
    List<BookResponseDto> booksToBookResponseDtoList(List<Book> books);
}
