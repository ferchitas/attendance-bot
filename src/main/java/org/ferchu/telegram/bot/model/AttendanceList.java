package org.ferchu.telegram.bot.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class AttendanceList {

    private String header;
    private String message;
    private LocalDateTime dateTime;
    private List<Attendee> attendees;
}
