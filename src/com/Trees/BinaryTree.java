package com.Trees;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.LinkedList;
import java.util.Queue;

class BinaryNode{
    public int value;
    public BinaryNode left,right;
    public int height;
}

public class BinaryTree {
   public BinaryNode Root;
   public BinaryTree(){
       Root = null;
   }

   private BinaryNode AddElement(int value,BinaryNode root){
        if(root==null){
            BinaryNode temp = new BinaryNode();
            temp.value = value;
            return temp;
        }
        if(value<= root.value){
            root.left = AddElement(value,root.left);
            return root;
        }
        else{
            root.right = AddElement(value,root.right);
            return root;
        }
   }

   private void PreOrderInside(BinaryNode root){
       //Root,Left,Right
       if(root==null)return;

       System.out.println(root.value + " ");
       PreOrderInside(root.left);
       PreOrderInside(root.right);
   }

   private void InorderInside(BinaryNode root){
       if (root==null)return;
       InorderInside(root.left);
       System.out.println(root.value);
       InorderInside(root.right);
   }

   private void PostorderInside(BinaryNode root){
       if (root==null)return;
       PostorderInside(root.left); //-> O(n/2)     ---> O(n) =time, O(n) =space (because of recursive)
       PostorderInside(root.right); //-> O(n/2)
       System.out.println(root.value);
   }

   public void Insert(int value){
       Root = AddElement(value,Root);
   }
   public void PreOrder(){
       PreOrderInside(Root);
   }
   public void InOrder(){
       InorderInside(Root);
   }
   public void PostOrder(){
       PostorderInside(Root);
   }

   private void LevelOrderInside(BinaryNode root){
       Queue<BinaryNode> queue = new LinkedList<>();
       queue.add(Root);
       while(!queue.isEmpty()){
           var temp = queue.remove();
           System.out.println(temp.value);
           if(temp.left!=null){
               queue.add(temp.left);
           }
           if(temp.right!=null){
               queue.add(temp.right);
           }
       }
   }
   public void LevelOrder(){
       LevelOrderInside(Root);
   }

   private boolean SearchInside(int value,BinaryNode root){
       if(root==null) return false;
       if(root.value==value)return true;
       else if(root.value<value) return SearchInside(value,root.right);
       else return SearchInside(value,root.left);
   }

   public void Search(int value){
       if(SearchInside(value,Root)) System.out.println("The Tree has this value!");
       else  System.out.println("The Tree has not this value!");
   }

   public void Clear(){
       Root=null;
   }
}
