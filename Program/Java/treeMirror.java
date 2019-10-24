import java.util.*;
import java.io.*;
import java.lang.*;
class Student{

    int a,b;
    char c;

    public Student(int a,int b,char c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public String toString()
    {
        // return this.a + " " + this.b +
        //                   " " + this.c;
        return this.b+"";
    }
}


class SortByStart implements Comparator<Student>{

    public int compare(Student A,Student B)
    {
        return (A.a+"").compareTo(B.a+"");
    }
}


class TestClass
{
    public static void main(String args[] ) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int i,a,b;
        char ch;
        ArrayList <Student> ar=new ArrayList<Student>();
        for(i=0;i<n-1;i++)
        {
            a=sc.nextInt();
            b=sc.nextInt();
            ch=sc.next().charAt(0);
            ar.add(new Student(a,b,ch));
        }

        int q[]=new int[m];

        for(i=0;i<m;i++)
        {
            q[i]=sc.nextInt();
        }

        Collections.sort(ar,new SortByStart());
        Treee bt=new Treee();

        bt.add(1,"",0);
        for(i=0;i<n-1;i++)
        {
            bt.add(ar.get(i).b,(ar.get(i).c+""),ar.get(i).a);
        }

        //bt.traverseInOrder(bt.root);

    }
}

class Treee{

    Node root;

    public void add(int value,String r,int np)
    {
        if(r.equals(""))
        {
            root=new Node(value);
        }
        else{
            root=addNode(root,value,r,np);
        }
    }

    public Node addNode(Node current,int value,String r,int np){

      if(np>current.np){
        current.right=addNode(current.right,value,r,np);
      }
      else if(np<current.np){
        current.left=addNode(current.left,value,r,np);
      }


    if(r.equals("R")){
        current.right=addNode(current.right,value,r,np);
        current.np=np;
      }
      else if(r.equals("L")){
        current.left=addNode(current.left,value,r,np);
        current.np=np;
      }
      else{
  	    return current;
  	  }
      return current;

    }

    public void traverseInOrder(Node node) {
      if (node != null) {
          traverseInOrder(node.left);
          System.out.print(" " + node.value);
          traverseInOrder(node.right);
  		}
  	}

}
class Node{

  int value;
  Node root;
  Node left;
  Node right;
  int np;

  public Node(int value){
    this.value=value;
    this.left=null;
    this.right=null;
    this.np=0;
  }
}
