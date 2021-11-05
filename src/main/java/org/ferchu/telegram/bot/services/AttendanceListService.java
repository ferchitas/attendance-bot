package org.ferchu.telegram.bot.services;

import org.ferchu.telegram.bot.dao.AttendanceListDao;
import org.ferchu.telegram.bot.model.AttendanceList;
import org.ferchu.telegram.bot.model.Attendee;
import org.ferchu.telegram.bot.repository.IAttendanceListRepository;
import org.ferchu.telegram.bot.repository.IAttendeeRepository;
import org.ferchu.telegram.bot.utils.TransformDAOToDTO;
import org.ferchu.telegram.bot.utils.TransformDTOtoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceListService implements IAttendanceListService {

    @Autowired
    private IAttendanceListRepository attendanceListRepository;

    @Override
    public List<AttendanceListDao> findAll() {

        List<AttendanceList> result = (List<AttendanceList>) attendanceListRepository.findAll();

        List<AttendanceListDao> listDao = new ArrayList<>();
        return listDao;
    }

    @Override
    public AttendanceListDao save(AttendanceListDao list) {

        AttendanceList listDto = TransformDAOToDTO.transformAttendanceListDao(list);
        AttendanceList result = attendanceListRepository.save(listDto);
        return TransformDTOtoDAO.transformAttendanceList(result);
    }
}
