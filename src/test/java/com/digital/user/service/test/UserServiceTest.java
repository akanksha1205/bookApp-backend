package com.digital.user.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.digital.user.entity.BookEntity;
import com.digital.user.entity.UserEntity;
import com.digital.user.model.Book;
import com.digital.user.model.CreatesBookRequest;
import com.digital.user.model.CreatesBookResponse;
import com.digital.user.model.EditBookRequest;
import com.digital.user.model.EditBookResponse;
import com.digital.user.model.SignInRequest;
import com.digital.user.model.SignInResponse;
import com.digital.user.model.SignUpRequest;
import com.digital.user.model.SignUpResponse;
import com.digital.user.repository.BookRepository;
import com.digital.user.repository.SubscriptionRepository;
import com.digital.user.repository.UserRepository;
import com.digital.user.service.UserServiceImpl;


public class UserServiceTest {
	
	@Mock
	BookRepository bookRepository;
	@Mock
	UserRepository userRepository;
	@Mock
	SubscriptionRepository subscriptionRepository;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(userServiceImpl, "bookRepository", bookRepository);
		ReflectionTestUtils.setField(userServiceImpl, "userRepository", userRepository);
		ReflectionTestUtils.setField(userServiceImpl, "subscriptionRepository", subscriptionRepository);
	}
	
	@Test
	void singUpTest() throws Exception{
		SignUpRequest signUpRequest = new SignUpRequest();
		signUpRequest.setEmailID("ak@gmail.com");
		signUpRequest.setPassword("ak@123");
		signUpRequest.setUserName("akanksha");
		signUpRequest.setUserType("Author");
		
		SignUpResponse signUpResponse = new SignUpResponse();
		UserEntity userEntity = new UserEntity();
		userEntity.setEmailID(signUpRequest.getEmailID());
		userEntity.setPassword(signUpRequest.getPassword());
		userEntity.setUserName(signUpRequest.getUserName());
		userEntity.setUserType(signUpRequest.getUserType());
		userEntity.setUserID(2);
		when(userRepository.save(userEntity)).thenReturn(userEntity);
		signUpResponse = userServiceImpl.signUp(signUpRequest);
		
		assertNotNull(signUpResponse);
	}
	@Test
	void singUpInvalidTest() throws Exception{
		SignUpRequest signUpRequest = new SignUpRequest();
		signUpRequest.setEmailID("ak@gmail.com");
		signUpRequest.setPassword("ak@123");
		signUpRequest.setUserName("akanksha");
		signUpRequest.setUserType("Author");
		
		SignUpResponse signUpResponse = new SignUpResponse();
		UserEntity userEntity = new UserEntity();
		userEntity.setEmailID(signUpRequest.getEmailID());
		userEntity.setPassword(signUpRequest.getPassword());
		userEntity.setUserName(signUpRequest.getUserName());
		userEntity.setUserType(signUpRequest.getUserType());
		userEntity.setUserID(2);
		//when(userRepository.save(userEntity)).thenReturn(userEntity);
		signUpResponse = userServiceImpl.signUp(signUpRequest);
		
		assertNotNull(signUpResponse);
	}
	@Test
	void singInTest() throws Exception{
		SignInRequest signInRequest = new SignInRequest();
		
		signInRequest.setPassword("ak@123");
		signInRequest.setUserName("akanksha");
				
		SignInResponse signInResponse = new SignInResponse();
		UserEntity userEntity = new UserEntity();
		
		userEntity.setPassword(signInRequest.getPassword());
		userEntity.setUserName(signInRequest.getUserName());
		userEntity.setUserID(2);
		//when(userRepository.save(userEntity)).thenReturn(userEntity);
		signInResponse = userServiceImpl.signIn(signInRequest);
		
		assertNotNull(signInResponse);
	}
	@Test
	void singIn1Test() throws Exception{
		SignInRequest signInRequest = new SignInRequest();
		
		signInRequest.setPassword("ak@123");
		signInRequest.setUserName("akanksha");
				
		SignInResponse signInResponse = new SignInResponse();
		UserEntity userEntity = new UserEntity();
		
		userEntity.setPassword(signInRequest.getPassword());
		userEntity.setUserName(signInRequest.getUserName());
		userEntity.setUserID(2);
		when(userRepository.save(userEntity)).thenReturn(userEntity);
		signInResponse = userServiceImpl.signIn(signInRequest);
		
		assertNotNull(signInResponse);
	}
	
	@Test
	void bookResponseTest() {
		CreatesBookResponse createsBookResponse = new CreatesBookResponse();
		CreatesBookRequest createsBookRequest = new CreatesBookRequest();
		Book book = new Book();
		createsBookRequest.setBook(book);
		createsBookRequest.setUserID(1);
		
		
		createsBookResponse = userServiceImpl.bookResponse(createsBookRequest);
		assertNotNull(createsBookResponse);
	}
	@Test
	void bookResponse1Test() throws Exception{
		CreatesBookResponse createsBookResponse = new CreatesBookResponse();
		CreatesBookRequest createsBookRequest = new CreatesBookRequest();
		UserEntity userEntity = new UserEntity();
		userEntity.setUserType("author");
		BookEntity bookEntity = new BookEntity();
		bookEntity.setBookID(4);
		Optional<BookEntity> optional = Optional.ofNullable(null);
		Optional<UserEntity> optional1 = Optional.of(userEntity);
		Book book = new Book();
		createsBookRequest.setBook(book);
		createsBookRequest.setUserID(1);
		when(userRepository.findById(1)).thenReturn(optional1);
		when(bookRepository.save(bookEntity)).thenReturn(bookEntity);
		
		createsBookResponse = userServiceImpl.bookResponse(createsBookRequest);
		assertNotNull(createsBookResponse);
	}
	@Test
	void bookResponseInvalidTest() throws Exception{
		CreatesBookResponse createsBookResponse = new CreatesBookResponse();
		CreatesBookRequest createsBookRequest = new CreatesBookRequest();
		UserEntity userEntity = new UserEntity();
		userEntity.setUserType("author");
		Optional<BookEntity> optional = Optional.ofNullable(null);
		Optional<UserEntity> optional1 = Optional.of(userEntity);
		Book book = new Book();
		createsBookRequest.setBook(book);
		createsBookRequest.setUserID(1);
		when(userRepository.findById(1)).thenReturn(optional1);
		//when(bookRepository.save(bookEntity)).thenReturn(bookEntity);
		
		createsBookResponse = userServiceImpl.bookResponse(createsBookRequest);
		assertNotNull(createsBookResponse);
	}
	
	@Test
	void editBookTest() throws Exception{
		EditBookResponse editBookResponse = new EditBookResponse();
		EditBookRequest editBookRequest = new EditBookRequest();
		UserEntity userEntity = new UserEntity();
		userEntity.setUserType("author");
		Optional<BookEntity> optional = Optional.ofNullable(null);
		Optional<UserEntity> optional1 = Optional.of(userEntity);
		Book book = new Book();
		editBookRequest.setBook(book);
		editBookRequest.setBookID(4);
		editBookRequest.setUserID(1);
		when(userRepository.findById(1)).thenReturn(optional1);
		//when(bookRepository.save(bookEntity)).thenReturn(bookEntity);
		
		editBookResponse = userServiceImpl.editBook(editBookRequest);
		assertNotNull(editBookResponse);
	}
	@Test
	void editBookInvalidTest() throws Exception{
		EditBookResponse editBookResponse = new EditBookResponse();
		EditBookRequest editBookRequest = new EditBookRequest();
		UserEntity userEntity = new UserEntity();
		userEntity.setUserType("author");
		Optional<BookEntity> optional = Optional.ofNullable(null);
		Optional<UserEntity> optional1 = Optional.of(userEntity);
		Book book = new Book();
		editBookRequest.setBook(book);
		editBookRequest.setBookID(4);
		editBookRequest.setUserID(1);
		//when(userRepository.findById(1)).thenReturn(optional1);
		//when(bookRepository.save(bookEntity)).thenReturn(bookEntity);
		
		editBookResponse = userServiceImpl.editBook(editBookRequest);
		assertNotNull(editBookResponse);
	}
	@Test
	void editBook1Test() throws Exception{
		EditBookResponse editBookResponse = new EditBookResponse();
		EditBookRequest editBookRequest = new EditBookRequest();
		UserEntity userEntity = new UserEntity();
		BookEntity bookEntity = new BookEntity();
		userEntity.setUserType("author");
		Optional<BookEntity> optional = Optional.of(bookEntity);
		Optional<UserEntity> optional1 = Optional.of(userEntity);
		Book book = new Book();
		editBookRequest.setBook(book);
		editBookRequest.setBookID(4);
		editBookRequest.setUserID(1);
		when(userRepository.findById(1)).thenReturn(optional1);
		when(bookRepository.findById(4)).thenReturn(optional);
		
		editBookResponse = userServiceImpl.editBook(editBookRequest);
		assertNotNull(editBookResponse);
	}

}
