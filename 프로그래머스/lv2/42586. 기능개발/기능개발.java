import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> list = new ArrayList<>();
		int sw =-1;int su =0;int sum =0;
		while(sw==-1) {
			Queue<Integer> que = new LinkedList<Integer>();
			sw =0;
			for(int i=0;i<progresses.length;i++) { //작업량 모두 증가
				progresses[i] = speeds[i]+progresses[i];
				que.add(progresses[i]);
				if(progresses[i]<100)sw=-1;
			}
			su =0;
			while(!que.isEmpty()) {
				if(que.poll()<100) break;
				su ++;
			}
			if(su-sum!=0) { 
				list.add(su-sum);
				sum+=su-sum;
			}
		}
		int [] answer = new int [list.size()];
		for(int i=0;i<list.size();i++) {
			answer[i]= list.get(i);
		}
        return answer;
    }
}