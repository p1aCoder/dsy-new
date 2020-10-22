package com.gm.dsy;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;

public class test {
    public static void main(String[] args) {
        System.out.println(new SecureRandomNumberGenerator().nextBytes());
    }
}
