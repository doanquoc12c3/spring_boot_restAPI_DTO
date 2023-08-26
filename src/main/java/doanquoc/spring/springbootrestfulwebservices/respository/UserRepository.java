package doanquoc.spring.springbootrestfulwebservices.respository;

import doanquoc.spring.springbootrestfulwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
