package org.ferchu.telegram.bot.utils.Transformations;

import org.ferchu.telegram.bot.dto.AttendanceListDto;
import org.ferchu.telegram.bot.dto.GroupDto;
import org.ferchu.telegram.bot.dto.MemberDto;
import org.ferchu.telegram.bot.model.AttendanceList;
import org.ferchu.telegram.bot.model.Group;
import org.ferchu.telegram.bot.model.Member;

import java.util.HashSet;
import java.util.Set;

public class TransformDAOToDTO {

    public static AttendanceList transformAttendanceListDaoWithId (AttendanceListDto listDao) {

        AttendanceList result = transformAttendanceListDao(listDao);
        result.setAttendanceListId(listDao.getAttendanceListId());
        return result;
    }

    public static AttendanceList transformAttendanceListDao (AttendanceListDto listDao) {

        AttendanceList listDto = new AttendanceList();
//        listDto.setAttendanceListId(listDao.getAttendanceListId());
        listDto.setDateTime(listDao.getDateTime());
        listDto.setHeader(listDao.getHeader());
        listDto.setMessage(listDao.getMessage());
            listDao.getMembers().forEach(memberDao -> {
                Member member = new Member();
    //          attendee.setAttendeeId(attendeeDao.getAttendeeDaoId());
                member.setMessage(memberDao.getMessage());
                member.setName(memberDao.getName());
                member.getAttendanceLists().add(listDto);
                listDto.getMembers().add(member);
            });
        return listDto;
    }

    public static GroupDto transformGroup(Group group) {

        GroupDto groupDto = new GroupDto();
        groupDto.setGroupId(group.getGroupId());
        groupDto.setName(group.getName());
        groupDto.getAdmins().addAll(getMemberIds(group.getAdmins()));
        groupDto.getMembers().addAll(getMemberIds(group.getMembers()));
        groupDto.getAttendanceLists().addAll(getAttendanceListIds(group.getAttendanceLists()));

        return groupDto;
    }

    private static Set<AttendanceListDto> getAttendanceListIds(Set<AttendanceList> attendanceLists) {

        Set<AttendanceListDto> listDtos = new HashSet<>();
        if(attendanceLists != null) {
            attendanceLists.forEach(attendanceList -> {

                AttendanceListDto listDto = new AttendanceListDto();
                listDto.setAttendanceListId(attendanceList.getAttendanceListId());
                listDtos.add(listDto);
            });
        }
        return listDtos;
    }

    private static Set<MemberDto> getMemberIds(Set<Member> members) {

        Set<MemberDto> memberDtos = new HashSet<>();
        if(members != null) {
            members.forEach(adminMembers -> {

                MemberDto membersDto = new MemberDto();
                membersDto.setMemberId(adminMembers.getMemberId());
                memberDtos.add(membersDto);
            });
        }
        return memberDtos;
    }
//
//    private static Set<Member> getMembers(Set<MemberDto> membersDao) {
//
//        Set<Member> members = new HashSet<>();
//        membersDao.forEach(memberDao -> {
//
//            Member member = new Member();
//            member.setMessage(memberDao.getMessage());
//            member.setName(memberDao.getName());
//            memberD.get
//        });
//    }

    public static MemberDto transformMemberWithId (Member member) {

        MemberDto result = transformMember(member);
        result.setMemberId(member.getMemberId());
        return result;
    }

    public static MemberDto transformMember(Member member) {

        MemberDto memberDto = new MemberDto();
        memberDto.setMemberId(member.getMemberId());
        memberDto.getGroups().addAll(getGroupIds(member.getGroups()));
        memberDto.getAdminGroups().addAll(getGroupIds(member.getAdminGroups()));
        memberDto.setAttendanceLists(getAttendanceListIds(member.getAttendanceLists()));
        memberDto.setMessage(member.getMessage());
        memberDto.setName(member.getName());
        return memberDto;
    }

    private static Set<GroupDto> getGroupIds(Set<Group> group) {

        Set<GroupDto> groupDtos = new HashSet<>();
        if(group != null) {
            group.forEach(adminGroup -> {

                GroupDto groupDto = new GroupDto();
                groupDto.setGroupId(adminGroup.getGroupId());
                groupDtos.add(groupDto);
            });
        }
        return groupDtos;
    }

//    public static Set<GroupDto> transformGroup(Set<Group> all) {
//    }
}
