package spring.hibernate.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.DTOs.UserHTTPPojo;
import spring.hibernate.entity.UserReg;
import spring.hibernate.entity.Info;
import spring.hibernate.repository.ClientRepository;

import java.util.List;

@Component
@Transactional
public class UserDao {

    @Autowired
    private ClientRepository clientRepository;

    public UserDao(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public UserReg save(UserHTTPPojo userDto) throws Exception {
        UserReg userReg = new UserReg();
        userReg.setUserEmail(userDto.getUserEmail());
        userReg.setUserNickname(userDto.getUserNickname());
        userReg.setUserPassword(userDto.getUserPassword());

        Info info = new Info();
//        userReg.setInfo(info);

        return clientRepository.save(userReg);
    }

    public List<UserReg> getAll() {
        return clientRepository.findAll();
    }

    public UserReg getClientByLogin(String userEmail) throws Exception {
        return clientRepository.findByUserEmail(userEmail);
    }

    public UserReg getClientByUserEmailAndUserPassword(String userEmail, String userPassword) throws Exception {
        return clientRepository.findByUserEmailAndUserPassword(userEmail, userPassword);
    }

}
