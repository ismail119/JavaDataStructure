package com.recursionAndLinkedList;

class NodeC{
    int value;
    NodeC next = null;
}

public class CircularLinkedList {
    private NodeC head;
    private NodeC tail;
    private int size;

    public void AddFirst(int value){
        NodeC temp = new NodeC();
        temp.value=value;
        head = temp;
        tail=temp;
        tail.next = head;
        size +=1;
    }

    public void AddLast(int value){
        NodeC temp = new NodeC();
        temp.value=value;
        tail.next=temp;
        tail=tail.next;
        tail.next = head;
        size +=1;
    }

    public void AddLocation(int value,int location){
        NodeC temp = new NodeC();
        temp.value = value;

        if(location>=size){
            tail.next = temp;
            temp.next = head;
            tail=tail.next;
        }
        else if(location<=0){
            temp.next = head;
            head=temp;
            tail.next = head;
        }
        else{
            var index = 0;
            NodeC iter = head;
            while(index!=location-1){
                index++;
                iter = iter.next;
            }
            temp.next = iter.next;
            iter.next=temp;
        }
        size += 1;
    }

    public void PrintAll(){
        NodeC iter = head;
        while (iter.next!=head){
            System.out.println(iter.value);
            iter=iter.next;
        }
        System.out.println(iter.value);
    }

}
