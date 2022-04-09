package org.ferchu.telegram.bot.graphql;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.ferchu.telegram.bot.dto.MemberDto;
import org.ferchu.telegram.bot.model.Member;
import org.ferchu.telegram.bot.repository.IAttendeeRepository;
import org.ferchu.telegram.bot.utils.Transformations.TransformDAOToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AttendeesDataFecher  implements DataFetcher<List<MemberDto>> {

    @Autowired
    private IAttendeeRepository attendeeRepository;

    @Override
    public List<MemberDto> get(DataFetchingEnvironment dataFetchingEnvironment) {

        List<MemberDto> memberDtos = new ArrayList<>();
        Iterable result = attendeeRepository.findAll();
        if(result != null) {

            memberDtos =
                    ((List<Member>) result).stream().map(member -> TransformDAOToDTO.transformMember(member)).collect(Collectors.toList());

        }
        return memberDtos;
    }
}
