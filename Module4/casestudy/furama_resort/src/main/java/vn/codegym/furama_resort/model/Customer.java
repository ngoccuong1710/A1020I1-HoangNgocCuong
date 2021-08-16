package vn.codegym.furama_resort.model;

import vn.codegym.furama_resort.validate.DateOfBirth;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
public class Customer {
    @Id
    private String customerId;

    @NotBlank
    private String name;

    @NotEmpty
    @DateOfBirth
    private String birthday;

    private Integer gender;

    @NotBlank
    @Pattern(regexp = "^[0-9]{9}$",message = "Số CMND phải đúng định dạng XXXXXXXXX .")
    private String idCard;

    @NotBlank
    @Pattern(regexp = "^((091)|(090))[0-9]{7}$",message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx")
    private String phone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String address;

    @ManyToOne
    @JoinColumn(name = "customerTypeId", referencedColumnName = "customerTypeId", nullable = false)
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Contract> contracts;

    public Customer() {

    }

    public Customer(String customerId, String name, String birthday, Integer gender, String idCard, String phone, String email, String address, CustomerType customerType) {
        this.customerId = customerId;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public Customer(String customerId, String name, String birthday, Integer gender, String idCard, String phone, String email, String address, CustomerType customerType, Set<Contract> contracts) {
        this.customerId = customerId;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contracts = contracts;
    }

    public String getId() {
        return customerId;
    }

    public void setId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
