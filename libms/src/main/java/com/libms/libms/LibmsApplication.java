package com.libms.libms;

import com.libms.libms.dto.request.AddressRequestDto;
import com.libms.libms.dto.request.PublisherRequestDto;
import com.libms.libms.service.BookService;
import com.libms.libms.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class LibmsApplication {
    private final PublisherService publisherService;
    private final BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(LibmsApplication.class, args);


    }
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            // New Publisher
            PublisherRequestDto publisherRequestDto = new PublisherRequestDto(
                    "Apress",
                    new AddressRequestDto(
                            "1A",
                            "LLC One New York Plaza",
                            "New York",
                            "NY",
                            "1562"
                    )
            );
            System.out.println(publisherService.createPublisher(publisherRequestDto));

        };
    }

}
