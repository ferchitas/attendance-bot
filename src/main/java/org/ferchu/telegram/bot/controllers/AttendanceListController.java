package org.ferchu.telegram.bot.controllers;

import org.ferchu.telegram.bot.dao.AttendanceListDao;
import org.ferchu.telegram.bot.model.AttendanceList;
import org.ferchu.telegram.bot.model.Attendee;
import org.ferchu.telegram.bot.services.AttendanceListService;
import org.ferchu.telegram.bot.services.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AttendanceListController {

    @Autowired
    AttendanceListService attendanceListService;
    /**
     * Gets all the attendees
     *
     * @return
     */
    @GetMapping("/attendance-list")
    public ResponseEntity<List<AttendanceListDao>> getAttendes(){

        System.out.println("This is a test!");
        return ResponseEntity.ok(new ArrayList<>());
    }

    /**
     * Get attendee by ID
     *
     * @return
     */
    @GetMapping("/attendance-list/{attendeeId}")
    public ResponseEntity<AttendanceListDao> getAttendee(){

        System.out.println("This is a test!");
        return ResponseEntity.ok(new AttendanceListDao());
    }

    /**
     * Creates a new attendee
     *
     * @return
     */
    @PostMapping("/attendance-list")
    public ResponseEntity<AttendanceListDao> saveAttendee(@RequestBody AttendanceListDao list){

        System.out.println("This is a test!");
        AttendanceListDao savedList = attendanceListService.save(list);
        return ResponseEntity.ok(savedList);
    }

    /**
     * Deletes all attendees
     *
     * @return
     */
    @DeleteMapping("/attendance-list")
    public ResponseEntity<AttendanceList> deleteAttendees(){

        System.out.println("This is a test!");
        return ResponseEntity.ok(new AttendanceList());
    }

    /**
     * Deletes all attendees
     *
     * @return
     */
    @DeleteMapping("/attendance-list/{attendanceListId}")
    public ResponseEntity<List<AttendanceList>> deleteAttendee(){

        System.out.println("This is a test!");
        return ResponseEntity.ok(new ArrayList<>());
    }

    /**
     * Update all attendees
     *
     * @return
     */
    @PutMapping("/attendance-list/{attendanceListId}")
    public ResponseEntity<Attendee> updateAttendee(){

        System.out.println("This is a test!");
        return ResponseEntity.ok(new Attendee());
    }
}
