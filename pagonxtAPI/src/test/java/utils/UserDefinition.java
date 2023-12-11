package utils;

import pojo.UserPojo;

public class UserDefinition {


    public UserPojo fillUser(){

        UserPojo user = new UserPojo();

        user.setName("Thwkz");
        user.setJob("Barbarian");

        return user;
    }
}
