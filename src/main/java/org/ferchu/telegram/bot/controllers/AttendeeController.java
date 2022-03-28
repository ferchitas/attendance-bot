package org.ferchu.telegram.bot.controllers;

import com.google.common.collect.ImmutableMap;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.ferchu.telegram.bot.dto.AttendanceListDto;
import org.ferchu.telegram.bot.dto.MemberDto;
import org.ferchu.telegram.bot.services.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class AttendeeController {

    @Autowired
    AttendeeService attendeeService;

    @Autowired
    Tracer tracer;

    /**
     * Gets all the attendees
     *
     * @return
     */
    @GetMapping("/attendee")
    public ResponseEntity<List<MemberDto>> getAttendes(){

        Span span = tracer.buildSpan("get attendee").start();
        span.setTag("http.status_code", 200);
        span.finish();
        return ResponseEntity.ok(attendeeService.findAll());
    }

    /**
     * Get attendee by ID
     *
     * @return
     */
    @GetMapping("/attendee/{attendeeId}")
    public ResponseEntity<MemberDto> getAttendee(@RequestParam Long attendanceListId){

        Span span = tracer.buildSpan("get by id attendee").start();
        span.log(ImmutableMap.of("event", "get-request", "value",1));
        span.setTag("http.status_code", 200);
        span.finish();
        return ResponseEntity.ok(attendeeService.findById(attendanceListId, span));
    }

    /**
     * Creates a new attendee
     *
     * @return
     */
    @PostMapping("/attendee")
    public ResponseEntity<MemberDto> saveAttendee(@RequestBody MemberDto member){

        System.out.println("This is a test!");
        attendeeService.save(member);
        return ResponseEntity.ok(member);
    }

    /**
     * Deletes all attendees
     *
     * @return
     */
    @DeleteMapping("/attendee")
    public ResponseEntity<?> deleteAttendees(){

        System.out.println("This is a test!");
        attendeeService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    /**
     * Deletes all attendees
     *
     * @return
     */
    @DeleteMapping("/attendee/{attendeeId}")
    public ResponseEntity<?> deleteAttendee(@RequestBody MemberDto memberDto){

        attendeeService.delete(memberDto);
        return ResponseEntity.noContent().build();
    }

    /**
     * Update all attendees
     *
     * @return
     */
    @PutMapping("/attendee/{attendeeId}")
    public ResponseEntity<MemberDto> updateAttendee(){

        System.out.println("This is a test!");
        return ResponseEntity.ok(new MemberDto());
    }
}
