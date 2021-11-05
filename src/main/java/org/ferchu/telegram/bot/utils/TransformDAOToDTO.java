package org.ferchu.telegram.bot.utils;

import org.ferchu.telegram.bot.dao.AttendanceListDao;
import org.ferchu.telegram.bot.dao.AttendeeDao;
import org.ferchu.telegram.bot.model.AttendanceList;
import org.ferchu.telegram.bot.model.Attendee;

import java.util.ArrayList;

public class TransformDAOToDTO {

    public static AttendanceList transformAttendanceListDao (AttendanceListDao listDao) {

        AttendanceList listDto = new AttendanceList();
//        listDto.setAttendanceListId(listDao.getAttendanceListId());
        listDto.setDateTime(listDao.getDateTime());
        listDto.setHeader(listDao.getHeader());
        listDto.setMessage(listDao.getMessage());
        listDto.setAttendees(new ArrayList<>());
        if(listDao.getAttendees() != null) {
            listDao.getAttendees().forEach(attendeeDao -> {
                Attendee attendee = new Attendee();
    //          attendee.setAttendeeId(attendeeDao.getAttendeeDaoId());
                attendee.setMessage(attendeeDao.getMessage());
                attendee.setName(attendeeDao.getName());
                attendee.setAttendanceList(listDto);
                listDto.getAttendees().add(attendee);
            });
        }
        return listDto;
    }
}
