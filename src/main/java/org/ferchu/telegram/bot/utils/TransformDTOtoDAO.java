package org.ferchu.telegram.bot.utils;

import org.ferchu.telegram.bot.dao.AttendanceListDao;
import org.ferchu.telegram.bot.dao.AttendeeDao;
import org.ferchu.telegram.bot.model.AttendanceList;

import java.util.ArrayList;

public class TransformDTOtoDAO {

    public static AttendanceListDao transformAttendanceList(AttendanceList listDto) {

        AttendanceListDao listDao = new AttendanceListDao();
        listDao.setAttendanceListId(listDto.getAttendanceListId());
        listDao.setDateTime(listDto.getDateTime());
        listDao.setHeader(listDto.getHeader());
        listDao.setMessage(listDto.getMessage());
        listDao.setAttendees(new ArrayList<>());
        listDto.getAttendees().forEach(attendee -> {

            AttendeeDao attendeDao = new AttendeeDao();
            attendeDao.setAttendeeDaoId(attendee.getAttendeeId());
            attendeDao.setMessage(attendee.getMessage());
            attendeDao.setName(attendee.getName());
            listDao.getAttendees().add(attendeDao);
        });
        return listDao;
    }
}
