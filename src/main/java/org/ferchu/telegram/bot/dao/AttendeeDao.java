package org.ferchu.telegram.bot.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class AttendeeDao {


    private Long attendeeDaoId;

    private String name;
    private String message;
}
