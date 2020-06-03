package spring.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "User_reg")
public class UserReg implements Serializable {

    @Id
    @Column(name = "User_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Column(name = "User_Email")
    private String userEmail;

    @Column(name = "User_Password")
    private String userPassword;

    @Column(name = "User_Nickname")
    private String userNickname;

//    @OneToOne(mappedBy = "userReg")
//    private Info info;

//    public Info getInfo() {
//        return info;
//    }
//
//    public void setInfo(Info info) {
//        this.info = info;
//    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserReg userReg = (UserReg) o;
        return Objects.equals(userId, userReg.userId) &&
                Objects.equals(userEmail, userReg.userEmail) &&
                Objects.equals(userPassword, userReg.userPassword) &&
                Objects.equals(userNickname, userReg.userNickname);
//                Objects.equals(info, userReg.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userEmail, userPassword, userNickname);
    }
}
