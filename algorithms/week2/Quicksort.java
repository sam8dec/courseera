package algorithms.week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quicksort {
	public static int comparisons=0;
	public static int getPivot1(int[] arr, int begin, int end) {
		return begin;
	}
	public static int getPivot2(int[] arr, int begin, int end) {
		return end;
	}
	public static int getPivot3(int[] arr, int begin, int end) {
		int mid=(begin+end)/2;
		if(arr[mid]>arr[begin] && arr[mid]<arr[end] || arr[mid]>arr[end] && arr[mid]<arr[begin]) return mid;
		if(arr[begin]>arr[mid] && arr[begin]<arr[end] || arr[begin]>arr[end] && arr[begin]<arr[mid]) return begin;
		return end;
	}
	public static void quicksort(int[] arr, int begin, int end) {
		if(begin>=end) return;
		comparisons+=(end-begin+1)-1;
		int i,j,t,piv=getPivot2(arr, begin, end),p;
		
		t=arr[begin];
		arr[begin]=arr[piv];
		arr[piv]=t;
		p=arr[begin];
		
		i=j=begin+1;
		for(;j<=end;j++) {
			if(arr[j]<p) {
				t=arr[i];
				arr[i]=arr[j];
				arr[j]=t;
				i++;
			}
		}
		t=arr[begin];
		arr[begin]=arr[i-1];
		arr[i-1]=t;
		quicksort(arr,begin,i-2);
		quicksort(arr,i,end);
	}
	public static void main(String[] args) throws FileNotFoundException {
		int N[] = new int[10000],i=0;
		File F = new File("/home/sabanerjee/Eclipse/workspace/courseera/src/algorithms/week2/input.txt");
		Scanner in = new Scanner(F);
		while(in.hasNextInt()) {
			N[i++] = in.nextInt();
		}
		int tN[] = {4,3,5,1,2};
		quicksort(N,0,9999);
		System.out.println(comparisons);
		for(i=0;i<10;i++) System.out.println(N[i]); 
	}

}
