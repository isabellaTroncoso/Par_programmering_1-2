package com.pariprogrammering.exercise.diamond;

public class Pyramid {
    public static void main(String[] args) {
        ////////////////Diamond/////////////////
        String stars = "";

        for (int i = 0; i < 3; i++) {

            stars = stars.concat("*");
            System.out.println(stars);

        }

        for (int j = 2; j > 0; j--) {
            stars = stars.substring(0, j);
            System.out.println(stars);

        }
    }
}
