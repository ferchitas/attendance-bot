package org.ferchu.telegram.bot.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class AttendanceListDto {

    private Long AttendanceListId;

    private String header;
    private String message;
    private LocalDateTime dateTime;

    @Getter(AccessLevel.NONE)
    private Set<MemberDto> members;

    public Set<MemberDto> getMembers() {

        if(members == null){

            members = new HashSet<>();
        }
        return members;
    }
}
