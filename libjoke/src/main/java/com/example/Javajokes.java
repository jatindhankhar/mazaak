package com.example;


import java.util.Random;


public class Javajokes {
    // Most of the jokes taken from here http://www.devtopics.com/best-programming-jokes/
    public static String[] Jokes = {
            "To understand what recursion is, you must first understand recursion.",
            "Eight bytes walk into a bar.  The bartender asks, “Can I get you anything?”\n" +
                    "\n" +
                    "“Yeah,” reply the bytes.  “Make us a double.”",
            "How many programmers does it take to change a light bulb?\n" +
                    "None – It’s a hardware problem\n" +
                    "\n",
            "There are three kinds of lies: Lies, damned lies, and benchmarks.\n" +
                    "\n",
            "Two bytes meet.  The first byte asks, “Are you ill?”  \n" +
                    "The second byte replies, “No, just feeling a bit off.”"

    };


    public static String getJoke() {
        Random random = new Random();
        int idx = random.nextInt(Jokes.length);
        return Jokes[idx];
    }
}
