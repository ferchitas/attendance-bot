package org.ferchu.telegram.bot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/test")
    public ResponseEntity test(){

        System.out.println("This is a test!");
        return ResponseEntity.ok("ok");
    }
}
