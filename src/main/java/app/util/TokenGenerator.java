package app.util;

import java.security.SecureRandom;

public class TokenGenerator {

    protected static SecureRandom random = new SecureRandom();

    public synchronized String generateToken( String username ) {
        long longToken = Math.abs( random.nextLong() );
        String random = Long.toString( longToken, 32 );
        return ( username + ":" + random );
    }
/*
    public static void main(String a[]){
        TokenGenerator obj=new TokenGenerator();
        System.out.println(obj.generateToken("https://www.google.com"));

    }*/
}