package com.exercise;

import com.exercise.random.RandomGenerate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        RandomGenerate rg = new RandomGenerate("You are nice");
        RandomGenerate rg2 = new RandomGenerate("You are beautiful");

        List<RandomGenerate> randomGenerates = new ArrayList<>();
        randomGenerates.add(rg);
        randomGenerates.add(rg2);
        System.out.println(randomGenerates.get(
                random.nextInt(0,1))
        );





    }

















}
