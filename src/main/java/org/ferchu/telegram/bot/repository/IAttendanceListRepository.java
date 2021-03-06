package org.ferchu.telegram.bot.repository;

import org.ferchu.telegram.bot.model.AttendanceList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttendanceListRepository extends CrudRepository<AttendanceList, Long> {
}
