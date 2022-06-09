package com.company;

import java.util.Random;

public class Employee extends Simulation {

    int employeeId;
    double responseTimeMultiplier;
    boolean isAvaliable;

    int CurrentTaskResponseTime;

    void GetValues(int employeeId, float responseTimeMultiplier){

        this.employeeId = employeeId;
        this.responseTimeMultiplier = responseTimeMultiplier;
    }

    void StartServe(Customer customer){
        isAvaliable = false;
        AddServingEmployeesLL(employeeId);

        CurrentTaskResponseTime = RoundNumber(responseTimeMultiplier*customer.CallTopicTime);
    }
    void Serving (){ //Timer'a bakılması lazım.

        if(CurrentTaskResponseTime >= 0){
            CurrentTaskResponseTime--;

        }
        else {
            AddAvaliableEmployeesLL(employeeId);
            RemoveServingEmployeesLL(employeeId);
            isAvaliable = true;
            servedCustomers++;
        }
    }
    void Randomize(){
        Random rand = new Random();
        responseTimeMultiplier = (Math.random() + 0.5);
    }
}
