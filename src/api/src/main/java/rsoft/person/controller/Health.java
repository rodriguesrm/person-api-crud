package rsoft.person.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class Health {

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ok("OK");
    }

}
