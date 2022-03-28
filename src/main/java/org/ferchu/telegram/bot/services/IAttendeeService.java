package org.ferchu.telegram.bot.services;

import io.opentracing.Span;
import org.ferchu.telegram.bot.dto.AttendanceListDto;
import org.ferchu.telegram.bot.dto.MemberDto;

import java.util.List;

public interface IAttendeeService {

    List<MemberDto> findAll();
    MemberDto findById(Long memberId, Span rootSpan);
    MemberDto save(MemberDto member);
    void delete(MemberDto member);
    void deleteAll();
    MemberDto update(MemberDto member);
}
