package org.ferchu.telegram.bot.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "AttendanceList")
public class AttendanceList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private Long attendanceListId;

    private String header;
    private String message;
    private LocalDateTime dateTime;

    @Null
    @OneToMany(targetEntity= Attendee.class, mappedBy="attendanceList", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Attendee> attendees;
}
