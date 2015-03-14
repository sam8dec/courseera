package algorithms.week6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
	public static void main(String[] args) throws FileNotFoundException {
		File F = new File("/home/sabanerjee/Eclipse/workspace/courseera/src/algorithms/week6/input2.txt");
		Scanner in = new Scanner(F);
		long n,a,b,med=0,sum=0;
		PriorityQueue<Long> leftHalf = new PriorityQueue<Long>(2, Collections.reverseOrder());
		//System.out.println(leftHalf.size());
		PriorityQueue<Long> rightHalf = new PriorityQueue<Long>();
		//System.out.println(leftHalf.peek());
		a = in.nextLong();
		b = in.nextLong();
		if(a>b) {
			leftHalf.add(b);
			rightHalf.add(a);
		} else {
			leftHalf.add(a);
			rightHalf.add(b);
		}
		int count=0;
		while(in.hasNextLong()) {
			n = in.nextLong();
			if(n<rightHalf.peek()) leftHalf.add(n); else rightHalf.add(n);
			if(leftHalf.size()==rightHalf.size()+2) rightHalf.add(leftHalf.remove());
			else if(rightHalf.size()==leftHalf.size()+2) leftHalf.add(rightHalf.remove());
			count++;
			if(count%2!=0) {
				if(leftHalf.size()>rightHalf.size()) med=leftHalf.peek(); else med=rightHalf.peek();
			} else {
				med = leftHalf.peek();
			}
			sum+=med;
			System.out.println(count+" "+med);
		}
		sum+=a+(a<b?a:b);
		System.out.println(sum);
	}

}
