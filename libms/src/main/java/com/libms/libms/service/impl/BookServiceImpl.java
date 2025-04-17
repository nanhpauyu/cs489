package com.libms.libms.service.impl;

import com.libms.libms.dto.request.BookRequestDto;
import com.libms.libms.dto.response.BookResponseDto;
import com.libms.libms.mapper.BookMapper;
import com.libms.libms.model.Author;
import com.libms.libms.model.Book;
import com.libms.libms.model.Publisher;
import com.libms.libms.repository.AuthorRepository;
import com.libms.libms.repository.BookRepository;
import com.libms.libms.repository.PublisherRepository;
import com.libms.libms.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    @Override
    @Transactional
    public Optional<BookResponseDto> createBook(BookRequestDto bookRequestDto) {
        Optional<Book> optionalBook = bookRepository.findByIsbn(bookRequestDto.isbn());
        if (optionalBook.isPresent()) {
            return Optional.empty();
        }
        Book mappedBook = bookMapper.bookRequestDtoToBook(bookRequestDto);

        if (mappedBook.getPublisher() != null) {
            Optional<Publisher> optionalPublisher = publisherRepository.findByName(mappedBook.getPublisher().getName());
            if (optionalPublisher.isPresent()) {
                Publisher publisher = optionalPublisher.get();
                mappedBook.getPublisher().setId(publisher.getId());
            }
        }
        List<Author> resolvedAuthors = new ArrayList<>();
        mappedBook.getAuthors().forEach(author -> {
            Optional<Author> optionalAuthor = authorRepository.findByFirstNameAndLastName(author.getFirstName(), author.getLastName());
            if (optionalAuthor.isPresent()) {
                resolvedAuthors.add(optionalAuthor.get());
            }else {
                resolvedAuthors.add(author);
            }

        });
        mappedBook.setAuthors(resolvedAuthors);

        Book savedBook = bookRepository.save(mappedBook);
        return Optional.of(bookMapper.bookToBookResponseDto(savedBook));
    }

    @Override
    public Optional<BookResponseDto> updateBook(String isbn, BookRequestDto bookRequestDto) {
        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);
        if (optionalBook.isPresent()) {
            Book foundBook = optionalBook.get();
        }
        return Optional.empty();
    }

    @Override
    public Optional<BookResponseDto> findByIsbn(String isbn) {
        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);
        return optionalBook.map(bookMapper::bookToBookResponseDto);
    }

    @Override
    public Optional<BookResponseDto> deleteBookByIsbn(String isbn) {
        return Optional.empty();
    }

    @Override
    public List<BookResponseDto> findAllBooks() {
        return List.of();
    }
}
