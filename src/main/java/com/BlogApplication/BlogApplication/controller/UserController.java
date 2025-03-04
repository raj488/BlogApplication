package com.BlogApplication.BlogApplication.controller;

import com.BlogApplication.BlogApplication.payload.ApiResponse;
import com.BlogApplication.BlogApplication.payload.UserDto;
import com.BlogApplication.BlogApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired  // Ensure this annotation is present
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId){
        UserDto updateUser = this.userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updateUser);
    }
@GetMapping("/")
public ResponseEntity<List<UserDto>> getAllUsers(){

       return ResponseEntity.ok(this.userService.getAllUsers());

}
@GetMapping("/{userId}")
public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){

        return ResponseEntity.ok(this.userService.getUserById(userId));
}
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {
        this.userService.deleteUser(userId);

        ApiResponse response = new ApiResponse("User deleted successfully", true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}


