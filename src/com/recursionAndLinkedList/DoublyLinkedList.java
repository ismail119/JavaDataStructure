package com.recursionAndLinkedList;

//Sonuncu elemani silme, ileri-geri ilerleme islemleri yapma varsa bu structure daha mantikli.
class NodeD{
    String value;
    NodeD next = null;
    NodeD previos = null;
}

public class DoublyLinkedList {
    public NodeD head;
    private NodeD tail;
    private NodeD iter;
    private int size;

    public void AddFirst(String value){
        NodeD temp = new NodeD();
        temp.value=value;
        head = temp;
        tail = temp;
        size+=1;
    }
    public void AddLast(String value){
        NodeD temp = new NodeD();
        temp.value=value;
        tail.next = temp;
        temp.previos = tail;
        tail = tail.next;
        size+=1;
    }

    public void PlayMusicList(){
        iter=head;
        System.out.println(iter.value);
    }

    public void InsertLocation(String value,int location){
        NodeD temp = new NodeD();
        temp.value = value;
        if(location<=0){
            temp.next=head;
            head = temp;
        }
        else if(location>=size){
            tail.next = temp;
            temp.previos=tail;
            tail=tail.next;
        }
        else{
            int index = 0;
            NodeD iter = head;
            while(index!=location-1){
                index+=1;
                iter=iter.next;
            }
            temp.next = iter.next;
            iter.next.previos = temp;
            iter.next = temp;
            temp.previos=iter;
        }
    }

    public void GoNext(){
        if(iter==tail) System.out.println(tail.value);
        else{
            iter=iter.next;
            System.out.println(iter.value);
        }
    }
    public void GoPrev(){
        if(iter==head) System.out.println(head.value);
        else{
            iter = iter.previos;
            System.out.println(iter.value);
        }
    }

    public void DeleteLast(){
        DeleteLocation(size);
    }

    public void DeleteLocation(int location){
        if(location<=0){
            head.next.previos=null;
            head=head.next;
        }
        else if(location>=size){
            tail = tail.previos;
            tail.next=null;
        }
        else{
            int index=0;
            NodeD iter = head;
            while(index!=location-1) {
                index += 1;
                iter = iter.next;
            }
            iter.next = iter.next.next;
            iter.next.previos = iter;
        }
    }

    public void PrintAll(){
        NodeD iter = head;
        while(iter!=null){
            System.out.println(iter.value);
            iter=iter.next;
        }
    }
    public void PrintReverse(){
        NodeD iter = tail;
        while (iter!=null){
            System.out.println(iter.value);
            iter=iter.previos;
        }
    }


}
