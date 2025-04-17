package org.example.dentalservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.dentalservice.dto.request.AppointmentRequestDto;
import org.example.dentalservice.dto.response.AppointmentResponseDto;
import org.example.dentalservice.mapper.AppointmentMapper;
import org.example.dentalservice.mapper.SurgeryMapper;
import org.example.dentalservice.model.Appointment;
import org.example.dentalservice.model.Dentist;
import org.example.dentalservice.model.Patient;
import org.example.dentalservice.model.Surgery;
import org.example.dentalservice.repository.AppointmentRepository;
import org.example.dentalservice.repository.DentistRepository;
import org.example.dentalservice.repository.PatientRepository;
import org.example.dentalservice.repository.SurgeryRepository;
import org.example.dentalservice.service.AppointmentService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final DentistRepository dentistRepository;
    private final PatientRepository patientRepository;
    private final SurgeryRepository surgeryRepository;

    @Override
    @Transactional
    public Optional<AppointmentResponseDto> createAppointment(AppointmentRequestDto appointmentRequestDto) {
        Appointment appointment = appointmentMapper.appointmentRequestDtoToAppointment(appointmentRequestDto);
        Optional<Surgery> optionalSurgery = surgeryRepository.findByName(appointment.getSurgery().getName());
        optionalSurgery.ifPresent(appointment::setSurgery);
        Optional<Dentist> optionalDentist = dentistRepository.findByName(appointment.getDentist().getName());
        optionalDentist.ifPresent(appointment::setDentist);
        Optional<Patient> optionalPatient = patientRepository.findByName(appointment.getPatient().getName());
        optionalPatient.ifPresent(appointment::setPatient);
        appointmentRepository.save(appointment);
        return Optional.ofNullable(appointmentMapper.appointmentToAppointmentResponseDto(appointment));
    }

    @Override
    public void deleteAppointment(AppointmentResponseDto appointmentResponseDto) {

    }

    @Override
    public Optional<AppointmentResponseDto> getAppointmentById(Long id) {
        return Optional.empty();
    }
}
