package uk.co.argon.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(leastInterval(getArray(), 3));
	}
	
	private static int leastInterval(char[] tasks, int n) {
        int val=0, s=0, elem=0, elemP=0;
        
        if(tasks.length!=0) {
        	Map<Character, Integer> t = new HashMap<>();
            
            for(Character c: tasks) {
            	if(t.containsKey(c))
            		t.put(c, t.get(c)+1);
            	else
            		t.put(c, 1);
            }
            
            Comparator<Map.Entry<Character, Integer>> comp = Comparator.comparingInt(Map.Entry::getValue);
            Queue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(comp.reversed());
            t.entrySet().forEach(e->q.add(e));
            
            
            while(!q.isEmpty()) {
            	elem = q.poll().getValue();
            	System.out.println(elem);
            	s = (elem -1)*n;
            	val = (elemP<=s)? (elem + s):(elem + elemP);
            	elemP +=elem;
            }
        }
        
        return val;
    }
	
	private static char[] getArray() {
		//return new char[] {};
		return new char[] {'A','A','A','B','B','B'};
		//return new char[] {'A','A','A','B','B','B','B','C','C','C','C'};
		//return new char[] {'A','A','B','B','B','C','C','C','C','D','D','D','D','D','D','E','E','E','E','E','E','E'};
	}

}
