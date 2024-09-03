package DailyCodeChallenge.Level_1;

import java.util.HashMap;
import java.util.PriorityQueue;

class Pair_usage {
    static class Pair implements Comparable<Pair>{
        int val,freq;
        Pair(int val,int freq){
            this.val=val;
            this.freq=freq;
        }
        public int compareTo(Pair o){
            return o.freq-this.freq;
        }
    }
    public long maximumImportance(int n, int[][] roads) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int road[]:roads){
            hm.put(road[0],hm.getOrDefault(road[0],0)+1);
            hm.put(road[1],hm.getOrDefault(road[1],0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int key:hm.keySet()){
            pq.add(new Pair(key, hm.get(key)));
        }
        long ans=0;
        while(pq.size()>0){
            Pair pair=pq.remove();
            map.put(pair.val,n);
            n--;
        }
        for(int road[]:roads){
            ans+=map.get(road[0]);
            ans+=map.get(road[1]);
        }
        return ans;
    }
}

