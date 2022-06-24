package com.ysl.rabbitmq.utility;

import com.ysl.rabbitmq.dao.UserRepo;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class UserGenerator {
    private static Random rand;

    static {
        try {
            rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }



    static final String[] firstNameArray = new String[]{"Adam", "Alex", "Aaron", "Ben", "Carl", "Dan"};
    static final String[] lastNameArray = new String[]{"Anderson", "Ashwoon", "Aikin", "Bateman", "Bongard", "Bowers"};


    public static String generateFirstName() {
        int fName = rand.nextInt(firstNameArray.length);
        return firstNameArray[fName];
    }
    public static String generateLastName() {
        int lName =rand.nextInt(lastNameArray.length);
        return lastNameArray[lName];

    }
    public static String generateEmail(String firstName,String lastName) {
        return (firstName.toLowerCase() + "." + lastName.toLowerCase() + "@mail.com");
    }







}
