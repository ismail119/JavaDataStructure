package com.recursionAndLinkedList;


import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
    }

    //Question 1
    private static SinglyLinkedList DeleteDups(SinglyLinkedList linkedList){
        HashSet<Integer> visitedValues = new HashSet<>();
        NodeS prev=null;
        NodeS current = linkedList.head;
        while(current!=null){
            if(visitedValues.contains(current.value))
                prev.next = current.next;
            else{
                visitedValues.add(current.value);
                prev = current;
            }
            current = current.next;
        }
        return linkedList;
    }

    //Question 2
    private static int FindLastNth(SinglyLinkedList linkedList, int Nth) {
        NodeS pointer1 = linkedList.head;//O(1)
        NodeS pointer2 = linkedList.head;//O(1)
        for (int i = 0; i < Nth-1; i++) { //O(n)
            pointer2=pointer2.next;//O(1)
        }
        while(pointer2.next!=null){
            pointer1=pointer1.next; //O(1)
            pointer2=pointer2.next;//O(1)
        }
        return pointer1.value;//O(1)
        // -> 1+1+n+2n=>3n+1=> O(n)
    }

    //Question 3
    private static SinglyLinkedList Partition(SinglyLinkedList linkedList,int separateValue){
        NodeS pointer1= linkedList.head;//First //O(1)
        NodeS prev = null; //O(1)

        NodeS pointer2= linkedList.GetLast();//Tail //O(1)

        while(pointer1!=pointer2){//--> O(n)
            if(pointer1.value >= separateValue){
                linkedList.tail.next  =prev.next;//O(1)
                prev.next=pointer1.next;//O(1)
                pointer1= pointer1.next;//O(1)
                linkedList.tail= linkedList.tail.next;//O(1)
                linkedList.tail.next=null;//O(1)
            }
            else{
                prev=pointer1;//O(1)
                pointer1 = pointer1.next;//O(1)
            }
        }
        return linkedList;
        //1+1+1+5*n=> 5n+3 => O(n)
    }

    private static SinglyLinkedList SumOfDigits(SinglyLinkedList list1,SinglyLinkedList list2) {
        int carry=0;
        int index=0;
        NodeS pointer1=list1.head;
        NodeS pointer2= list2.head;
        SinglyLinkedList newList = new SinglyLinkedList();
        while(pointer1!=null|| pointer2!=null){
            int sum=carry;
            if(pointer1!=null){
                sum+=pointer1.value;
                pointer1=pointer1.next;
            }
            if(pointer2!=null){
                sum+=pointer2.value;
                pointer2=pointer2.next;
            }
            if(index==0){
                newList.AddFirst(sum%10);
                index++;
            }
            else newList.AddLast(sum%10);
            carry = sum/10;
        }
        return newList;
    }

}

