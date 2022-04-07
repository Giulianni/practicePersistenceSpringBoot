package com.practice.persistencepractice.controller;

import com.practice.persistencepractice.dto.login.UserDto;
import com.practice.persistencepractice.exceptions.BadRequestException;
import com.practice.persistencepractice.exceptions.ResourceNotFoundException;
import com.practice.persistencepractice.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    private final static Logger logger = Logger.getLogger(UserController.class);

    @ApiOperation(value = "EN: Creating a new user.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 400, message = "Bad Request")})
    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody UserDto user) throws BadRequestException {
        logger.info("Ingresando el siguiente usuario a la base de datos: \n" + user.getFirstName());
        UserDto response = userService.createUser(user);
        logger.info("Usuario " + response.toString() + " fue creado con exito.");
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "EN: Sign in.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 400, message = "Bad Request")})
    @PostMapping("/users/login")
    public ResponseEntity<?> login(@RequestBody UserDto user) throws BadRequestException, ResourceNotFoundException {
        logger.info("Loading user: \n" + user.getFirstName());
        JSONObject response = userService.login(user);
        logger.info("Usuario " + response.toString() + " ingresó con exito.");
        return ResponseEntity.ok(response);
    }
}
