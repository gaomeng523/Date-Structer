import java.util.*;

public class Solution14 {

    /**
     * 最后⼀块⽯头的重量（easy）
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pr = new PriorityQueue<>((a , b) -> b - a);
        for(int x : stones){
            pr.offer(x);
        }
        while(pr.size() > 1){
            int m = pr.poll();
            int n = pr.poll();
            if(m  > n){
                pr.offer(m - n);
            }
        }
        return pr.isEmpty() ? 0 : pr.poll();
    }

    /**
     * 数据流中的第 K ⼤元素（easy）
     */
    PriorityQueue<Integer> qu;
    int k;
    public void KthLargest(int k, int[] nums) {
        this.k = k;
        qu = new PriorityQueue<>();

        for(int x : nums){
            if(qu.size() < k) qu.offer(x);
            else{
                if(qu.peek() < x){
                    qu.poll();
                    qu.offer(x);
                }
            }
        }
    }

    public int add(int val) {
        if(qu.size() < k) qu.offer(val);
        else{
            if(qu.peek() < val){
                qu.poll();
                qu.offer(val);
            }
        }
        return qu.peek();
    }

    /**
     * 前 K 个⾼频单词 （medium）
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String , Integer> hash = new HashMap<>();

        for(String s : words){
            hash.put(s , hash.getOrDefault(s , 0) + 1);
        }

        PriorityQueue<Solution13.Pair<String, Integer>> pr = new PriorityQueue<>(
                (a , b) -> {
                    if(a.getValue().equals(b.getValue())){
                        return b.getKey().compareTo(a.getKey());
                    }
                    return a.getValue() - b.getValue();
                }
        );

        for(Map.Entry<String , Integer> e : hash.entrySet()){
            pr.offer(new Solution13.Pair<>(e.getKey() , e.getValue()));
            if(pr.size() > k){
                pr.poll();
            }
        }

        List<String> ret = new ArrayList<>();

        while(!pr.isEmpty()){
            ret.add(pr.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }



}
