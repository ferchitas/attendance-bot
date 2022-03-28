package org.ferchu.telegram.bot.utils.Transformations;

import org.ferchu.telegram.bot.dto.AttendanceListDto;
import org.ferchu.telegram.bot.dto.GroupDto;
import org.ferchu.telegram.bot.dto.MemberDto;
import org.ferchu.telegram.bot.model.AttendanceList;
import org.ferchu.telegram.bot.model.Group;
import org.ferchu.telegram.bot.model.Member;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransformDTOtoDAO {

    public static List<AttendanceListDto> transformAListOfAttendanceList(List<AttendanceList> listDto) {

        List<AttendanceListDto> listOfListDaos = new ArrayList<>();
        listDto.forEach(list -> listOfListDaos.add(transformAttendanceList(list)));
        return listOfListDaos;
    }

    public static AttendanceListDto transformAttendanceList(AttendanceList listDto) {

        AttendanceListDto listDao = new AttendanceListDto();
        listDao.setAttendanceListId(listDto.getAttendanceListId());
        listDao.setDateTime(listDto.getDateTime());
        listDao.setHeader(listDto.getHeader());
        listDao.setMessage(listDto.getMessage());
        listDto.getMembers().forEach(attendee -> {
            MemberDto attendeDao = new MemberDto();
            attendeDao.setMemberId(attendee.getMemberId());
            attendeDao.setMessage(attendee.getMessage());
            attendeDao.setName(attendee.getName());
            listDao.getMembers().add(attendeDao);
        });
        return listDao;
    }


    public static Group transformGroup(GroupDto groupDto) {

        Group group = new Group();

        group.setGroupId(groupDto.getGroupId());
        group.getAdmins().addAll(getMembersWithId(groupDto.getAdmins()));
        group.getMembers().addAll(getMembersWithId(groupDto.getMembers()));
        group.setName(groupDto.getName());
        group.setAttendanceLists(getAttendanceListIds(groupDto.getAttendanceLists()));

        return group;
    }

    public static Set<Member> getMembers(Set<MemberDto> memberDtos) {

        Set<Member> members = new HashSet<>();
        memberDtos.forEach(memberDto -> {

            Member member = new Member();
            member.setMemberId(member.getMemberId());
            member.setAdminGroups(getGroupsWithId(memberDto.getAdminGroups()));
            member.setMessage(memberDto.getMessage());
            member.setName(memberDto.getName());
            member.setGroups(getGroupsWithId(memberDto.getGroups()));
            members.add(member);
        });
        return members;
    }

    public static Set<Member> getMembersWithId(Set<MemberDto> memberDtos) {

        Set<Member> members = new HashSet<>();
        memberDtos.forEach(memberDto -> {

            Member member = new Member();
            member.setMemberId(member.getMemberId());
            members.add(member);
        });
        return members;
    }

    public static Set<Group> getGroupsWithId(Set<GroupDto> groupDtos) {

        Set<Group> groups = new HashSet<>();
        groupDtos.forEach(groupDto -> {

            Group group = new Group();
            group.setGroupId(groupDto.getGroupId());
            groups.add(group);
        });
        return groups;
    }

    public static Member transformMemberWithId (MemberDto memberDto) {

        Member result = transformMember(memberDto);
        result.setMemberId(memberDto.getMemberId());
        return result;
    }

    public static Member transformMember(MemberDto memberDto) {

        Member member = new Member();
        member.setMemberId(memberDto.getMemberId());
        member.getGroups().addAll(getGroupIds(memberDto.getGroups()));
        member.getAdminGroups().addAll(getGroupIds(memberDto.getAdminGroups()));
        member.setAttendanceLists(getAttendanceListIds(memberDto.getAttendanceLists()));
        member.setMessage(memberDto.getMessage());
        member.setName(memberDto.getName());
        return member;
    }

    private static Set<Group> getGroupIds(Set<GroupDto> groupDtos) {

        Set<Group> groups = new HashSet<>();
        if(groupDtos != null) {
            groupDtos.forEach(groupDto -> {

                Group group = new Group();
                group.setGroupId(groupDto.getGroupId());
                groups.add(group);
            });
        }
        return groups;
    }

    private static Set<AttendanceList> getAttendanceListIds(Set<AttendanceListDto> attendanceListDtos) {

        Set<AttendanceList> attendanceLists = new HashSet<>();
        if(attendanceListDtos != null) {
            attendanceListDtos.forEach(attendanceList -> {

                AttendanceList list = new AttendanceList();
                list.setAttendanceListId(attendanceList.getAttendanceListId());
                attendanceLists.add(list);
            });
        }
        return attendanceLists;
    }
}
