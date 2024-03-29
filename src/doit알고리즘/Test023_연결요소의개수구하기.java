package doit알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Test023_연결요소의개수구하기 {
	static ArrayList<Integer>[] A; //연결 노드의 컬렉션을 집합으로 저장!
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[n+1];
		visited = new boolean [n+1];
		
		for(int i=1;i<n+1;i++) {
			A[i] = new ArrayList<>();
		}
		
		for(int i =1;i<m+1;i++) {
			st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			A[j].add(k);
			A[k].add(j);
		}
		int count = 0;
		for(int i=1;i<n+1;i++) {
			if(!visited[i]) {
				count++;
				DFS(i);
			}
		}
		System.out.println(count);
	}
 
	private static void DFS(int v) {
		if(visited[v]) return;
		visited[v] = true;
		for(int i : A[v]) {
			if(!visited[i])DFS(i);
		}
	}
}
