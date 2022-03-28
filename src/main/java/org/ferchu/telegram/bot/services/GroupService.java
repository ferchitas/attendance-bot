package org.ferchu.telegram.bot.services;

import org.ferchu.telegram.bot.dto.GroupDto;
import org.ferchu.telegram.bot.dto.MemberDto;
import org.ferchu.telegram.bot.model.Group;
import org.ferchu.telegram.bot.model.Member;
import org.ferchu.telegram.bot.repository.IGroupRepository;
import org.ferchu.telegram.bot.utils.Transformations.TransformDAOToDTO;
import org.ferchu.telegram.bot.utils.Transformations.TransformDTOtoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService implements IGroupService {

    @Autowired
    IGroupRepository groupRepository;

    @Override
    public List<GroupDto> findAll() {

        List<GroupDto> groupDtos = new ArrayList<>();
        Iterable result = groupRepository.findAll();
        if(result != null) {

            groupDtos =
                    ((List<Group>) result).stream().map(group -> TransformDAOToDTO.transformGroup(group)).collect(Collectors.toList());

        }
        return groupDtos;
    }

    @Override
    public GroupDto findById(Long groupId) {
        return null;
    }

    @Override
    public GroupDto save(GroupDto group) {

        return TransformDAOToDTO.transformGroup(groupRepository.save(TransformDTOtoDAO.transformGroup(group)));
    }

    @Override
    public void delete(GroupDto groupDto) {

        groupRepository.delete(TransformDTOtoDAO.transformGroup(groupDto));
    }

    @Override
    public void deleteAll() {

        groupRepository.deleteAll();
    }

    @Override
    public GroupDto update(GroupDto groupDto) {
        return null;
    }
}
