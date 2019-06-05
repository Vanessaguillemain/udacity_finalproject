package com.example.android.jokeprovider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class JokeProvider {

    private static JokeProvider INSTANCE = new JokeProvider();
    /** Access point for singleton instance */
    public static JokeProvider getInstance()
    {   return INSTANCE;
    }
    private Random random;
    private int randInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
    public String getJoke() {
        return jokes.get(randInt(0, jokes.size() - 1));
    }
    private List<String> jokes;
    private JokeProvider() {
        random = new Random();
        jokes = new ArrayList<>();
        jokes.add("Teacher asked the students to tell the most common word used by students in a classroom.\n" +
                "Suddenly a student got up and said “Can’t Sir”!\n" +
                "Brilliant! You are right, the teacher said!");
        jokes.add("Johnny asked to Sam what they will do that night.\n" +
                "Sam said “we will flip a coin”\n" +
                "Then Johnny said “If it comes head, we will go for movies. If tails, we will play cards, if it stands on edge, we will study”!");
        jokes.add("There are 10 types of people in the world: those who understand binary, and those who don't.");
        jokes.add("Why is it that programmers always confuse Halloween with Christmas? \n" +
                "Because 31 OCT = 25 DEC");
    }
}
