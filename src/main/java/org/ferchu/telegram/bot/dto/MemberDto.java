package org.ferchu.telegram.bot.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.ferchu.telegram.bot.model.AttendanceList;
import org.ferchu.telegram.bot.model.Group;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class MemberDto {

    private Long memberId;
    private String name;
    private String message;
    private Set<AttendanceListDto> attendanceLists;

    @Getter(AccessLevel.NONE)
    private Set<GroupDto> groups;

    @Getter(AccessLevel.NONE)
    private Set<GroupDto> adminGroups;

    public Set<GroupDto> getGroups() {

        if(groups == null) {

            groups = new HashSet<>();
        }
        return groups;
    }

    public Set<GroupDto> getAdminGroups() {

        if(adminGroups == null) {

            adminGroups = new HashSet<>();
        }
        return adminGroups;
    }
}
