package net.milestone1.paytm.userREST;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService service;
	
//READ all the users data in one go	//
	
	@GetMapping("/users")
	public List<User> list(){
		return service.getUsers();
	}

//READ the user data by ID//
	
	@GetMapping("/user/{id}")
	public User get(@PathVariable Integer id) {
		return service.get(id);
	}

//CREATE the user row for the table//
	
	@PostMapping("/user")
	public String create(@RequestBody User user) {
		List<User> email_id=service.findByEmailID(user.getEmailID());
		List<User> user_name=service.findbyUserName(user.getUserName());
		List<User> phone_number=service.findbyMobileNumber(user.getMobileNumber());
		
		if(!email_id.isEmpty()) {
			return "user already exists with same emailId";
		}
			
			
		else if(!user_name.isEmpty()){
			return "user already exists with same userName";
		}
		
		else if(!phone_number.isEmpty())
		{
			return "user already exists with similar phoneNumber";
		}
		else {
		service.save(user);
		return "new user accepted";
		}
	}
	
//UPDATE the user data//
	
	@PutMapping("/user/{id}")
	//ResponseEntity<> uses Http requests to reflect back to the browser
	
	public ResponseEntity<?> update(@RequestBody User user,@PathVariable Integer id) {
		try {
		User userAlreadyExists=service.get(id);
		 service.save(user);
		 return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}catch(NoSuchElementException e) {
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*@RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
	public HttpStatus update(@RequestBody User user, @PathVariable Integer id) {
		return service.update(user)?HttpStatus.ACCEPTED:HttpStatus.NOT_FOUND;
	}*/
	
//DELETE the user data//
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> delete(@RequestBody User user,@PathVariable Integer id) {
		try {
			User userAlreadyExists =service.get(id);
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}catch(NoSuchElementException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
