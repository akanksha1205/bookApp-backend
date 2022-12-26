package com.digital.user.service;

import org.springframework.stereotype.Service;

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

@Service
public interface UserService {

public SignUpResponse signUp(SignUpRequest signUpRequest);
	
	public SignInResponse signIn(SignInRequest signInRequest);
	
	public CreatesBookResponse bookResponse(CreatesBookRequest createsBookRequest);
	
	public EditBookResponse editBook(EditBookRequest editBookRequest);
	
	public BlockBookResponse blockBook(BlockBookRequest blockBookRequest);
	
	public BlockBookResponse unBlockBook(BlockBookRequest blockBookRequest);
}
