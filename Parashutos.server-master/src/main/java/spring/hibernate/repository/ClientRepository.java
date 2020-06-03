package spring.hibernate.repository;

import org.springframework.data.repository.CrudRepository;
import spring.hibernate.entity.UserReg;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends CrudRepository<UserReg, Integer> {

    public UserReg save(UserReg user);

    public List<UserReg> findAll();

    UserReg findByUserEmail(@Param("User_Email") String userEmail);

    UserReg findByUserEmailAndUserPassword(@Param("User_Email") String userEmail, @Param("User_Password") String userPassword);
}
