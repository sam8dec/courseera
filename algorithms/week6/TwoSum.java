package algorithms.week6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoSum {
	static final int ARRAY_SIZE = 1000000;
	static long[] numbers = new long[ARRAY_SIZE];
	static Set<Long> nhash = new HashSet<Long>();
	static boolean texists[] = new boolean[20001];
	public static void main(String[] args) throws FileNotFoundException {
		File F = new File("/home/sabanerjee/Eclipse/workspace/courseera/src/algorithms/week6/input.txt");
		Scanner in = new Scanner(F);
		int i=0,j,count=0;
		long x,y,t;
		while(in.hasNextLong()) {
			numbers[i++] = in.nextLong();
			//System.out.println(numbers[i-1]);
		}
		for(i=0;i<ARRAY_SIZE;i++) {
			nhash.add(numbers[i]);
		}
		System.out.println(nhash.size());
		for(i=0;i<ARRAY_SIZE;i++) {
			x=numbers[i];
			for(j=0;j<20001;j++) {
				if(texists[j]) continue;
				t=j-10000;
				y=t-x;
				if(nhash.contains(y) && y!=x) texists[j]=true;
			}
			//System.out.println(nhash.size());
		}
		for(j=0;j<20001;j++) {
			if(texists[j]) count++;
		}
		System.out.println(count);
	}

}
