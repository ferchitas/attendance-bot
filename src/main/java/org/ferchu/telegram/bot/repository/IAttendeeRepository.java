package org.ferchu.telegram.bot.repository;

import org.ferchu.telegram.bot.model.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttendeeRepository extends CrudRepository<Member, Long> {
}
