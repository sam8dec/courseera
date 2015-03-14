package algorithms.week5;

/*
This is a terrible implementation of the algorithm and doesn't scale. This was a short cut to finishing the assignment on time. Do not use it in practice!
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dijkstra {
	public static int G[][] = new int[201][201];
	public static int shortestPathLength[] = new int[201];
	public static int priorityQueue[] = new int[201];
	public static boolean visited[] = new boolean[201];
	public static int size(int priorityQueue[]) {
		int siz=0;
		for(int i=1;i<=200;i++) if(priorityQueue[i]!=0) siz++;
		return siz;
	}
	public static int extractMin(int priorityQueue[]) {
		int MIN=1000000,midx=0;
		for(int i=1;i<=200;i++) if(priorityQueue[i]!=0 && priorityQueue[i]<MIN) {MIN=priorityQueue[i];midx=i;}
		return midx;
	}
	public static void main(String[] args) throws FileNotFoundException {
		int i,j;
		File F = new File("/home/sabanerjee/Eclipse/workspace/courseera/src/algorithms/week5/input.txt");
		Scanner in = new Scanner(F);
		while(in.hasNextLine()) {
			String info = in.nextLine();
			Scanner in2 = new Scanner(info);
			j=in2.nextInt();
			while(in2.hasNext()) {
				String[] ATH = in2.next().split(",");
				G[j][Integer.parseInt(ATH[0])]=Integer.parseInt(ATH[1]);
			}
		}
		//System.out.println(G[200][54]);
		for(i=2;i<=200;i++) shortestPathLength[i] = 1000000;
		visited[1]=true;
		for(i=1;i<=200;i++) if(G[1][i]!=0) priorityQueue[i]=G[1][i];
		while(size(priorityQueue)!=0) {
			System.out.println(size(priorityQueue));
			j=extractMin(priorityQueue);
			System.out.println("--"+j+" "+priorityQueue[j]);
			visited[j]=true;
			shortestPathLength[j]=priorityQueue[j];
			priorityQueue[j]=0;
			for(i=1;i<=200;i++) {
				if(G[j][i]!=0 && !visited[i]) {
					if(priorityQueue[i]!=0) {
						if(shortestPathLength[j]+G[j][i]<priorityQueue[i]) priorityQueue[i]=shortestPathLength[j]+G[j][i];
					} else {
						priorityQueue[i]=shortestPathLength[j]+G[j][i];
					}
				}
			}
		}
		System.out.println(shortestPathLength[1]+","+shortestPathLength[7]+","+shortestPathLength[37]+","+shortestPathLength[59]+","+shortestPathLength[82]+","+shortestPathLength[99]+","+shortestPathLength[115]+","+shortestPathLength[133]+","+shortestPathLength[165]+","+shortestPathLength[188]+","+shortestPathLength[197]+",");
	}

}
