package org.ferchu.telegram.bot.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private long chatId;

    @Getter(AccessLevel.NONE)
    @Null
    @ManyToMany(mappedBy = "attendanceLists")
    private Set<Member> members;

    @ManyToOne
    @JoinColumn(name="groupId")
    private Group group;

    public Set<Member> getMembers() {

        if(members == null) {

            members = new HashSet<>();
        }
        return members;
    }
}
