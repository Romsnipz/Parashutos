package spring.hibernate.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.DTOs.InfoHTTPPojo;
import spring.hibernate.entity.Info;
import spring.hibernate.repository.InfoRepository;

import java.util.Date;

@Component
@Transactional
public class InfoDao {

    @Autowired
    private InfoRepository infoRepository;

    public InfoDao(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public Info save(InfoHTTPPojo infoedit) {
        Info info = infoRepository.findByuserNickname(infoedit.getUserNickname());
        info.setSurName(infoedit.getSurName());
        info.setFirstName(infoedit.getFirstName());
        info.setSecondName(infoedit.getSecondName());
        info.setBirthday(infoedit.getBirthday() != null ? new Date(infoedit.getBirthday()) : null);
        info.setCity(infoedit.getCity());
        info.setDropzone(infoedit.getDropzone());

        return infoRepository.save(info);
    }

    public Info getInfoByNickname (String userNickname) {
        return infoRepository.findByuserNickname(userNickname);
    }
}
