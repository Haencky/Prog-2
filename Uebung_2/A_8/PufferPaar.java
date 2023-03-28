package Uebung_2.A_8;

import Uebung_0.A_3.Boxer;
import Uebung_0.A_3.Student;
import Uebung_2.A_3.Puffer;
import Uebung_2.A_3.SchlangeMitArrayGen;
import Uebung_2.A_3.StapelMitArrayGen;
import Uebung_2.A_6.Paar;

import javax.swing.*;

public class PufferPaar {
    public static void main(String[] args) {

        Puffer<Paar<Student, String>> servicePoint;
        Puffer<Paar<Boxer, Boxer>> boxEvent;

        servicePoint = new SchlangeMitArrayGen<>(4);
        boxEvent = new StapelMitArrayGen<>(3);

        //Studenten
        Student s1 = new Student("Mustermann", "Max", 123);
        Student s2 = new Student("Zufall", "Rainer", 1234);
        Student s3 = new Student("Schulz", "Tim", 555);
        Student s4 = new Student("Alda", "Sasha", 911);

        //Fragen
        String f1 = "Was ist die Wurzel von -1?";
        String f2 = "Warum funktioniert mein Laptop nur mit Strom?";
        String f3 = "Who is this Pokémon?";
        String f4 = "Muss man hier immer alles selber machen?";

        //Studentenpaare
        Paar<Student, String> p1 = new Paar<>(s1, f1);
        Paar<Student, String> p2 = new Paar<>(s2, f2);
        Paar<Student, String> p3 = new Paar<>(s3, f3);
        Paar<Student, String> p4 = new Paar<>(s4, f4);

        //Boxer
        Boxer b1 = new Boxer("Tyson", "Mike", 130);
        Boxer b2 = new Boxer("Ali", "Mohammed", 123);
        Boxer b3 = new Boxer("Jenkins", "Leeroy", 55);

        //Boxkämpfe
        Paar<Boxer, Boxer> k1 = new Paar<>(b1,b2);
        Paar<Boxer, Boxer> k2 = new Paar<>(b1,b3);
        Paar<Boxer, Boxer> k3 = new Paar<>(b2,b3);

        servicePoint.insert(p1);
        servicePoint.insert(p2);
        servicePoint.insert(p3);
        servicePoint.insert(p4);

        for (int i = 0; i < servicePoint.capacity(); i++) {
            System.out.println(servicePoint.remove().toString());
        }

        System.out.println("-------------------------------");

        boxEvent.insert(k1);
        boxEvent.insert(k2);
        boxEvent.insert(k3);

        for (int i = 0; i < boxEvent.capacity(); i++) {
            System.out.println(boxEvent.remove().toString());
        }
    }
}
