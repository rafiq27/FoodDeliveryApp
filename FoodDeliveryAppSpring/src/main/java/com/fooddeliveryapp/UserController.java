package com.fooddeliveryapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
		
		@Autowired
		UserRepository userRep;
		
		@GetMapping(value="/hello")
		public String hello(@RequestParam(defaultValue ="test") String param1)
		{
			return String.format("welcome to spring boot %s", param1);
		}
		
		@RequestMapping(value = "/createuser",method=RequestMethod.POST, headers = "Accept=application/json"  )
		public User createuser(@RequestBody User usr) {
			User usr1  = new User();
			usr1.setName(usr.getName());
			usr1.setEmail(usr.getEmail());
			usr1.setId(usr.getId());
			userRep.save(usr1);
			return usr1;
	}
	}
}
