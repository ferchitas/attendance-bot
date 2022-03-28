package org.ferchu.telegram.bot.services;

import org.ferchu.telegram.bot.dto.GroupDto;
import org.ferchu.telegram.bot.dto.MemberDto;

import java.util.List;

public interface IGroupService {

    List<GroupDto> findAll();
    GroupDto findById(Long groupId);
    GroupDto save(GroupDto groupDto);
    void delete(GroupDto groupDto);
    void deleteAll();
    GroupDto update(GroupDto groupDto);
}
