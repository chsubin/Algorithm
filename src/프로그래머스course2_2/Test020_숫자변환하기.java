package 프로그래머스course2_2;

import java.util.LinkedList;
import java.util.Queue;

public class Test020_숫자변환하기 {
	static boolean [] visited = new boolean[1000001];
	static int answer = 0;
	public static void main(String[] args) {
		int x = 2;
		int y = 1000000;
		int n = 4;
		
		BFS(x,y,n);
		System.out.println(answer);
		
	}

	private static void BFS(int x, int target, int n) {
		Queue<T020> queue = new LinkedList<>();
		queue.add(new T020(x, 0));
		visited[x] = true;
		while(!queue.isEmpty()) {
			T020 test = queue.poll();
			int a = test.su;
			int b = test.depth;
			if(test.su==target) {
				answer = b;
				return;
			}
			if(a<=1000000-n) {
				if(!visited[a+n]&&a+n<=target) {
					queue.add(new T020(a+n, b+1));
					visited[a+n] = true;
				}
			}
			if(a<=1000000/2) {
				if(!visited[a*2]&&a*2<=target) {
					queue.add(new T020(a*2, b+1));
					visited[a*2] = true;
				}
			}
			if(a<=1000000/3) {
				if(!visited[a*3]&&a*3<=target) {
					queue.add(new T020(a*3, b+1));
					visited[a*3] = true;
				}
			}
		}
	}
}
class T020{
	int su;
	int depth;
	
	public T020(int su, int depth) {
		this.su = su;
		this.depth = depth;
	}
}
