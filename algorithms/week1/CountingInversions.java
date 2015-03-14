package algorithms.week1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountingInversions {
	public static long sortAndCountInversions(int[] N, int st, int en) {
		//System.out.println(st+" "+en);
		if(st==en) return 0;
		else {
			long invL=sortAndCountInversions(N,st,(st+en)/2);
			long invR=sortAndCountInversions(N,(st+en)/2+1,en);
			int[] temp = new int[en-st+1];
			int sL=st;
			int sR=(st+en)/2+1;
			int eL=(st+en)/2;
			int eR=en;
			int k,k1;
			long inv=0;
			//System.out.println(sL+" "+eL+" "+sR+" "+eR);
			for(k=0;k<en-st+1;k++) {
				//System.out.println("---"+sL+" "+sR+" "+N[sL]+" "+N[sR]);
				if(sL>eL) {
					temp[k]=N[sR++];
				}
				else if(sR>eR) {
					temp[k]=N[sL++];
				}
				else {
					if(N[sL]<=N[sR]) {
						temp[k]=N[sL];
						sL++;
					}
					else {
						temp[k]=N[sR];
						sR++;
						inv+=eL-sL+1;
					}
				}
			}
			for(k=0,k1=st;k<=en-st;k++,k1++) N[k1]=temp[k];
			//System.out.println(st+" "+en+" "+invL+" "+invR+" "+inv);
			return invL+invR+inv;
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		int N[] = new int[100000],i=0;
		File F = new File("/home/sabanerjee/Eclipse/workspace/courseera/src/algorithms/week1/input.txt");
		Scanner in = new Scanner(F);
		while(in.hasNextInt()) {
			N[i++] = in.nextInt();
		}
		int tN[] = {4,3,5,1,2};
		System.out.println(sortAndCountInversions(N,0,99999));
	}

}
