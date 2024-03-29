package 프로그래머스course2_3;

import java.util.ArrayList;
import java.util.Collections;

public class Test_후보키 {
  static ArrayList<String> A;
  static String[][] relations;
	public static void main(String[] args) {
    int answer =0;  
    String [][] relation = { {"a","1","aaa","c","ng"}
    ,{"b","1","bbb","c","g"}
    ,{"c","1","aaa","d","ng"},{"d","2","bbb","d","ng"}};
    A = new ArrayList<>();
    relations = relation;
    for(int i=0;i<relations[0].length;i++){
        DFS(i,""+i);
    }
    Collections.sort(A,(o1,o2)->{
    	return o1.length()-o2.length();
    });
    while(A.size()!=0){
       String sample [] = new String [relations.length];
        for(int i=0;i<sample.length;i++){
            sample[i] = "";
        }
        String strs = A.get(0);
        for(int i=0;i<strs.length();i++){
            int sub = Integer.parseInt(strs.substring(i,i+1));
            for(int j=0;j<relations.length;j++){
                sample[j] += relations[j][sub];
            }
        }
        int sw = 0;
        for(int i=0;i<sample.length;i++){
            for(int j=i+1;j<sample.length;j++){
                if(sample[i].equals(sample[j])){
                    sw=1;
                }
            }
        }
        if(sw==1){
            A.remove(0);
        }
        else{
        	System.out.println(strs);
            answer++;
            A.remove(0);
              for(int j=0;j<A.size();j++){
              	int sum =0;
                	for(int i=0;i<strs.length();i++){
                		String sub = strs.substring(i,i+1);
                    if(A.get(j).contains(sub)&&A.get(j).length()>strs.length()) {
                    		sum++;
                    }
                }
                if(sum==strs.length()) {
                	A.remove(j);
                	j--;
                }
            }
        }
    }
    System.out.println(answer);
	}
	  private static void DFS(int now,String str){
	    if(A.contains(str))return;
	    A.add(str);
	    for(int i = now+1 ;i <relations[0].length;i++){
	        DFS(i,str+i);
	    }
	}
}
