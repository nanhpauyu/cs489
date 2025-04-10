package com.libms.libms;

import com.libms.libms.dto.request.AddressRequestDto;
import com.libms.libms.dto.request.PublisherRequestDto;
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

    public static void main(String[] args) {
        SpringApplication.run(LibmsApplication.class, args);


    }
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
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
//            System.out.println(publisherService.findAllPublishers());
            System.out.println("hello");
            System.out.println(publisherService.findPublisherByName("Apress"));
            PublisherRequestDto publisherRequestDto1 = new PublisherRequestDto(
                    "Npress",
                    new AddressRequestDto(
                            "11A",
                            "LLC One New York Plaza",
                            "New York",
                            "NY",
                            "1562"
                    )
            );
            System.out.println(publisherService.updatePublisher("Apress",publisherRequestDto1));
//            publisherService.deletePublisher("Npress");
        };
    }

}
