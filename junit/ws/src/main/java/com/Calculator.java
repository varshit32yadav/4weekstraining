package com;

public class Calculator {
	int a=5,b=10,ans;
	public int add(int a,int b)
	{
		return a+b;
	}
	
	public int sub(int a,int b)
	{
		return a-b;
	}
	
	public int mul(int a,int b)
	{
		return a*b;
	}
	
	public int div(int a,int b)
	{
		return a/b;
	}
	public int getAns() {
		return ans;
	}
	public void display() {
		ans=a*b;
	}
}

interface calculate{
	void abc() ;
}
