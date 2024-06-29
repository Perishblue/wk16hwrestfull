package com.restfull;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class Utils
{
    public static String getRandomValue(){
        Random random = new Random();
        int randomInt = random.nextInt(100000);
        return Integer.toString(randomInt);
    }
}
