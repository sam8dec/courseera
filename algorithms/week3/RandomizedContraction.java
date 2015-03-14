package algorithms.week3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.javatuples.Pair;

public class RandomizedContraction {
	public static int findMinCutThroughContraction(List<List<Integer>> G) {
		List<Pair<Integer,Integer>> edges = new ArrayList<Pair<Integer,Integer>>();
		while(G.size()>2) {
			edges.clear();
			//System.out.println(G.size());
			for(List<Integer> node : G) {
				//System.out.println("-"+node);
				for(int i=1;i<node.size();i++) {
					Pair<Integer,Integer> p = new Pair<Integer,Integer>(node.get(0),node.get(i));
					edges.add(p);
				}
			}
			//System.out.println("Done - "+edges.size());
			Random rand = new Random(System.currentTimeMillis());
			//System.out.println(edges.size());
			int j,randEdge = rand.nextInt(edges.size()), node1, node2, node1_idx=0, node2_idx=0;
			node1 = edges.get(randEdge).getValue0();
			node2 = edges.get(randEdge).getValue1();
			for(j=0;j<G.size();j++) {
				if(G.get(j).get(0).equals(node1)) node1_idx=j;
				if(G.get(j).get(0).equals(node2)) node2_idx=j;
			}
			if(node1==node2) {
				System.out.println(G.get(node1_idx));
			}
			//System.out.println(node1+" "+node2+" "+node1_idx+" "+node2_idx);
			List<Integer> L1 = G.get(node1_idx);
			List<Integer> L2 = G.get(node2_idx);
			for(int i=1;i<L2.size();i++) {
				int n=L2.get(i);
				L1.add(n);
			}
			//System.out.println(G.get(node1_idx));
			List<List<Integer>> G1 = new ArrayList<List<Integer>>();
			for(List<Integer> al : G) {
				if(al.get(0).equals(node2)) continue;
				List<Integer> node_copy = new ArrayList<Integer>();
				node_copy.add(al.get(0));
				for(int k=1;k<al.size();k++) {
					if(al.get(k).equals(al.get(0))) continue;
					if(al.get(k).equals(node2)) {
						if(!al.get(0).equals(node1)) node_copy.add(node1);
					}
					else node_copy.add(al.get(k));
				}
				G1.add(node_copy);
			}
			//if(node2<node1) node1_idx--;
			//System.out.println(G1.get(node1_idx));
			G.clear();
			G=G1;
		}
		System.out.println(G.get(0)+"\n"+G.get(1));
		//if(G.get(0).size()!=G.get(1).size()) return -1;
		return G.get(0).size()-1;
	}
	public static void main (String[] args) throws FileNotFoundException {
		int i=0,j,min=999999999,k;
			for(k=1;k<=200;k++) {
			List<List<Integer>> G = new ArrayList<List<Integer>>();
			File F = new File("/home/sabanerjee/Eclipse/workspace/courseera/src/algorithms/week3/input.txt");
			Scanner in = new Scanner(F);
			while(in.hasNextLine()) {
				i++;
				String s = in.nextLine();
				List<Integer> adjlist = new ArrayList<Integer>();
				Scanner adjin = new Scanner(s);
				while(adjin.hasNextInt()) {
					adjlist.add(adjin.nextInt());
				}
				G.add(adjlist);
			}
			j=findMinCutThroughContraction(G);
			if(j<min) min=j;
			System.out.println(k+" "+j);
		}
		System.out.println(min);
	}
}
