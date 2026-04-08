import java.util.*;

public class Greedy_algorithm {
    /**
     *柠檬⽔找零（easy） https://leetcode.cn/problems/lemonade-change/
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0 , ten = 0;
        for(int x : bills){
            if(x == 5){
                five++;
            }else if(x == 10){
                if(five != 0){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }else{
                if(ten != 0 && five != 0){
                    ten--; five--;
                }else if(five >= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 将数组和减半的最少操作次数（medium） https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/submissions/716407600/
     * @param nums
     * @return
     */
        public int halveArray(int[] nums) {
            // 1. 修正比较器：使用Double.compare，匹配队列泛型
            PriorityQueue<Double> qu = new PriorityQueue<>((a, b) -> Double.compare(b, a));
            long sum = 0; // 用long避免int溢出
            for (int x : nums) {
                sum += x;
                // 2. 显式转换为double后入队，彻底解决类型问题
                qu.offer((double) x);
            }

            double target = sum / 2.0;
            double reduced = 0.0;
            int ret = 0;

            while (reduced < target) {
                double m = qu.poll();
                double half = m / 2.0;
                reduced += half;
                qu.offer(half);
                ret++;
            }
            return ret;
        }

    /**
     * 最⼤数（medium）https://leetcode.cn/problems/largest-number/
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] str = new String[n];

        for(int i = 0 ; i < n ; i++){
            str[i] = "" + nums[i];
        }

        Arrays.sort(str , (a , b) -> {
            return (b + a).compareTo(a + b);
        });


        StringBuffer ret = new StringBuffer();
        for(String m : str){
            ret.append(m);
        }

        if(ret.charAt(0) == '0') return "0";
        return ret.toString();
    }

    /**
     * 摆动序列  https://leetcode.cn/problems/wiggle-subsequence/
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n < 2) return 1;
        int ret = 1;
        int left = 0 , right = 0;

        for(int i = 0 ; i < n - 1 ; i++){
            right = nums[i + 1] - nums[i];
            if(right == 0) continue;
            if(left * right <= 0) ret++;
            left = right;
        }
        return ret;
    }


}

