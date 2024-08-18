package springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.User;

@Controller
public class ContactController {

	@RequestMapping("/contact")
	public String showForm() {

//		String str="hello";
//		Integer.parseInt(str);     // uncomment when want to see exception handling 
//		System.out.print(str.length());
		
		return "contact";
	}
	
	
	@RequestMapping("/contact/{id}")
	public String showForm(@PathVariable("id") int userid) {
                            // @PathVariable annotation is used to bind method parameter to URI template variable
		System.out.println(userid);
		return "contact";
	}

	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String processform(@RequestParam("email") String useremail, @RequestParam("username") String name,
			@RequestParam("password") String pass, Model model) 
	{
//RequestParam is used to get data from "view to controller"
		
		model.addAttribute("email",useremail);
		model.addAttribute("username",name);     //here we are sending data from controller to view i.e on success.jsp page
		model.addAttribute("password",pass);
		System.out.println(useremail);

		return "success";
	}
	
	@RequestMapping("/profile")
	public String profile() {

		return "profile";
	}
	
	
	@RequestMapping(path = "/profileform", method = RequestMethod.POST)
	public String profileform(@ModelAttribute User user,Model model) 
	{
		//ModelAttribute is used to get data from "view to controller"
		
		

		
		model.addAttribute("user",user);
		
		System.out.println(user);
		

		return "profileinfo";
	}
	
	//Exception handling
	
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
//	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(value=Exception.class)
//	public String exceptionHandlergeneric(Model m) {
//        m.addAttribute("msg","exception has occured"); //can print custom msg from server
//		return "Exception_page";
//	}
	

}
