/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.laboratoryexercise1;

/**
 *
 * @author delossantosap
 */
public class LaboratoryExercise1 {

    public static void main(String[] args) {
        LinkedList head = new LinkedList();
        Node n1 = new Node();
        n1.val = 8;
        head.head = n1;
        Node n2 = new Node();
        n2.val = 3;
        n1.next = n2;
        Node curr = head.head;
        while(curr != null) {
            System.out.println("The current value is " + curr.val);
            curr = curr.next;
        }
    }
}
