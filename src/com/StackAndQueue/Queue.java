package com.StackAndQueue;

class QueueNode{
    int value;
    QueueNode next=null;
}

public class Queue {
    private QueueNode front=null,end=null;

    public QueueNode Dequeue(){
        if(front!=null){
            var temp = front;
            front=front.next;
            return temp;
        }
        else return null;
    }
    public void Enqueue(int value){
        QueueNode temp = new QueueNode();
        temp.value=value;

        if(front==null){
            front=temp;
            end=temp;
        }
        else{
            end.next = temp;
            end=end.next;
        }
    }
    public void PrintQueue(){
        QueueNode iter = front;
        while(iter!=end.next){
            System.out.print(iter.value+" ");
            iter=iter.next;
        }
    }
}
