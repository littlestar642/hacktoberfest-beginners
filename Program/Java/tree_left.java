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
    
        //static HashMap <Integer,String> inner=new HashMap <Integer,String>();

        static int height(Node cur){
            int l=0,r=0;
            if(cur==null){
                return 0;
            }

            if(cur!=null){
                l=height(cur.left);
                r=height(cur.right);
            }

            return Math.max(l,r)+1;
        }
        static int maxlevel=0;
        static void leftPrint(Node cur,int level){
            if(cur==null){
                return;
            }

            
                if(level>maxlevel || level==0){
                    maxlevel=level;
                    System.out.println(cur.key);
                }
                leftPrint(cur.left,level+1);
                leftPrint(cur.right,level+1);
            
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
        temp=new Node(7);
        root.right.right=temp;
        temp=new Node(8);
        root.right.right.right=temp;
        temp=new Node(9);
        root.right.left.left=temp;

        leftPrint(root,0);
        
    }
} 
