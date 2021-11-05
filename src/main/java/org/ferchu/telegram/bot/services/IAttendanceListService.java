package org.ferchu.telegram.bot.services;

import org.ferchu.telegram.bot.dao.AttendanceListDao;
import org.ferchu.telegram.bot.model.AttendanceList;
import org.ferchu.telegram.bot.model.Attendee;

import java.util.List;

public interface IAttendanceListService {

    List<AttendanceListDao> findAll();
    AttendanceListDao save(AttendanceListDao attendee);
}
