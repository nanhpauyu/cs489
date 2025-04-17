package org.example.dentalservice;

import lombok.RequiredArgsConstructor;
import org.example.dentalservice.dto.request.*;
import org.example.dentalservice.dto.response.PatientResponseDto;
import org.example.dentalservice.model.Dentist;
import org.example.dentalservice.model.Patient;
import org.example.dentalservice.service.AppointmentService;
import org.example.dentalservice.service.DentistService;
import org.example.dentalservice.service.PatientService;
import org.example.dentalservice.service.SurgeryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;

@SpringBootApplication
@RequiredArgsConstructor
public class DentalServiceApplication {

    private final PatientService patientService;
    private final DentistService dentistService;
    private final SurgeryService surgeryService;
    private final AppointmentService appointmentService;

    public static void main(String[] args) {
        SpringApplication.run(DentalServiceApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner() {
//        return args -> {
//
//            //Create Patient
//            PatientRequestDto patientRequestDto = new PatientRequestDto(
//                    "Nan",
//                    new AddressRequestDto(
//                            "1000 N4",
//                            "Fairfield",
//                            "Iowa",
//                            "52557"
//                    )
//            );
//            System.out.println(patientService.createPatient(patientRequestDto));
//
//            // Create Dentist
//            DentistRequestDto dentistRequestDto = new DentistRequestDto(
//                    "Dr. Shawng"
//            );
//            System.out.println(dentistService.createDentist(dentistRequestDto));
//
//            // Create Surgery
//            SurgeryRequestDto surgeryRequestDto = new SurgeryRequestDto(
//                    "Denver Clinic",
//                    new AddressRequestDto(
//                            "5566 Halifax",
//                            "Denver",
//                            "Colorado",
//                            "80249"
//                    )
//            );
//            System.out.println(surgeryService.createSurgery(surgeryRequestDto));
//
//            // Create Appointment
//            AppointmentRequestDto appointmentRequestDto = new AppointmentRequestDto(
//                   LocalDateTime.of(LocalDate.of(2025,3 ,3), LocalTime.of(12,30)),
//                    surgeryRequestDto,
//                    dentistRequestDto,
//                    patientRequestDto
//            );
//
//            System.out.println(appointmentService.createAppointment(appointmentRequestDto));
//
//        };
//    }

}
