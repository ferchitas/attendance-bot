package org.ferchu.telegram.bot.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Attendee")
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private Long attendeeId;

    private String name;
    private String message;

    @ManyToOne
    @JoinColumn(name="attendanceListId")
    private AttendanceList attendanceList;
}
