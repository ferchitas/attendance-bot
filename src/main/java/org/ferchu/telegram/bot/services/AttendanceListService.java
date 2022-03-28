package org.ferchu.telegram.bot.services;

import org.ferchu.telegram.bot.dto.AttendanceListDto;
import org.ferchu.telegram.bot.exceptions.NotFoundObjectInDatabaseException;
import org.ferchu.telegram.bot.model.AttendanceList;
import org.ferchu.telegram.bot.repository.IAttendanceListRepository;
import org.ferchu.telegram.bot.utils.Transformations.TransformDAOToDTO;
import org.ferchu.telegram.bot.utils.Transformations.TransformDTOtoDAO;
import org.ferchu.telegram.bot.utils.constants.InternalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceListService implements IAttendanceListService {

    @Autowired
    private IAttendanceListRepository attendanceListRepository;

    @Override
    public List<AttendanceListDto> findAll() {

        List<AttendanceList> result = (List<AttendanceList>) attendanceListRepository.findAll();
        return TransformDTOtoDAO.transformAListOfAttendanceList(result);
    }

    @Override
    public AttendanceListDto findById(Long attendanceListId) {
        AttendanceListDto result = TransformDTOtoDAO.
                transformAttendanceList(attendanceListRepository.
                        findById(attendanceListId).
                        orElseThrow(() ->
                                new NotFoundObjectInDatabaseException(InternalConstants.NOT_FOUND_OBJECT_IN_DATABASE)));
        return result;
    }

    @Override
    public AttendanceListDto save(AttendanceListDto list) {

        AttendanceList listDto = TransformDAOToDTO.transformAttendanceListDao(list);
        AttendanceList result = attendanceListRepository.save(listDto);
        return TransformDTOtoDAO.transformAttendanceList(result);
    }

    @Override
    public void delete(AttendanceListDto list) {

        AttendanceList listDto = TransformDAOToDTO.transformAttendanceListDaoWithId(list);
        attendanceListRepository.delete(listDto);
    }

    @Override
    public void deleteAll() {
        attendanceListRepository.deleteAll();
    }

    @Override
    public AttendanceListDto update(AttendanceListDto listDao) {

//        attendanceListRepository
        return null;
    }


}
