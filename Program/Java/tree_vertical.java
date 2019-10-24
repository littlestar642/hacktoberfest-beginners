import java.util.*;
import java.lang.*;
import java.io.*;


class Node 
{ 
        int key; 
        Node left; 
        Node right; 
          
        Node(int data) 
        { 
            key = data; 
            left = null; 
            right = null; 
        } 
        static int min=Integer.MAX_VALUE;
        static int max=Integer.MIN_VALUE;
        
        //static HashMap <Integer,HashSet <Integer>> outer=new HashMap <Integer,HashSet <Integer>>();
        static HashMap <Integer,String> inner=new HashMap <Integer,String>();

        static void vertical(Node cur,int i){
            if(cur==null){
                return;
            }

            if(!inner.containsKey(i)){
                inner.put(i,cur.key+"");
            }
            else{
                inner.put(i,inner.get(i)+" "+cur.key);
            }
            
            if(i<min){
                min=i;
            }
            if(i>max){
                max=i;
            }

            if(cur.left!=null){
                vertical(cur.left,i-1);
            }
            if(cur.right!=null){
                vertical(cur.right,i+1);
            }
        }

    public static void main(String args[]) throws Exception
    {
        Node root=new Node(1);
        Node temp=new Node(2);
        root.left=temp;
        temp=new Node(3);
        root.right=temp;
        temp=new Node(4);
        root.left.left=temp;
        temp=new Node(5);
        root.left.right=temp;
        temp=new Node(6);
        root.right.left=temp;

        vertical(root,0);
        for(int i=min;i<=max;i++){
            System.out.println(inner.get(i));
        }

        // String value = ((HashSet<Integer>)outer.get(i)).toString();
        // System.out.print(value+" ");
    }
} 
