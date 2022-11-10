package com.codeup.adlister.controllers;

import org.mindrot.jbcrypt.BCrypt;

public class HashTest {
    public static void main(String[] args) {
        // password to hash
        String password = "codeytheduck";
        // hashed password
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        // print hash to store in DB to manually insert a user.
        System.out.println(hash);
    }
}
