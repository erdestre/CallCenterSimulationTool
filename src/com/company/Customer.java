package com.company;

import java.util.Timer;

public class Customer extends Simulation{

    CallTopics callTopic;
    Timer timer = new Timer();
    float patienceTime;

    void Waiting (){
        if (timer.equals(0)){
            queue.remove(this);
            totalMissedCall++;
        }
    }
    void Speaking(){
        if (timer.equals(0)){
            servedCustomers++;
        }
    }
}

class CallTopics {
    static String[] callTopics;
    Float[] ServeTimeForTopics;
}



