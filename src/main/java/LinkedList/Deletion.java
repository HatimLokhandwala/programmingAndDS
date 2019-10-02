package LinkedList;

import java.util.Scanner;

/**
 * to delete an element from linked list, given its pointer
 */
class Node{
    int data;
    Node next; 
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    Node head;
    Node tail;
    LinkedList(){
        head = null;
        tail = null;
    }
    void insert(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
        }
        else{
            tail.next = newNode;
        }
        tail = newNode;
    }
    void print(){
        Node tempNode = head;
        while(tempNode!=null){
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    Node search(int value){
        Node temp = head;
        while(temp!=null){
            if(temp.data == value) return temp;
            temp = temp.next;
        }
        return null;
    }

    void delete(int value){
        Node deleteNode = search(value);
        deleteNode.data = deleteNode.next.data;
        Node tempNode = deleteNode.next.next;
        deleteNode.next = tempNode;
    }
}

public class Deletion{
    public static void main(String args[]){
        int testCases;
        Scanner sc = new Scanner(System.in);
        testCases = sc.nextInt();
        while(testCases>0){
            int n = sc.nextInt();
            LinkedList l = new LinkedList();
            while(n>0){
                l.insert(sc.nextInt());
                n--;
            }
            int deleteValue = sc.nextInt();
            l.delete(deleteValue);
            l.print();
            testCases--;
        }
    }
}