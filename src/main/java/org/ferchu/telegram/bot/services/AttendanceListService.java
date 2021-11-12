package org.ferchu.telegram.bot.services;

import org.ferchu.telegram.bot.dao.AttendanceListDao;
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
    public List<AttendanceListDao> findAll() {

        List<AttendanceList> result = (List<AttendanceList>) attendanceListRepository.findAll();
        return TransformDTOtoDAO.transformAListOfAttendanceList(result);
    }

    @Override
    public AttendanceListDao findById(Long attendanceListId) {
        AttendanceListDao result = TransformDTOtoDAO.
                transformAttendanceList(attendanceListRepository.
                        findById(attendanceListId).
                        orElseThrow(() ->
                                new NotFoundObjectInDatabaseException(InternalConstants.NOT_FOUND_OBJECT_IN_DATABASE)));
        return result;
    }

    @Override
    public AttendanceListDao save(AttendanceListDao list) {

        AttendanceList listDto = TransformDAOToDTO.transformAttendanceListDao(list);
        AttendanceList result = attendanceListRepository.save(listDto);
        return TransformDTOtoDAO.transformAttendanceList(result);
    }

    @Override
    public void delete(AttendanceListDao list) {

        AttendanceList listDto = TransformDAOToDTO.transformAttendanceListDaoWithId(list);
        attendanceListRepository.delete(listDto);
    }

    @Override
    public void deleteAll() {
        attendanceListRepository.deleteAll();
    }

    @Override
    public AttendanceListDao update(AttendanceListDao listDao) {

//        attendanceListRepository
        return null;
    }


}
