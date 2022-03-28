package org.ferchu.telegram.bot.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class GroupDto {

    private Long groupId;
    private String name;

    @Getter(AccessLevel.NONE)
    private Set<AttendanceListDto> attendanceLists;

    @Getter(AccessLevel.NONE)
    private Set<MemberDto> members;

    @Getter(AccessLevel.NONE)
    private Set<MemberDto> adminMembers;

    public Set<MemberDto> getAdmins() {

        if(adminMembers == null) {

            adminMembers = new HashSet<>();
        }
        return adminMembers;
    }

    public Set<MemberDto> getMembers() {

        if(members == null) {

            members = new HashSet<>();
        }
        return members;
    }

    public Set<AttendanceListDto> getAttendanceLists() {

        if(attendanceLists == null) {

            attendanceLists = new HashSet<>();
        }
        return attendanceLists;
    }
}
