package com.example.dentistoffice;

public class MainTest {
    public static void main(String[] args) {

        Appointment a1 = new Appointment();

        a1.selectDB("May 1, 2018, 9am");

        a1.display();
    }
}