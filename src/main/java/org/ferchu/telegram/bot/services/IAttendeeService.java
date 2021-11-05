package org.ferchu.telegram.bot.services;

import org.ferchu.telegram.bot.model.AttendanceList;
import org.ferchu.telegram.bot.model.Attendee;

import java.util.List;

public interface IAttendeeService {

    List<Attendee> findAll();
    Attendee save(Attendee attendee);
}
