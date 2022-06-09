package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Simulation extends Simulator {
    //Start
    long simulationStartTime;
    long simulationEndTime;
    float averageResponseTime;
    Employee[] employees;

    //Next

    //LinkedList<Customer> Queue = new LinkedList();
    Queue<Customer> queue = new LinkedList<Customer>() {
    };
    Queue<Integer> avaliableEmployees = new LinkedList<Integer>();

    Random rand = new Random();

    //Result
    int totalMissedCall = 0;
    int servedCustomers = 0;
    int[] whichTopicsCame = new int[CallTopics.callTopics.length-1];


    public void SetValues(long simulationStartTime, long simulationEndTime, int employeeCount, float averageResponseTime){
        this.simulationStartTime = simulationStartTime;
        this.simulationEndTime = simulationEndTime;
        this.averageResponseTime = averageResponseTime;
        employees = new Employee[employeeCount];

        for(int i = 0; i<employeeCount; i++){
            employees[i].GetValues(this, i, averageResponseTime); //Have to change averageResponseTime.
        }
    }

    private void CustomerCame(Customer customer){

        queue.add(customer);
    };

    private void CheckRedirectisAvaliable(){
        if(!avaliableEmployees.isEmpty() && !queue.isEmpty()) {
            employees[avaliableEmployees.peek()].isAvaliable = false;
            avaliableEmployees.remove();
            ServeCustomer(employees[avaliableEmployees.peek()], queue.peek());
        }
    }

    private void ServeCustomer(Employee employee, Customer customer){

        employee.Serving();
        customer.Speaking();
    }
};


