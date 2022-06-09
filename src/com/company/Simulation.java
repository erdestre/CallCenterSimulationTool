package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Simulation extends Simulator {
    //Start
    int simulationCurrentTime;
    int simulationEndTime;
    float averageResponseTime;
    float averageCustomerNumber;
    Employee[] employees;
boolean adana = false;
    double CustomerArrivalInterval = 0;


    //Next
    int customerWillArriveInSeconds = 0;
    int howManyCustomerWillArriveInSeconds = 0;

    LinkedList<Customer> queue = new LinkedList<Customer>() {
    };
    LinkedList<Integer> avaliableEmployees = new LinkedList<Integer>();
    LinkedList<Integer> ServingEmployees = new LinkedList<Integer>();;


    //Result
    int totalMissedCall = 0;
    int servedCustomers = 0;

    public void SetValues(int simulationStartTime, int simulationEndTime, int employeeCount, float averageResponseTime, int averageCustomerNumber, String[] CallTopics){
        simulationCurrentTime = simulationStartTime;
        this.simulationEndTime = simulationEndTime;
        this.averageResponseTime = averageResponseTime;
        this.averageCustomerNumber = averageCustomerNumber;
        employees = new Employee[employeeCount];
        for(int i = 0; i<employeeCount; i++){
            employees[i] = new Employee();
            employees[i].GetValues(i, this.averageResponseTime); //Have to change averageResponseTime.
            employees[i].Randomize();
            avaliableEmployees.add(employees[i].employeeId);
        }

    }

    void StartSimulation(){

        CustomerArrivalInterval = (simulationEndTime - simulationCurrentTime)/averageCustomerNumber;
        int test = 0;
        while(simulationCurrentTime <= simulationEndTime){

            test++;

            System.out.println(test+" is Working");

            if(customerWillArriveInSeconds == 0) {
                SendCustomers();
                ArrangeCustomerIncome();
            }
            else {
                customerWillArriveInSeconds--;
            }


            CheckRedirectisAvaliable();
            UpdateTimer();
            simulationCurrentTime++;
        }


    }
    double customerComeStatus = 0;
    void ArrangeCustomerIncome() {
        howManyCustomerWillArriveInSeconds = 0;
        double customerWillArriveInDoubleVariable = 0;
        int test = 0;
        while (customerComeStatus <= 1){
            test++;
            double arrivalUpperBound = CustomerArrivalInterval+(CustomerArrivalInterval/2);
            double arrivalLowerBound = CustomerArrivalInterval-(CustomerArrivalInterval/2);
            customerWillArriveInDoubleVariable = (Math.random()*(arrivalUpperBound - arrivalLowerBound) + arrivalLowerBound);
            howManyCustomerWillArriveInSeconds++;
            customerComeStatus += customerWillArriveInDoubleVariable;

        }
        customerWillArriveInSeconds = RoundNumber(customerComeStatus);
        System.out.println("    ArrangeCustomerIncome Worked "+test+" Times");
    }
    void SendCustomers(){
        int test = 0;
        for(int i = 0; i < howManyCustomerWillArriveInSeconds; i++){
            test++;
            Customer customer = new Customer();
            customer.Randomize();
            queue.add(customer);
        }
        customerComeStatus=0;
        System.out.println("    SendCustomers Worked "+test+" Times");
    }
    void CheckRedirectisAvaliable(){
        while(!avaliableEmployees.isEmpty() && !queue.isEmpty()) {
            ServeCustomer(employees[avaliableEmployees.getFirst()], queue.getFirst());
        }
    }
    private void ServeCustomer(Employee employee, Customer customer){
        avaliableEmployees.removeFirst();
        employee.StartServe(customer);
        queue.removeFirst();
        customer.TakingServe();
    }

    void UpdateTimer(){
        System.out.println("    Timer is working:"+ simulationCurrentTime);
        int Testa = 0;
        int testb = 0;

        for (int i = 0; i < ServingEmployees.size(); i++) {
            employees[ServingEmployees.get(i)].Serving();
            Testa++;

        }
        for (int i = 0; i < queue.size(); i++) {
            queue.get(i).Waiting();
            testb++;
        }
        System.out.println("    ServingEmployees Worked "+Testa+" Times");
        System.out.println("    queue Worked "+testb+" Times");
    }

    void AddAvaliableEmployeesLL(int Id){
        avaliableEmployees.add(Id);
    }
    void RemoveAvaliableEmployeesLL(int Id){
        avaliableEmployees.remove(Id);
    }
    void QueueLL(Customer customer){
        queue.remove(customer);
    }
    void AddServingEmployeesLL(int Id){
        ServingEmployees.add(Id);
        adana = true;
    }
    void RemoveServingEmployeesLL(int Id){
        ServingEmployees.remove(Id);
    }

    static int RoundNumber(double number){
        if(number - (int)number >= 0.5){
            return (int)(number+1);
        }
        else return (int)(number);
    }
};


