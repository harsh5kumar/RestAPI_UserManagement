package net.milestone1.paytm.userREST;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//By inheriting from JpaRepository or CrudRepository, we can call 
//many methods without the need to implement them ourself

public interface UserRepository extends JpaRepository<User, Integer> {

	
//these are the validations method defined by user in repository
	
	public List<User> findByEmailID(String emailID);

    public List<User> findByUserName(String userName);

    public List<User> findByMobileNumber(String mobileNumber);

}
