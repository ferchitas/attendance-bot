package org.ferchu.telegram.bot.controllers;

import org.ferchu.telegram.bot.dto.GroupDto;
import org.ferchu.telegram.bot.model.Group;
import org.ferchu.telegram.bot.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GroupController {

    @Autowired
    GroupService groupService;
    /**
     * Gets all the groups
     *
     * @return
     */
    @GetMapping("/group")
    public ResponseEntity<List<GroupDto>> getGroups(){

        return ResponseEntity.ok(groupService.findAll());
    }

    /**
     * Get group by ID
     *
     * @return
     */
    @GetMapping("/group/{groupId}")
    public ResponseEntity<GroupDto> getGroup(@RequestParam Long groupId){

        return ResponseEntity.ok(groupService.findById(groupId));
    }

    /**
     * Creates a new group
     *
     * @return
     */
    @PostMapping("/group")
    public ResponseEntity<GroupDto> saveGroup(@RequestBody GroupDto group){


        return ResponseEntity.ok(groupService.save(group));
    }

    /**
     * Deletes all groups
     *
     * @return
     */
    @DeleteMapping("/groups")
    public ResponseEntity<?> deleteGroups(){

        groupService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    /**
     * Deletes all groups
     *
     * @return
     */
    @DeleteMapping("/group")
    public ResponseEntity<?> deleteGroup(@RequestBody GroupDto group){

        groupService.delete(group);
        return ResponseEntity.noContent().build();
    }

    /**
     * Update all groups
     *
     * @return
     */
    @PutMapping("/group/{groupId}")
    public ResponseEntity<Group> updateGroup(@RequestParam Long groupId){

        return ResponseEntity.ok(new Group());
    }
}
