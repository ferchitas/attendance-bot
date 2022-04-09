package org.ferchu.telegram.bot.graphql;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.ferchu.telegram.bot.dto.MemberDto;
import org.ferchu.telegram.bot.exceptions.NotFoundObjectInDatabaseException;
import org.ferchu.telegram.bot.repository.IAttendeeRepository;
import org.ferchu.telegram.bot.utils.Transformations.TransformDAOToDTO;
import org.ferchu.telegram.bot.utils.constants.InternalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttendeeDataFecher implements DataFetcher<MemberDto> {

    @Autowired
    private IAttendeeRepository attendeeRepository;

    @Override
    public MemberDto get(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("id");
        MemberDto result =  TransformDAOToDTO.
                transformMember(attendeeRepository.
                        findById(id).
                        orElseThrow(() ->
                                new NotFoundObjectInDatabaseException(InternalConstants.NOT_FOUND_OBJECT_IN_DATABASE)));
        return result;
    }
}
