package net.milestone1.paytm.userREST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

//@Transactional annotation indicates that the method will be executed in the transaction.
//Spring will take care of transaction management

public class UserService {
	
	@Autowired
	private UserRepository repo;

//CRUD methods implemented in service class
	
	public List<User> getUsers(){
		return repo.findAll();
	}
	
	public void save(User user) {
		repo.save(user);
	}
	
	public User get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public boolean update(User user) {
		return repo.save(user) != null;
	}

//these three are the validations methods 
//used in service class reverted from repository class
	
	public List<User> findByEmailID(String emailID) {
		return repo.findByEmailID(emailID);
		}

    public List<User> findbyUserName(String userName) {
    	return repo.findByUserName(userName);
    	}

    public List<User> findbyMobileNumber(String mobileNumber) {
        return repo.findByMobileNumber(mobileNumber);
    }

}
