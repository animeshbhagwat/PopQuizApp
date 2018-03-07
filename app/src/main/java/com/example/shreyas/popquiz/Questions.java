package com.example.shreyas.popquiz;

/**
 * Created by Shreyas on 03-03-2018.
 */

public class Questions {
    public String nQuestions[] ={
            "A sum of money at simple interest amounts to Rs. 815 in 3 years and to Rs. 854 in 4 years. The sum is:",
            "A sum of Rs. 12,500 amounts to Rs. 15,500 in 4 years at the rate of simple interest. What is the rate of interest?",
            "The cost price of 20 articles is the same as the selling price of x articles. If the profit is 25%, then the value of x is:",
            "A shopkeeper expects a gain of 22.5% on his cost price. If in a week, his sale was of Rs. 392, what was his profit?",
            "A vendor bought toffees at 6 for a rupee. How many for a rupee must he sell to gain 20%?"

    };

    public String nChoices[][] ={
            {"Rs.650","Rs.690","Rs.698","Rs.700"},
            {"3%","4%","5%","6%"},
            {"15","16","18","25"},
            {"Rs.18.20","Rs.70","Rs.72","Rs.88.25"},
            {"3","4","5","6"},

    };

    private String nAnswers[] ={"Rs.698","6%","16","Rs.72","5"};

    public String getQuestion (int a){
        String Question = nQuestions[a];
        return Question;
}
    public String getChoice1 (int a){
    String choice = nChoices [a][0];
    return choice;
    }

    public String getChoice2 (int a){
        String choice = nChoices [a][1];
        return choice;
    }

    public String getChoice3 (int a){
        String choice = nChoices [a][2];
        return choice;
    }

    public String getChoice4 (int a){
        String choice = nChoices [a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String Answers = nAnswers[a];
        return Answers;
    }
}
