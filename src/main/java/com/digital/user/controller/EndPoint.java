package com.digital.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.user.model.BlockBookRequest;
import com.digital.user.model.BlockBookResponse;
import com.digital.user.model.CreatesBookRequest;
import com.digital.user.model.CreatesBookResponse;
import com.digital.user.model.EditBookRequest;
import com.digital.user.model.EditBookResponse;
import com.digital.user.model.SignInRequest;
import com.digital.user.model.SignInResponse;
import com.digital.user.model.SignUpRequest;
import com.digital.user.model.SignUpResponse;
import com.digital.user.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/digitalbooks")
public class EndPoint {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest signUpRequest){
		SignUpResponse signUpResponse = new SignUpResponse();
		signUpResponse = userService.signUp(signUpRequest);
		return new ResponseEntity<SignUpResponse>(signUpResponse, HttpStatus.OK);
	}
	
	@PostMapping("/signin")
	public  ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest signInRequest){
	
		SignInResponse signInResponse = new SignInResponse();
		signInResponse = userService.signIn(signInRequest);
		return new ResponseEntity<SignInResponse>(signInResponse, HttpStatus.OK);
	}
	
	@PostMapping("/createbook")
	public  ResponseEntity<CreatesBookResponse> bookResponse(@RequestBody CreatesBookRequest createsBookRequest){
	
		CreatesBookResponse createsBookResponse = new CreatesBookResponse();
		createsBookResponse = userService.bookResponse(createsBookRequest);
		return new ResponseEntity<CreatesBookResponse>(createsBookResponse, HttpStatus.OK);
	}
	
	@PostMapping("/edit")
	public  ResponseEntity<EditBookResponse> editBook(@RequestBody EditBookRequest editBookRequest){
		
		EditBookResponse editBookResponse = new EditBookResponse();
		editBookResponse = userService.editBook(editBookRequest);
		return new ResponseEntity<EditBookResponse>(editBookResponse, HttpStatus.OK);
	}
	
	@PostMapping("/blockBook")
	public  ResponseEntity<BlockBookResponse> blockBook(@RequestBody BlockBookRequest blockBookRequest){
	
		BlockBookResponse blockBookResponse = new BlockBookResponse();
		blockBookResponse = userService.blockBook(blockBookRequest);
		return new ResponseEntity<BlockBookResponse>(blockBookResponse, HttpStatus.OK);
	}
	
	@PostMapping("/unblockBook")
	public  ResponseEntity<BlockBookResponse> unBlockBook(@RequestBody BlockBookRequest blockBookRequest){
	
		BlockBookResponse blockBookResponse = new BlockBookResponse();
		blockBookResponse = userService.unBlockBook(blockBookRequest);
		return new ResponseEntity<BlockBookResponse>(blockBookResponse, HttpStatus.OK);
	}

}
