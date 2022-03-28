package org.ferchu.telegram.bot.utils.mappers;

import org.ferchu.telegram.bot.dto.MemberDto;
import org.ferchu.telegram.bot.model.Member;
import org.mapstruct.Mapper;

@Mapper
public interface AttendeeMapper {

    Member memberToMemberDTO(MemberDto memberDto);
}
