package org.ferchu.telegram.bot.dao;

import lombok.Getter;
import lombok.Setter;
import org.ferchu.telegram.bot.model.Attendee;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class AttendanceListDao {

    private Long AttendanceListId;

    private String header;
    private String message;
    private LocalDateTime dateTime;
    private List<AttendeeDao> attendees;
}
