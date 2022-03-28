package org.ferchu.telegram.bot.services;

import org.ferchu.telegram.bot.dto.AttendanceListDto;

import java.util.List;

public interface IAttendanceListService {

    List<AttendanceListDto> findAll();
    AttendanceListDto findById(Long attendanceListId);
    AttendanceListDto save(AttendanceListDto attendee);
    void delete(AttendanceListDto listDao);
    void deleteAll();
    AttendanceListDto update(AttendanceListDto listDao);
}
