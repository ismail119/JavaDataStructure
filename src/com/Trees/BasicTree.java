package com.Trees;


import java.util.ArrayList;

class NodeTree{
    private String value;
    private ArrayList<NodeTree> children;

    public NodeTree(String value){
        this.value=value;
        this.children = new ArrayList<>();
    }
    public void AddChild(NodeTree temp){
        this.children.add(temp);
    }
    public void AddMultipleChildren(NodeTree[] list){
        for (var item:list)
            this.children.add(item);
    }
    public void PrintChildren(){
        for (var child:this.children)
            System.out.println(child.value);
    }
}

public class BasicTree {

}
