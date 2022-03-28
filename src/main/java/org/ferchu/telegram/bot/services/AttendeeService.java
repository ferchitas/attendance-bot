package org.ferchu.telegram.bot.services;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.ferchu.telegram.bot.dto.AttendanceListDto;
import org.ferchu.telegram.bot.dto.MemberDto;
import org.ferchu.telegram.bot.exceptions.NotFoundObjectInDatabaseException;
import org.ferchu.telegram.bot.model.AttendanceList;
import org.ferchu.telegram.bot.model.Member;
import org.ferchu.telegram.bot.repository.IAttendeeRepository;
import org.ferchu.telegram.bot.utils.Transformations.TransformDAOToDTO;
import org.ferchu.telegram.bot.utils.Transformations.TransformDTOtoDAO;
import org.ferchu.telegram.bot.utils.constants.InternalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendeeService implements IAttendeeService {

    @Autowired
    private IAttendeeRepository attendeeRepository;

    @Autowired
    Tracer tracer;

    @Override
    public List<MemberDto> findAll() {

        List<MemberDto> memberDtos = new ArrayList<>();
                Iterable result = attendeeRepository.findAll();
        if(result != null) {

            memberDtos =
                    ((List<Member>) result).stream().map(member -> TransformDAOToDTO.transformMember(member)).collect(Collectors.toList());

        }
        return memberDtos;
    }

    @Override
    public MemberDto findById(Long memberId, Span rootSpan) {

        Span span = tracer.buildSpan("service delete employee").asChildOf(rootSpan).start();
        MemberDto result = TransformDAOToDTO.
                transformMember(attendeeRepository.
                        findById(memberId).
                        orElseThrow(() ->
                                new NotFoundObjectInDatabaseException(InternalConstants.NOT_FOUND_OBJECT_IN_DATABASE)));
        span.finish();
        return result;
    }

    @Override
    public MemberDto save(MemberDto memberDto) {

        Member member = TransformDTOtoDAO.transformMember(memberDto);
        return TransformDAOToDTO.transformMember(attendeeRepository.save(member));
    }

    @Override
    public void delete(MemberDto memberDto) {

        Member member = TransformDTOtoDAO.transformMemberWithId(memberDto);
        attendeeRepository.delete(member);
    }

    @Override
    public void deleteAll() {

        attendeeRepository.deleteAll();
    }

    @Override
    public MemberDto update(MemberDto member) {
        return null;
    }
}
