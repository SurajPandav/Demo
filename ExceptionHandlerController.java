package springmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


//centralized exception handling which allow us to handle exception on all controllers in a project 
// using @ContollerAdvice annotation
@ControllerAdvice
public class ExceptionHandlerController {

	
//	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(value=NullPointerException.class)
//	public String exceptionHandlerNull() {
//
//		return "Exception_page";
//	}
	
	
//	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(value=NumberFormatException.class)
//	public String exceptionHandlerNumFormat(Model m) {
//        m.addAttribute("msg","Number format exception has occured"); //can print custom msg from server
//		return "Exception_page";
//	}
	
	
	//for all type of exception
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=Exception.class)
	public String exceptionHandlergeneric(Model m) {
        m.addAttribute("msg","exception has occured"); //can print custom msg from server
		return "Exception_page";
	}
}
