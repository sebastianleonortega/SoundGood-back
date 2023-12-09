package com.soundgood.service.impl;

import com.soundgood.Exception.AppointmentConflictException;
import com.soundgood.model.Appointment;
import com.soundgood.repository.AppointmentRepository;
import com.soundgood.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {

        if (appointmentRepository.existsByDoctorAndDateAndTime(appointment.getDoctor(), appointment.getDate(), appointment.getTime())) {
            throw new AppointmentConflictException("El doctor ya tiene una cita en la misma fecha y hora");
        }
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment appointment) {
        getAppointmentById(id);
        appointment.setId(id);
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
