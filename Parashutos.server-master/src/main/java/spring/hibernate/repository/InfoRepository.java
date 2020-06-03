package spring.hibernate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import spring.hibernate.entity.Info;

public interface InfoRepository extends CrudRepository<Info, String> {

    public Info save(Info info);

    Info findByuserNickname(@Param("User_Nickname") String userNickname);

}
