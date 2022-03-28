package org.ferchu.telegram.bot.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Attendee")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private Long memberId;

    private String name;
    private String message;

    @Getter(AccessLevel.NONE)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "attendanceList_member", joinColumns = {@JoinColumn(name = "memberId")}, inverseJoinColumns =
            {@JoinColumn(name = "attendanceListId")})
    private Set<AttendanceList> attendanceLists;

    @Getter(AccessLevel.NONE)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "group_member", joinColumns = {@JoinColumn(name = "memberId")}, inverseJoinColumns =
            {@JoinColumn(name = "groupId")})
    private Set<Group> groups;

    @Getter(AccessLevel.NONE)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "adminGroup_member", joinColumns = {@JoinColumn(name = "memberId")}, inverseJoinColumns =
            {@JoinColumn(name = "groupId")})
    private Set<Group> adminGroups;

    public Set<Group> getGroups() {

        if(groups == null) {

            groups = new HashSet<>();
        }
        return groups;
    }

    public Set<Group> getAdminGroups() {

        if(adminGroups == null) {

            adminGroups = new HashSet<>();
        }
        return adminGroups;
    }

    public Set<AttendanceList> getAttendanceLists() {

        if(attendanceLists == null) {

            attendanceLists = new HashSet<>();
        }
        return attendanceLists;
    }
}
