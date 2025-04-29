package com.pariprogrammering.exercise.diamond.random;

public class RandomGenerate {
    String compliment;

    public RandomGenerate(String compliment) {
        this.compliment = compliment;
    }

    public String getCompliment() {
        return compliment;
    }

    public void setCompliment(String compliment) {
        this.compliment = compliment;
    }

    @Override
    public String toString() {
        return "RandomGenerate{" +
                "compliment='" + compliment + '\'' +
                '}';
    }
}
