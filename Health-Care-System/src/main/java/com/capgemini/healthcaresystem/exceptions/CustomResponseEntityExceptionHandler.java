package com.capgemini.healthcaresystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
		
	@ExceptionHandler
		public final ResponseEntity<Object> handleDiagnosticCenterIDException(DiagnosticCenterIDException ex,
				WebRequest request){
			DiagnosticCenterIDExceptionResponse exceptionResponse=new DiagnosticCenterIDExceptionResponse(ex.getMessage());
			return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
			
		}
	@ExceptionHandler
		public final ResponseEntity<Object> handleDiagnosticCenterNameException(DiagnosticCenterNameException ex,
				WebRequest request){
			DiagnosticCenterNameExceptionResponse exceptionResponse=new DiagnosticCenterNameExceptionResponse(ex.getMessage());
			return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
			
		}
		
		@ExceptionHandler
		public final ResponseEntity<Object> handlePatientIDException(NameException ex, WebRequest request) {
			NameExceptionResponse exceptionResponse = new NameExceptionResponse(ex.getMessage());
			return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);

		}

		@ExceptionHandler
		public final ResponseEntity<Object> handleUsernameException(UsernameException ex, WebRequest request) {
			UsernameExceptionResponse exceptionResponse = new UsernameExceptionResponse(ex.getMessage());
			return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);

		}
		
		@ExceptionHandler
		public final ResponseEntity<Object> handleAppointmentIDException(AppointmentIDException ex, WebRequest request){
			AppointmentIDExceptionResponse exceptionResponse = new AppointmentIDExceptionResponse(ex.getMessage());
			return new  ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler
		public final ResponseEntity<Object> handleTestResultIDException(TestResultIdException ex, WebRequest request){
			TestResultIdExceptionResponse exceptionResponse =  new TestResultIdExceptionResponse(ex.getMessage());
			return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
			
		}
		
		@ExceptionHandler
		public final ResponseEntity<Object> handleDiagnosticTestNameException(DiagnosticTestNameException e,
				WebRequest request){
			DiagnosticTestNameExceptionResponse exceptionResponse=new DiagnosticTestNameExceptionResponse(e.getMessage());
			return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
			
		}
		
		@ExceptionHandler
		public final ResponseEntity<Object> handleCenterIdNullException(CenterIdNullException e,
				WebRequest request){
			CenterIdNullExceptionResponse exceptionResponse=new CenterIdNullExceptionResponse(e.getMessage());
			return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
			
		}



}
