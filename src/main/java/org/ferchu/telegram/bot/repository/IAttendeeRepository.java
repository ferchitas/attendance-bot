package org.ferchu.telegram.bot.repository;

import org.ferchu.telegram.bot.model.Attendee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttendeeRepository extends CrudRepository<Attendee, Long> {
}
