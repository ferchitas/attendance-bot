package org.ferchu.telegram.bot.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private Long groupId;

    private String name;

    @Null
    @OneToMany(targetEntity=AttendanceList.class, mappedBy="group", fetch=FetchType.LAZY, cascade=CascadeType.ALL,
            orphanRemoval = true)
    private Set<AttendanceList> attendanceLists;

    @Null
    @ManyToMany(mappedBy = "groups")
    @Getter(AccessLevel.NONE)
    private Set<Member> members;

    @Null
    @ManyToMany(mappedBy = "adminGroups")
    @Getter(AccessLevel.NONE)
    private Set<Member> admins;

    public Set<Member> getAdmins() {

        if(admins == null) {

            admins = new HashSet<>();
        }
        return admins;
    }

    public Set<Member> getMembers() {

        if(members == null) {

            members = new HashSet<>();
        }
        return members;
    }

    public Set<AttendanceList> getAttendanceLists() {

        if(attendanceLists == null) {

            attendanceLists = new HashSet<>();
        }
        return attendanceLists;
    }
}
