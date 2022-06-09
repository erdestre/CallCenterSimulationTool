package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame frame;

    JButton StartButton;

    void ShowGUI(){

        frame = new JFrame();
        frame.setTitle("Call Center Simulation Tool");
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);

        frame.getContentPane().setBackground(new Color(173,204,196));
        setSetValueScreen();
        setSimulationScreen();
        // ImageIcon image = new ImageIcon("logo.png");
        //frame.setIconImage(image.getImage());
    }
    private void setSetValueScreen() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.red);
        frame.add(panel);

        StartButton = new JButton();
        StartButton.setSize(500,500);
        panel.add(StartButton);


    }
    private void setSimulationScreen() {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==StartButton){
            //GetValues
        }
    }
}
