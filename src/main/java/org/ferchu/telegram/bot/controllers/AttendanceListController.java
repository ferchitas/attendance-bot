package org.ferchu.telegram.bot.controllers;

import org.ferchu.telegram.bot.dto.AttendanceListDto;
import org.ferchu.telegram.bot.services.AttendanceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttendanceListController {

    @Autowired
    AttendanceListService attendanceListService;

    /**
     * Gets all the attendance list
     *
     * @return
     */
    @GetMapping("/attendance-lists")
    public ResponseEntity<List<AttendanceListDto>> getAttendanceLists() {
        return ResponseEntity.ok(attendanceListService.findAll());
    }

    /**
     * Get attendance list by ID
     *
     * @return
     */
    @GetMapping("/attendance-list/{attendanceListId}")
    public ResponseEntity<AttendanceListDto> getAttendanceList(@RequestParam Long attendanceListId) {
        System.out.println("This is a test!");
        return ResponseEntity.ok(attendanceListService.findById(attendanceListId));
    }

    /**
     * Creates a new attendance list
     *
     * @return
     */
    @PostMapping("/attendance-list")
    public ResponseEntity<AttendanceListDto> saveAttendanceList(@RequestBody AttendanceListDto list) {
        System.out.println("This is a test!");
        AttendanceListDto savedList = attendanceListService.save(list);
        return ResponseEntity.ok(savedList);
    }

    /**
     * Deletes all attendance lists
     *
     * @return
     */
    @DeleteMapping("/attendance-lists")
    public ResponseEntity<Void> deleteAttendanceLists() {
        attendanceListService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    /**
     * Deletes an attendance list
     *
     * @return
     */
    @DeleteMapping("/attendance-list")
    public ResponseEntity<Void> deleteAttendanceList(@RequestBody AttendanceListDto listDao) {
        attendanceListService.delete(listDao);
        return ResponseEntity.noContent().build();
    }

    /**
     * Update an attendance list
     *
     * @return
     */
    @PutMapping("/attendance-list")
    public ResponseEntity<AttendanceListDto> updateAttendanceList(@RequestBody AttendanceListDto listDao) {

        System.out.println("This is a test!");
        return ResponseEntity.ok(new AttendanceListDto());
    }
}
