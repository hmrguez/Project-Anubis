package com.example.anubis.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {

    private final IAppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId).orElseThrow(() -> new IllegalStateException("Appointment with id " + appointmentId + " does not exist"));
    }

    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    @Transactional
    public void updateAppointment(Long appointmentId, LocalDate date, String description) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new IllegalStateException("Appointment with id " + appointmentId + " does not exist"));

        if (date != null && !date.equals(appointment.getDate())) {
            appointment.setDate(date);
        }
    }
}