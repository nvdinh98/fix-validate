package com.codegym.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Component
public class User implements Validator {
//    @NotEmpty
//    @Size(min = 5,max = 45)
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
//    @Min(18)
    private int age;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String firstName =user.getFirstName();
        String lastName = user.getLastName();
        String phoneNumber = user.getPhoneNumber();
        String email = user.getEmail();
        int age = user.getAge();
        ValidationUtils.rejectIfEmpty(errors,"firstName","firstName.empty");
        ValidationUtils.rejectIfEmpty(errors,"lastName","lastName.empty");
//        ValidationUtils.rejectIfEmpty(errors,"phoneNumber","phoneNumber.empty");
//        ValidationUtils.rejectIfEmpty(errors,"email","email.empty");
//        ValidationUtils.rejectIfEmpty(errors,"age","age.empty");
        if (firstName.length() < 5 || firstName.length() > 45){
            errors.rejectValue("firstName","firstName.length");
        }
        if (lastName.length() < 5 || lastName.length() > 45){
            errors.rejectValue("lastName","lastName.length");
        }
//        if (!phoneNumber.startsWith("0")){
//            errors.rejectValue("phoneNumber","phoneNUmber.startWish");
//        }
//        if (!phoneNumber.matches("(^$|[0-9]*$)")){
//            errors.rejectValue("phoneNumber", "phoneNumber.matches");
//        }
//        if (!email.matches("(randomString)@(randomString2).(2-3 characters)")) {
//        errors.rejectValue("email","email.matches");
//        }
//        if (age <18 ){
//            errors.rejectValue("age","age.min");
//        }

    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }


}
