package com.gm.dsy.utils;

import java.util.Random;

public class StringUtils {
    public static String getRandomString(int length){
        String base="abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuffer sb=new StringBuffer();
        Random random=new Random();
        for (int i=0;i<length;i++){
            int pos=random.nextInt(base.length());
            sb.append(base.charAt(pos));
        }
        return sb.toString();
    }
}
