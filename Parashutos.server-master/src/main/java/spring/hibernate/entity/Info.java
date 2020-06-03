package spring.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Information")
public class Info implements Serializable {

    @Id
    @Column(name = "User_Nickname")
    private String userNickname;
//    @OneToOne
//    @JoinColumn(name = "User_Nickname")
//    private UserReg userReg;

    @Column(name = "SurName")
    private String surName;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "SecondName")
    private String secondName;

    @Column(name = "Birthday")
    private Date birthday;

    @Column(name = "City")
    private String city;

    @Column(name = "Dropzone")
    private String dropzone;

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    //    public UserReg getUserReg() {
//        return userReg;
//    }
//
//    public void setUserReg(UserReg userReg) {
//        this.userReg = userReg;
//    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDropzone() {
        return dropzone;
    }

    public void setDropzone(String dropzone) {
        this.dropzone = dropzone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return Objects.equals(userNickname, info.userNickname) &&
                Objects.equals(surName, info.surName) &&
                Objects.equals(firstName, info.firstName) &&
                Objects.equals(secondName, info.secondName) &&
                Objects.equals(birthday, info.birthday) &&
                Objects.equals(city, info.city) &&
                Objects.equals(dropzone, info.dropzone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userNickname, surName, firstName, secondName, birthday, city, dropzone);
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Info info = (Info) o;
//        return Objects.equals(userReg, info.userReg) &&
//                Objects.equals(surName, info.surName) &&
//                Objects.equals(firstName, info.firstName) &&
//                Objects.equals(secondName, info.secondName) &&
//                Objects.equals(birthday, info.birthday) &&
//                Objects.equals(city, info.city) &&
//                Objects.equals(dropzone, info.dropzone);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(userReg, surName, firstName, secondName, birthday, city, dropzone);
//    }
}

