package com.company;

import java.util.Random;
import java.util.Timer;

public class Customer extends Simulation{

    String CallTopic;
    int CustomerID;
    int CallTopicTime = 300;
    float patienceTime = 300;

    void Waiting (){
        if (patienceTime == 0){
            QueueLL(this);
            totalMissedCall++;
        }
    }
    void TakingServe(){

    }

    void Randomize(){
        Random rand = new Random();
        patienceTime = RoundNumber((Math.random()*(patienceTime*4 - patienceTime/4) + patienceTime/4));
    }
}



