/* Language: C++
   Author : Rogin Koshy
   Github:  https://github.com/Roginkoshy
*/
#include<bits/stdc++.h>
using namespace std;
char a[2]={'X','O'};
void print(char c[3][3])
{
	system("clear");
	cout<<"\n";
	for(int i=0;i<3;i++)
	{
		for(int j=0;j<3;j++)
		cout<<c[i][j]<<" ";
		
		cout<<"\n";
	}
}
bool check(char c[3][3])
{
	for(int i=0;i<2;i++)
	{
		int dia=0;
		int count=0;
	   for(int j=0;j<3;j++)
	   {
	   	if(c[j][j]==a[i])
	   	{
	   	dia++;	
		 }
		 int temp1=0,temp2=0;
		 for(int k=0;k<3;k++)
		 {
		 	if(c[j][k]=='O'||c[j][k]=='X')
		 	{
		 		count++;
			 }
		 	if(c[j][k]==a[i])
		 	{
		 		temp1++;
			 }
			 if(c[k][j]==a[i])
			 {
			 	temp2++;
			 }
		 }
		 if(temp1==3||temp2==3)
		 {
		 	cout<<a[i]<<" wins!";
		 	return true;
		 }
	   }
	   
	if(dia==3)
	{
		cout<<a[i]<<" wins!";
		return true;
	}

	if(c[0][2]==a[i]&&c[1][1]==a[i]&&c[2][0]==a[i])
	{
		cout<<a[i]<<" wins!";
		return true;
	}
		if(count==9)
	   {
	   	print(c);
	   	cout<<"Match Tied!\n";
	   	return true;
	   }
	}
	
return false;	
}
int main()
{
	char c[3][3];
	int r=1;
	for(int i=0;i<3;i++)
	{
		for(int j=0;j<3;j++)
		{
			c[i][j]=r+48;
			r++;
		}
	}
	int i=0;
	do
	{
	if(check(c))
	break;	
		
		int w;
		int y,z;
		int flag=0;
		do{
		
			
			print(c);
				if(flag)
			   {
				cout<<"Please enter a valid position\n";
		     	}
			flag=0;
			cout<<a[i]<<"'s turn\nEnter the position where you want to insert\n";
			cin>>w;
		switch(w)
		{
			
			flag=0;
			case 1:
			y=0;
			z=0;
			if(c[y][z]=='X'||c[y][z]=='O')
			{
	//		cout<<"Please enter an unfilled position\n";
			flag=1;
		   }
			else
			c[y][z]=a[i];
				print(c);
			break;
			
			case 2:
			y=0;
			z=1;
			if(c[y][z]=='X'||c[y][z]=='O')
			{
	//		cout<<"Please enter an unfilled position\n";
			flag=1;
		}
			else
			c[y][z]=a[i];
				print(c);
			break;
			
			case 3:
			y=0;
			z=2;
			if(c[y][z]=='X'||c[y][z]=='O')
			{
	//		cout<<"Please enter an unfilled position\n";
			flag=1;
			}
			else
			c[y][z]=a[i];
				print(c);

			break;
			
			case 4:
			y=1;
			z=0;
			if(c[y][z]=='X'||c[y][z]=='O')
			{
      //      cout<<"Please enter an unfilled position\n"; 
			flag=1;
		}
			else
			c[y][z]=a[i];
				print(c);
			break;
			
			case 5:
			y=1;
			z=1;
			if(c[y][z]=='X'||c[y][z]=='O')
			{
//				cout<<"Please enter an unfilled position\n";
			flag=1;
		}
			else
			c[y][z]=a[i];
				print(c);
			break;
			
			case 6:
			y=1;
			z=2;
			if(c[y][z]=='X'||c[y][z]=='O')
			{
//				cout<<"Please enter an unfilled position\n";
			flag=1;
		}
			else
			c[y][z]=a[i];
				print(c);
			break;
			
			case 7:
			y=2;
			z=0;
			if(c[y][z]=='X'||c[y][z]=='O')
			{
//				cout<<"Please enter an unfilled position\n";
			flag=1;
		}
			else
			c[y][z]=a[i];
				print(c);
			break;
			
			case 8:
			y=2;
			z=1;
			if(c[y][z]=='X'||c[y][z]=='O')
			{
//				cout<<"Please enter an unfilled position\n";
			flag=1;
		}
			else
			c[y][z]=a[i];
				print(c);
			break;
			
			case 9:
			y=2;
			z=2;
			if(c[y][z]=='X'||c[y][z]=='O')
			{
//				cout<<"Please enter an unfilled position\n";
			flag=1;
		}
			else
			c[y][z]=a[i];
				print(c);
			break;
			
			default:
			flag=1;
			break;
		}
	}while(flag==1);
	//	print(c);
		i=(i+1)%2;
	}while(1);
//	getch();
	return 0;
}
