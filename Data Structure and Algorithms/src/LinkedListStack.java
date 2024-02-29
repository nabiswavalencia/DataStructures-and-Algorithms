////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
//    }
//}

import java.util.*;
public class LinkedListStack {
    private Node headNode; // the first node
    private int stackSize;
    // nest class to define linkedlist node
    private class Node {
        int value;
        Node next;
    }

    public LinkedListStack() {
        headNode = null;
        stackSize = 0;
    }

    // Remove value from the beginning of the list for demonstrating behaviour of stack
    public int pop() throws Exception {
        if (headNode == null) {
            throw new EmptyStackException();
        }
        int value = headNode.value;
        headNode = headNode.next;
        stackSize--;
        return value;
    }

    // Add value to the beginning of the list to demonstrate behaviour of the stack
    public void push(int value) {
        Node oldHead = headNode;
        headNode = new Node();
        headNode.value = value;
        headNode.next = oldHead;
        stackSize++;
    }

    public int peek() throws Exception {
        if (headNode == null) throw new EmptyStackException();
        else return headNode.value;
    }

    public int size() {
        return stackSize;
    }

    public boolean empty() {
        return stackSize == 0;
    }

    public static void main(String args[]) throws Exception {
        LinkedListStack mystack = new LinkedListStack();
        mystack.push(9); //a
        mystack.push(3); //b
        mystack.push(8); //c
        System.out.println("Element at the top is :" + mystack.peek()); //d
        System.out.println("Element removed is : " + mystack.pop()); //e
        System.out.println("The size of the stack is : " + mystack.size()); //f
        System.out.println("Element removed is : " + mystack.pop()); //g
        System.out.println("Element at the top is : " + mystack.peek()); //h
        mystack.push(10);
        System.out.println("Stack is empty :  " + mystack.empty()); //i
    }

}
