package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.DTOs.InfoHTTPPojo;
import spring.DTOs.LoginPair;
import spring.DTOs.UserHTTPPojo;
import spring.LoginStatusEnum;
import spring.hibernate.Dao.InfoDao;
import spring.hibernate.Dao.UserDao;
import spring.hibernate.entity.Info;
import spring.hibernate.entity.UserReg;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientService {

    @Autowired
    public UserDao userDao;

    @Autowired
    public InfoDao infoDao;

    public ClientService(UserDao userDao) {
        this.userDao = userDao;
    }

    public LoginPair registerUser(UserHTTPPojo userRequest) {
        UserReg userReg;
        try {
            userReg = userDao.save(userRequest);
            return doLogin(userRequest.getUserNickname(), userRequest.getUserPassword());
        } catch (Exception e) {
            return null;
        }
    }

    public boolean saveInfo(InfoHTTPPojo userRequest) {
        Info info;
        try {
            info = infoDao.save(userRequest);
            return info != null ? true : false;
        } catch (Exception e) {
            return false;
        }
    }

    public String getAllClients() {
        List<UserReg> users = userDao.getAll();
        return users.toString();
    }

    public LoginPair doLogin(String userEmail, String userPassword) {
        LoginPair loginPair = new LoginPair();

        UserReg userReg = null;
        try {
            userReg = userDao.getClientByUserEmailAndUserPassword(userEmail, userPassword);

            if (userReg == null) {
                userReg = userDao.getClientByLogin(userEmail);

                LoginStatusEnum status = userReg != null
                        ? LoginStatusEnum.INCORRECT_PASSWORD
                        : LoginStatusEnum.CLIENT_NOT_FOUND;
                loginPair.setStatus(status.getStatus());

                return loginPair;
            } else {
                loginPair.setStatus(LoginStatusEnum.SUCCES.getStatus());

                UserHTTPPojo userHTTPPojo = new UserHTTPPojo();
                userHTTPPojo.setUserEmail(userReg.getUserEmail());
                userHTTPPojo.setUserNickname(userReg.getUserNickname());
                userHTTPPojo.setUserPassword(userReg.getUserPassword());

                InfoHTTPPojo infoHTTPPojo = new InfoHTTPPojo();
                Info info = infoDao.getInfoByNickname(userReg.getUserNickname());
                infoHTTPPojo.setUserNickname(info.getUserNickname());
                infoHTTPPojo.setSurName(info.getSurName());
                infoHTTPPojo.setFirstName(info.getFirstName());
                infoHTTPPojo.setSecondName(info.getSecondName());
                infoHTTPPojo.setBirthday(info.getBirthday() == null ? null : info.getBirthday().getTime());
                infoHTTPPojo.setCity(info.getCity());
                infoHTTPPojo.setDropzone(info.getDropzone());
                infoHTTPPojo.setQuantity(info.getQuantity());

                loginPair.setClient(userHTTPPojo);
                loginPair.setInfo(infoHTTPPojo);

                return loginPair;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return loginPair;
        }
    }

}
