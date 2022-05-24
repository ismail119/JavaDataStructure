package com.recursionAndLinkedList;

class NodeS {
    public int value;
    public NodeS next=null;
}

public class SinglyLinkedList {
    public NodeS head;
    public NodeS tail;
    private int size;

    public void AddFirst(int value){
        NodeS temp = new NodeS();
        temp.value = value;
        head = temp;
        tail = temp;
        size = 1;
    }
    public void AddLast(int value){
        NodeS temp = new NodeS();
        temp.value = value;

        tail.next = temp;
        tail = temp;
        size += 1;
    }
    public void AddMultiple(int[] values){
        for (int i = 0; i < values.length; i++) {
            NodeS temp = new NodeS();
            temp.value = values[i];
            tail.next = temp;
            tail = temp;
            size += 1;
        }
    }

    public void DeleteLocation(int location){
        if(location>=size)location=size-1;
        if(location<=0){
            var free = head;
            head = head.next;
            free.next = null;
            free = null;
        }
        else{
            int index = 0;
            NodeS iter = head;
            while(index!=location-1){
                index++;
                iter=iter.next;
            }
            var free = iter.next;
            iter.next = iter.next.next;

            free.next=null;
            free=null;
        }
        size-=1;
    }

    public boolean Contains(int value){
        NodeS iter = head;
        while(iter!=null){
            if(iter.value==value)return true;
            iter=iter.next;
        }
        return false;
    }
    public void Clear(){
        head=null;
        tail=null;
        size=0;
    }

    public int Find(int value){
        int index=0;
        NodeS iter = head;
        while(iter!=null){
            if(iter.value==value)return index;
            iter=iter.next;
            index++;
        }
        return -1;
    }


    public void InsertLocation(int value,int location){
        NodeS temp = new NodeS();
        temp.value = value;
        if(location<=0){
            temp.next = head;
            head = temp;
        }
        else if(location >= size){
            AddLast(value);
        }
        else{
            int index = 0;
            NodeS iter = head;
            while(index!=location-1){
                iter= iter.next;
                index++;
            }
            temp.next=iter.next;
            iter.next=temp;
        }
    }
    public int Size(){
        return size;
    }
    public NodeS GetLast(){
        return tail;
    }
    public NodeS GetFirst(){
        return head;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void DeleteLast(){
        DeleteLocation(size);
    }

    public void PrintLinkedList(){
        NodeS iter = head;
        while (iter!=null){
            System.out.print(iter.value+" ");
            iter = iter.next;
        }
    }
}
