package POJO;

import java.util.Date;

 public class SinhVienPOJO {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private Date birthday;
    private String Email;
    private String country;
    private String city;

    public SinhVienPOJO() {}

    public SinhVienPOJO(int id, String firstName, String lastName, String gender, String phoneNumber, Date birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
      
    }

    // Getter và Setter cho từng thuộc tính
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getEmail()
    {
        return Email;
    }
    
     public String getcountry()
    {
        return country;
    }
      public String getCity()
    {
        return city;
    }
}
