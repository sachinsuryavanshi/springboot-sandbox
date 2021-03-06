package com.sachin.rest.webservices.restfulwebservices.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
//== Swagger Documentation
@ApiModel(description = "User related information")
public class User {
    // == fields ==
    private Integer id;
    @ApiModelProperty(notes = "Name should have at least 2 Char")
    private String name;
    @ApiModelProperty(notes = "Birth Date should not Past Date")
    private Date birthDate;

    // == Default constructor
    protected User(){}

    // == constructor
    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    // == Override To string method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    // == Getter & Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
