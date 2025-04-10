package com.libms.libms.service;

import com.libms.libms.dto.request.BookRequestDto;
import com.libms.libms.dto.response.BookResponseDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    //Create
    Optional<BookResponseDto> createBook(BookRequestDto bookRequestDto);
    //Update
    Optional<BookResponseDto> updateBook(String isbn, BookRequestDto bookRequestDto);
    //Find by isbn
    Optional<BookResponseDto> findByIsbn(String isbn);
    //Delete by isbn
    Optional<BookResponseDto> deleteBookByIsbn(String isbn);
    //Find all
    List<BookResponseDto> findAllBooks();
}
