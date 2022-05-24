package com.StackAndQueue;

import java.nio.file.StandardOpenOption;

class StackNode{
    int value;
    StackNode next = null;
}

public class Stack {
    public StackNode TopOfStack = null;
    private int size=0;

    public void Push(int value){
        StackNode temp = new StackNode();
        temp.value = value;

        if(TopOfStack==null)
            TopOfStack = temp;
        else{
            temp.next=TopOfStack;
            TopOfStack=temp;
        }
        size+=1;
    }

    public StackNode Pop(){
        var topNode = TopOfStack;
        if(size==0){
            System.out.println("Stack is empty!");
            return null;
        }
        else{
            TopOfStack = TopOfStack.next;
            size-=1;
            return topNode;
        }
    }
    public StackNode Peek(){
        return TopOfStack;
    }
    public void PrintStack(){
        StackNode iter= TopOfStack;
        while(iter!=null){
            System.out.print(iter.value+" ");
            iter=iter.next;
        }
    }
}
