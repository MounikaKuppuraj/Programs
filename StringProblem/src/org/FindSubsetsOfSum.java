package org;

import java.util.ArrayList;

public class FindSubsetsOfSum {
	static boolean dp[][];
	static void display(ArrayList<Integer> v) 
    { 
       System.out.println(v); 
    } 
	public static void findSubsetRec(int arr[], int i, int sum, ArrayList<Integer> p) {
		if(i==0 && sum!=0 && dp[0][sum]) {
			p.add(arr[i]);
			display(p);
			p.clear();
		    return;
		}
		if(i==0 && sum==0) {
			display(p);
			p.clear();
		    return;
		}
		if(dp[i-1][sum]) {
			ArrayList<Integer> b=new ArrayList<Integer>();
			b.addAll(p);
			findSubsetRec(arr,i-1,sum,b);
		}
		if(sum>=arr[i] && dp[i-1][sum-arr[i]]) {
			p.add(arr[i]);
			findSubsetRec(arr,i-1,sum-arr[i],p);
		}
	}
	public  static void findSubset(int[] arr, int sum, int n) {
		if(sum<=0 || n==0) {
			return;
		}
		dp=new boolean[n][sum+1];
		for(int i=0;i<n;i++) {
			dp[i][0]=true;
		}
		if(arr[0]<=sum) {
			dp[0][arr[0]]=true;
		}
		for(int i=1;i<n;i++) {
			for(int j=0;j<sum+1;j++) {
				dp[i][j]=(arr[i]<=j) ? dp[i-1][j]||dp[i-1][j-arr[i]]: dp[i-1][j];
			}
		}
		if(!dp[n-1][sum]){
			return;
		}
		ArrayList<Integer> p=new ArrayList<Integer>();
		findSubsetRec(arr,n-1,sum,p);
	}
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};
		int sum=10;
		findSubset(arr,sum,arr.length);
	}

}
