package com.vcriate.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyError> customerException(CustomerException custException,WebRequest req){
		
		MyError myError=new MyError(custException.getMessage(), req.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myError, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(AddressException.class)
	public ResponseEntity<MyError> addressException(AddressException addException,WebRequest req){
		
		MyError myError=new MyError(addException.getMessage(), req.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myError, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyError> loginException(LoginException loginException,WebRequest req){
		
		MyError myError=new MyError(loginException.getMessage(), req.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myError, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(CurrentUserSessionException.class)
	public ResponseEntity<MyError> currentException(CurrentUserSessionException currException,WebRequest req){
		
		MyError myError=new MyError(currException.getMessage(), req.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myError, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(WalletException.class)
	public ResponseEntity<MyError> walletException(WalletException walletException,WebRequest req){
		
		MyError myError=new MyError(walletException.getMessage(), req.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myError, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(TransactionException.class)
	public ResponseEntity<MyError> transactionException(TransactionException tranException,WebRequest req){
		
		MyError myError=new MyError(tranException.getMessage(), req.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myError, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> exception(Exception exception,WebRequest req){
		
		MyError myError=new MyError(exception.getMessage(), req.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myError, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> methodException(MethodArgumentNotValidException validException){
		
		MyError myError=new MyError( validException.getBindingResult().getFieldError().getDefaultMessage(),"validError", LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myError, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyError> noException(NoHandlerFoundException noException,WebRequest req){
		
		MyError myError=new MyError(noException.getMessage(), req.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myError, HttpStatus.BAD_REQUEST);
	}
	
}
