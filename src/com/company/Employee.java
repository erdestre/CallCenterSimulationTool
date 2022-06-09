package com.company;

public class Employee extends Simulation {

    float responseTime;
    int employeeId;
    boolean isAvaliable;

    //Timer timer = new Timer();

    void GetValues(Simulation simulation, int employeeId, float responseTime){

        this.employeeId = employeeId;
        this.responseTime = responseTime;
    }

    void Serving (){ //Timer'a bakılması lazım.
        if (/*timerWillBeHere*/true){
            isAvaliable = true;
            avaliableEmployees.add(employeeId);
        }
    }
}
