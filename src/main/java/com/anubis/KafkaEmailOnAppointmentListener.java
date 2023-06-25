package com.anubis;

import com.anubis.appointment.Appointment;
import com.anubis.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaEmailOnAppointmentListener {

    private final EmailService emailService;

    @Autowired
    public KafkaEmailOnAppointmentListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(
            topics = "pet",
            groupId = "groupId"
    )
    void listener(Appointment appointment){
        String ownerEmail  = appointment.getPet().getOwner().getEmail();
        String emailSubject = "Confirmation for vet appointment";
        String content = "This is a message to confirm the vet appointment for " + appointment.getPet().getName() + "\n" +
                "You should present yourself at the vet at" + appointment.getDate();

        emailService.sendEmail(ownerEmail, emailSubject, content);
    }


}
