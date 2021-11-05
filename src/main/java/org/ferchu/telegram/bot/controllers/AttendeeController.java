package org.ferchu.telegram.bot.controllers;

import org.ferchu.telegram.bot.model.Attendee;
import org.ferchu.telegram.bot.services.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AttendeeController {

    @Autowired
    AttendeeService attendeeService;

    /**
     * Gets all the attendees
     *
     * @return
     */
    @GetMapping("/attendee")
    public ResponseEntity<List<Attendee>> getAttendes(){

        System.out.println("This is a test!");
        return ResponseEntity.ok(new ArrayList<>());
    }

    /**
     * Get attendee by ID
     *
     * @return
     */
    @GetMapping("/attendee/{attendeeId}")
    public ResponseEntity<Attendee> getAttendee(){

        System.out.println("This is a test!");
        return ResponseEntity.ok(new Attendee());
    }

    /**
     * Creates a new attendee
     *
     * @return
     */
    @PostMapping("/attendee")
    public ResponseEntity<Attendee> saveAttendee(@RequestBody Attendee attendee){

        System.out.println("This is a test!");
        attendeeService.save(attendee);
        return ResponseEntity.ok(attendee);
    }

    /**
     * Deletes all attendees
     *
     * @return
     */
    @DeleteMapping("/attendee")
    public ResponseEntity<Attendee> deleteAttendees(){

        System.out.println("This is a test!");
        return ResponseEntity.ok(new Attendee());
    }

    /**
     * Deletes all attendees
     *
     * @return
     */
    @DeleteMapping("/attendee/{attendeeId}")
    public ResponseEntity<List<Attendee>> deleteAttendee(){

        System.out.println("This is a test!");
        return ResponseEntity.ok(new ArrayList<>());
    }

    /**
     * Update all attendees
     *
     * @return
     */
    @PutMapping("/attendee/{attendeeId}")
    public ResponseEntity<Attendee> updateAttendee(){

        System.out.println("This is a test!");
        return ResponseEntity.ok(new Attendee());
    }
}
