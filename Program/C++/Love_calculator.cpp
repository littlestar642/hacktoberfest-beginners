#include<bits/stdc++.h>
using namespace std;
void calc(int *arr, int num)
{
	int j;
	cout<<"\nLOVE = ";
	while(num >= 2)
	{
		if(num == 2 || num == 1)
		{
			for(int i = 0 ;i < num ;i++)
			cout<<arr[i];
			cout<<" %";
			if(arr[0] >= 7)
			cout<<"\nCongrats! ^_^";
			if(arr[0]<5)
			cout<<"\nHard Luck :(";
			
			break;
		}
		else if(num%2 != 0)
		{
			for(int i = 0, j = num-1 ;(i <= num/2 - 1 && j>=num/2+1) ;i ++ , j --)
			{
				arr[i] += arr[j];
			}
			arr[num/2] = arr[num/2];
			num = num/2+1;
		}
		else if(num%2 == 0)
		{
			for(int i = 0, j = num-1 ;(i <= num/2 - 1 && j >= num/2) ;i ++, j --)
			{
				arr[i] += arr[j];
			}
			num /= 2;
		}
	}
	
}
int main()
{
	string a, b;
	cout<<"\t\t\t\t *** LOVE PERCENTAGE CALCULATOR ***";
	cout<<"\nEnter your name: ";
	cin>>a;
	cout<<"\nEnter your crush's name: ";
	cin>>b;
	int len1 = a.size();
	int len2 = b.size();
	int i, j, match = 0, count;
	//To count the number of matches in the names.
	for(i=0;i<a.size();i++)
	{
		for(j=0 ;j<b.size();j++)
		{
			if(a[i] == b[i])//match found
			{
				a[i]=0; len1 --;
				b[i]=1; len2--;
				match ++;
			}
		}
	}
    count = len1+len2+match;

	int arr[count];
	for(i = 0 ;i < count ;i ++)
	arr[i] = 1;
	calc(arr, count);
	
	return 0;		
}
