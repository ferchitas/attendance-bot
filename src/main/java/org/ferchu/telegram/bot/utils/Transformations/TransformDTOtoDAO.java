package org.ferchu.telegram.bot.utils.Transformations;

import org.ferchu.telegram.bot.dao.AttendanceListDao;
import org.ferchu.telegram.bot.dao.AttendeeDao;
import org.ferchu.telegram.bot.model.AttendanceList;

import java.util.ArrayList;
import java.util.List;

public class TransformDTOtoDAO {

    public static List<AttendanceListDao> transformAListOfAttendanceList(List<AttendanceList> listDto) {

        List<AttendanceListDao> listOfListDaos = new ArrayList<>();
        listDto.forEach(list -> listOfListDaos.add(transformAttendanceList(list)));
        return listOfListDaos;
    }

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
