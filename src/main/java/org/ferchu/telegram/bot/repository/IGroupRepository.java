package org.ferchu.telegram.bot.repository;

import org.ferchu.telegram.bot.model.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroupRepository extends CrudRepository<Group, Long> {
}
