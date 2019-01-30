package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "demo")
public class MyController {

    @GetMapping(value = "/all")
    public @ResponseBody ResponseEntity<String> getMessage() {

        String status = "This endpoint can be accessed by everyone. Modified 09:30.";

        return new ResponseEntity<String>(status, HttpStatus.OK);
    }

    @GetMapping(value = "/secured/nonadmin")
    public @ResponseBody ResponseEntity<String> securedWithoutAuthorisationGetMessage() {

        String status = "Secured endpoint, but doesn't need explicitly an ADMIN to call it";

        return new ResponseEntity<String>(status, HttpStatus.OK);
    }

    //only when the user has the role ADMIN
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/secured/admin")
    public @ResponseBody ResponseEntity<String> securedGetMessage() {

        String status = "Secured endpoint, which can be accessed only by an ADMIN";

        return new ResponseEntity<String>(status, HttpStatus.OK);
    }

}
