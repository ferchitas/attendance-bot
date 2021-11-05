package org.ferchu.telegram.bot.services;

import org.ferchu.telegram.bot.model.Attendee;
import org.ferchu.telegram.bot.repository.IAttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeService implements IAttendeeService{

    @Autowired
    private IAttendeeRepository attendeeRepository;

    @Override
    public List<Attendee> findAll() {

        return (List<Attendee>) attendeeRepository.findAll();
    }

    @Override
    public Attendee save(Attendee attendee) {

        return attendeeRepository.save(attendee);
    }
}
