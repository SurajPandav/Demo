package springmvc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("home url");
		model.addAttribute("name", "suraj");

		model.addAttribute("id", 5);                      //Model concept
                                                       //here we have used Model to send data to view page i.e from controller to view
		List<String> phone = new ArrayList<String>();
		phone.add("9635840");
		phone.add("8888888");
		phone.add("777777");
		phone.add("99999");

		model.addAttribute("ph", phone);
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		
		//String str=null;
		//System.out.println(str.length());
		System.out.println("about url");
		return "about";
	}

	@RequestMapping("/help")
	public ModelAndView help() {
		System.out.println("help url");
		ModelAndView modelandview = new ModelAndView();

		modelandview.addObject("helpline", "need help");
		modelandview.addObject("no", 9435698);
                                                             //ModelAndView concept
		LocalDateTime now = LocalDateTime.now();             //here we have used ModelAndView to send data to view page i.e from controller to view

		modelandview.addObject("time", now);

		Date date = new Date();
		modelandview.addObject("date", date);

		modelandview.setViewName("help");

		return modelandview;
	}
	
	@RequestMapping("/service")
	public ModelAndView service() {
		System.out.println("service url");
		ModelAndView modelandview = new ModelAndView();

		modelandview.addObject("serve", "Service Team");
		modelandview.addObject("id", 9435698);
                                                             //ModelAndView concept
		LocalDateTime now = LocalDateTime.now();             //here we have used ModelAndView to send data to view page i.e from controller to view

		modelandview.addObject("time", now);

		Date date = new Date();
		modelandview.addObject("date", date);
		
		
		List<Integer> phone = new ArrayList<Integer>();
		phone.add(5555555);
		phone.add(111111);
		phone.add(888888);
		phone.add(4444444);
		
		modelandview.addObject("ph",phone);

		modelandview.setViewName("service");

		return modelandview;
	}
	
	

}