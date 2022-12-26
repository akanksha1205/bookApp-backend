package com.digital.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.user.entity.BookEntity;
import com.digital.user.entity.UserEntity;
import com.digital.user.model.BlockBookRequest;
import com.digital.user.model.BlockBookResponse;
import com.digital.user.model.Book;
import com.digital.user.model.CreatesBookRequest;
import com.digital.user.model.CreatesBookResponse;
import com.digital.user.model.EditBookRequest;
import com.digital.user.model.EditBookResponse;
import com.digital.user.model.ErrorInfo;
import com.digital.user.model.SignInRequest;
import com.digital.user.model.SignInResponse;
import com.digital.user.model.SignUpRequest;
import com.digital.user.model.SignUpResponse;
import com.digital.user.repository.BookRepository;
import com.digital.user.repository.SubscriptionRepository;
import com.digital.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public SignUpResponse signUp(SignUpRequest signUpRequest) {
		UserEntity userEntity = new UserEntity();
		userEntity.setEmailID(signUpRequest.getEmailID());
		userEntity.setPassword(signUpRequest.getPassword());
		userEntity.setUserName(signUpRequest.getUserName());
		userEntity.setUserType(signUpRequest.getUserType());
		
		try {
			userEntity = userRepository.save(userEntity);
		} catch (Exception e) {
			
			//e.printStackTrace();
		}
		SignUpResponse signUpResponse = new SignUpResponse();
		if(userEntity!=null) {
			signUpResponse.setUserId(userEntity.getUserID());
		}
		signUpResponse.setSuccessMessage("Account has been successfully created");
		
		return signUpResponse;
	}

	@Override
	public SignInResponse signIn(SignInRequest signInRequest) {
		
		UserEntity userEntity = new UserEntity();
		SignInResponse signInResponse = new SignInResponse();
		
		try {
			userEntity = userRepository.findUser(signInRequest.getUserName(),signInRequest.getPassword());
			if(userEntity.getUserID()!=null && userEntity.getUserName().equals(signInRequest.getUserName()) && userEntity.getPassword().equals(signInRequest.getPassword()) ) {
				signInResponse.setSuccessMessage("Successfully logged in");
				signInResponse.setUserType(userEntity.getUserType());
				signInResponse.setUserId(userEntity.getUserID().toString());
			}
			
		} catch (Exception e) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorMessage("UserId or password is incorrect");
			signInResponse.setErrorInfo(errorInfo);
		}
		
		return signInResponse;
	}

	@Override
	public CreatesBookResponse bookResponse(CreatesBookRequest createsBookRequest) {
		CreatesBookResponse createsBookResponse = new CreatesBookResponse();
		Optional<UserEntity> optional = userRepository.findById(createsBookRequest.getUserID());
		if(!optional.isPresent()) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorMessage("User does not exist");
			createsBookResponse.setErrorInfo(errorInfo);
			
			return createsBookResponse;
		}
		UserEntity userEntity = optional.get();
		if(!userEntity.getUserType().equalsIgnoreCase("AUTHOR")) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorMessage("User is not Authorized to create book");
			createsBookResponse.setErrorInfo(errorInfo);
			
			return createsBookResponse;
		}
		Book book = createsBookRequest.getBook();
		BookEntity bookEntity = new BookEntity();
		bookEntity.setActive(book.getActive());
		bookEntity.setAuthor(book.getAuthor());
		
		bookEntity.setCategory(book.getCategory());
		bookEntity.setContent(book.getContent());
		bookEntity.setPrice(book.getPrice());
		bookEntity.setPublisher(book.getPublisher());
		bookEntity.setReleasedDate(book.getReleasedDate());
		bookEntity.setTitle(book.getTitle());
		
		try {
			bookEntity = bookRepository.save(bookEntity);
		} catch (Exception e) {
			e.printStackTrace();
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorMessage(e.getLocalizedMessage());
			createsBookResponse.setErrorInfo(errorInfo);
			
			return createsBookResponse;
			
		}
		if(bookEntity!=null) {
			createsBookResponse.setBookId(bookEntity.getBookID());
		}
		
		createsBookResponse.setSuccessMsg("Book Created Successfully");
		
		return createsBookResponse;
	}

	@Override
	public EditBookResponse editBook(EditBookRequest editBookRequest) {
		EditBookResponse editBookResponse = new EditBookResponse();
		Optional<UserEntity> optional = userRepository.findById(editBookRequest.getUserID());
		if(!optional.isPresent()) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorMessage("User does not exist");
			editBookResponse.setErrorInfo(errorInfo);
			
			return editBookResponse;
		}
		
		Optional<BookEntity> optionalBook = bookRepository.findById(editBookRequest.getBookID());
		if(!optionalBook.isPresent()) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorMessage("Book not present");
			editBookResponse.setErrorInfo(errorInfo);
			
			return editBookResponse;
		}
		
		UserEntity userEntity = optional.get();
		if(!userEntity.getUserType().equalsIgnoreCase("AUTHOR")) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorMessage("User is not Authorized to edit book");
			editBookResponse.setErrorInfo(errorInfo);
			
			return editBookResponse;
		}
		
		Book book = editBookRequest.getBook();
		BookEntity bookEntity = new BookEntity();
		bookEntity.setActive(book.getActive());
		bookEntity.setAuthor(book.getAuthor());
		
		bookEntity.setCategory(book.getCategory());
		bookEntity.setContent(book.getContent());
		bookEntity.setPrice(book.getPrice());
		bookEntity.setPublisher(book.getPublisher());
		bookEntity.setReleasedDate(book.getReleasedDate());
		bookEntity.setTitle(book.getTitle());
		
		try {
			bookEntity = bookRepository.save(bookEntity);
		} catch (Exception e) {
			e.printStackTrace();
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorMessage(e.getLocalizedMessage());
			editBookResponse.setErrorInfo(errorInfo);
			
			return editBookResponse;
			
		}
		
		editBookResponse.setSuccessMsg("Book Edited Successfully");
		
		return editBookResponse;
	}

	@Override
	public BlockBookResponse blockBook(BlockBookRequest blockBookRequest) {
		BlockBookResponse blockBookResponse = new BlockBookResponse();
		Optional<UserEntity> optional = userRepository.findById(blockBookRequest.getUserID());
		if(!optional.isPresent()) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorMessage("User does not exist");
			blockBookResponse.setErrorInfo(errorInfo);
			
			return blockBookResponse;
		}

		UserEntity userEntity = optional.get();
		if(!userEntity.getUserType().equalsIgnoreCase("AUTHOR")) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorMessage("User is not Authorized to b book");
			blockBookResponse.setErrorInfo(errorInfo);
			
			return blockBookResponse;
		}
		
		Optional<BookEntity> optionalBook = bookRepository.findById(blockBookRequest.getBookID());
		if(!optionalBook.isPresent()) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorMessage("Book not present");
			blockBookResponse.setErrorInfo(errorInfo);
			
			return blockBookResponse;
		}
		
		
		BookEntity bookEntity = optionalBook.get();
		if(bookEntity.getActive().equalsIgnoreCase("No")) {
		
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorMessage("Book is already blocked");
			blockBookResponse.setErrorInfo(errorInfo);
			
			return blockBookResponse;
					
		}

		blockBookResponse.setSuccessMsg("Book has been blocked");
		return blockBookResponse;
	}

	@Override
	public BlockBookResponse unBlockBook(BlockBookRequest blockBookRequest) {
		BlockBookResponse blockBookResponse = new BlockBookResponse();
		Optional<UserEntity> optional = userRepository.findById(blockBookRequest.getUserID());
		if(!optional.isPresent()) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorMessage("User does not exist");
			blockBookResponse.setErrorInfo(errorInfo);
			
			return blockBookResponse;
		}

		UserEntity userEntity = optional.get();
		if(!userEntity.getUserType().equalsIgnoreCase("AUTHOR")) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorMessage("User is not Authorized to b book");
			blockBookResponse.setErrorInfo(errorInfo);
			
			return blockBookResponse;
		}
		
		Optional<BookEntity> optionalBook = bookRepository.findById(blockBookRequest.getBookID());
		if(!optionalBook.isPresent()) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorMessage("Book not present");
			blockBookResponse.setErrorInfo(errorInfo);
			
			return blockBookResponse;
		}
		
		
		BookEntity bookEntity = optionalBook.get();
		if(bookEntity.getActive().equalsIgnoreCase("Yes")) {
		
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorMessage("Book is Unblocked");
			blockBookResponse.setErrorInfo(errorInfo);
			
			return blockBookResponse;
					
		}

		blockBookResponse.setSuccessMsg("User has unblocked the book");
		return blockBookResponse;
	}

}
