package com.StackAndQueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(9);
        arrayStack.Push(0,1);
        arrayStack.Push(0,2);
        arrayStack.Push(1,3);
        arrayStack.Push(1,4);
        arrayStack.Push(2,5);
        arrayStack.Push(2,6);
    }
}

//Question 1
class QueueWithTwoStacks{
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2=new Stack<>();

    public void Enqueue(int element){ // O(1)
        stack1.push(element);
    }
    public int Dequeue(){ // O(n)
        while(!stack1.empty())
            stack2.push(stack1.pop());

        var value = stack2.pop();
        while(!stack2.empty())
            stack1.push(stack2.pop());

        return value;
    }
    public int Peek(){
        return stack1.lastElement();
    }
    public void PrintAll(){
        Iterator<Integer> iter = stack1.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}

//Question 2

abstract class Animal{
    public Animal next;
    public String name;
    public int order;
    abstract void UpdateOlder(int order);

}

class Dog extends Animal{
    public Dog(String name){
        this.name=name;
    }
    @Override
    void UpdateOlder(int order) {
        this.order = order;
    }
}
class Cat extends Animal{
    public Cat(String name){
        this.name=name;
    }
    @Override
    void UpdateOlder(int order) {
        this.order = order;
    }
}

class Older{
    public int older_name=0;
    private static Older older =null;
    private Older(){}
    public static Older getInstance(){
        if(older==null)
            older = new Older();
        return older;
    }
}

class Shelter {
    private LinkedList<Cat> catList = new LinkedList<>();
    private LinkedList<Dog> dogList = new LinkedList<>();

    public void Enqueue(Animal animal) {
        if (animal instanceof Cat) {
            if (catList.isEmpty())
                catList.addFirst((Cat) animal);
            else
                catList.addLast((Cat) animal);

            Older.getInstance().older_name += 1;
            animal.UpdateOlder(Older.getInstance().older_name);
        } else if (animal instanceof Dog) {
            if (dogList.isEmpty())
                dogList.addFirst((Dog) animal);
            else
                dogList.addLast((Dog) animal);
            animal.UpdateOlder(Older.getInstance().older_name + 1);
        }
    }

    public Animal DequeueAny() {
        Dog dogFirst = dogList.getFirst();
        Cat catFirst = catList.getFirst();
        if (catFirst.order < dogFirst.order) {
            catList.removeFirst();
            return catFirst;
        } else {
            dogList.removeFirst();
            return dogFirst;
        }
    }

    public Animal DequeueDog() {
        Dog dogFirst = dogList.getFirst();
        dogList.removeFirst();
        return dogFirst;
    }

    public Animal DequeueCat() {
        Cat catFirst = catList.getFirst();
        catList.removeFirst();
        return catFirst;
    }

}

    //Question 3
    class ArrayStack{
        private int[] stack;
        private int stackCount=3;
        private int size;
        private List<Integer> criticPoints=new LinkedList<>();
        private List<Integer> heads=new LinkedList<>();

        public ArrayStack(int capacity){
            stack = new int[capacity];
            size = capacity/stackCount;
            for (int i = 0; i <= stackCount; i+=size) {
                criticPoints.add(i);//0,3,6,9
                if(i!=stackCount)
                    heads.add(i);//0,3,6
            }
        }

        public void Push(int stackNumber,int value){
            if(criticPoints.contains(heads.get(stackNumber)+1))
                System.out.println("Stack choising is full already!");
            else{
                stack[heads.get(stackNumber)] = value;
                var tempValue = heads.get(stackNumber);
                heads.set(stackNumber,tempValue+1);
                }
        }

        public int Pop(int stackNumber){
            if(criticPoints.contains(heads.get(stackNumber))){
                System.out.println("Stack choising is empty already!");
                return -1;
            }
            else{
                var temp= heads.get(stackNumber) ;
                stack[heads.get(stackNumber)] = 0;
                var value = heads.get(stackNumber);
                heads.set(stackNumber,value-1);
                return temp;
            }
        }
    }



