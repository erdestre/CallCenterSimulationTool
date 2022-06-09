package com.company;
//https://www.youtube.com/watch?v=Kmgo00avvEw&ab_channel=BroCode
//https://users.cs.northwestern.edu/~agupta/_projects/networking/QueueSimulation/mm1.html
public class Main {




    public static void main(String[] args) {
        int StartHour = 32400; //09:00 // Seconds
        int EndHour = 61200; //17:00 // Seconds
        int EmployeeCount = 10;
        int AverageResponseTime = 60; // Seconds
        int CustomerCount = 100;
        String[] Topics = {"Technical Support", "Others"};

        GUI gui = new GUI();

        gui.ShowGUI();

        Simulation simulation = new Simulation();
        simulation.SetValues(StartHour, EndHour, EmployeeCount, AverageResponseTime, CustomerCount, Topics);
        simulation.StartSimulation();
    }

    void TakeInputs(int StartHour, int StartMinute, int EndHour, int EndMinute,
                    int EmployeeCount, int CustomerCount,
                    String[] Topics){

    }

}
