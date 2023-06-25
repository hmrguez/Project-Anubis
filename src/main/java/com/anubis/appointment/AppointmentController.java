package com.anubis.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private KafkaTemplate<String, Appointment> kafkaTemplate;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, KafkaTemplate<String, Appointment> kafkaTemplate) {
        this.appointmentService = appointmentService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{appointmentId}")
    public Appointment getAppointmentById(@PathVariable Long appointmentId) {
        return appointmentService.getAppointmentById(appointmentId);
    }

    @PostMapping
    public void saveAppointment(@RequestBody Appointment appointment) {
        appointmentService.saveAppointment(appointment);
        kafkaTemplate.send("pet", appointment);
    }

    @DeleteMapping("/{appointmentId}")
    public void deleteAppointment(@PathVariable Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
    }

    @PutMapping("/{appointmentId}")
    public void updateAppointment(@PathVariable Long appointmentId, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam(required = false) String description) {
        appointmentService.updateAppointment(appointmentId, date, description);
    }
}