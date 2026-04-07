import java.util.*;

public class Solution12 {
    /**
     * 删除字符中的所有相邻重复项（easy）
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {

        StringBuffer ret = new StringBuffer();

        char[] ch = s.toCharArray();

        for(char c : ch){

            if(ret.length() > 0 && ret.charAt(ret.length() - 1) == c ){
                ret.deleteCharAt(ret.length() - 1);
            }else{
                ret.append(c);
            }
        }

        return new String(ret);
    }

    /**
     * ⽐较含退格的字符串（easy）
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        return changeStr(s).equals(changeStr(t));
    }
    public String changeStr(String s){
        StringBuffer st = new StringBuffer();

        char[] ch = s.toCharArray();

        for(char c : ch){
            if(c == '#'){        // 只要是退格
                if(!st.isEmpty()){ // 且不为空才删
                    st.deleteCharAt(st.length() - 1);
                }
            }else{
                st.append(c);  // 不是 # 才添加
            }
        }
        return new String(st);
    }

    /**
     * 基本计算器 II（medium）
     * @param s
     * @return
     */
    public int calculate(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        char c = '+';
        char[] ch = s.toCharArray();
        int n = ch.length;
        int i = 0;
        while( i < n){
            if(ch[i] == ' '){
                i++;
            }else if(ch[i] >= '0' && ch[i] <= '9'){
                int tmp = 0;
                while(i < n && ch[i] >= '0' && ch[i] <= '9'){
                    tmp = tmp*10 + (ch[i] - '0');
                    i++;
                }
                if(c == '+'){
                    st.push(tmp);
                }else if(c == '-'){
                    st.push(-tmp);
                }else if(c == '*'){
                    st.push(st.pop() * tmp);
                }else if(c == '/'){
                    st.push(st.pop() / tmp);
                }
            }else{
                c = ch[i];
                i++;
            }
        }
        int ret = 0;
        while(!st.isEmpty())
        {
            ret += st.pop();
        }
        return ret;
    }

    /**
     * 字符串解码（medium）
     * @param s
     * @return
     */
    public String decodeString(String s) {

        Stack<StringBuffer> st = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        st.push(new StringBuffer()); // 先放⼀个空串进去

        char[] ch = s.toCharArray();
        int n = ch.length;
        int i = 0;
        while(i < n){
            if(ch[i] >= '0' && ch[i] <= '9'){
                int tmp = 0;
                while(i < n && ch[i] >= '0' && ch[i] <= '9'){
                    tmp = tmp*10 + (ch[i] - '0');
                    i++;
                }
                nums.push(tmp);
            }else if(ch[i] == '['){
                StringBuffer str = new StringBuffer();
                i++;
                while(ch[i] >= 'a' && ch[i] <= 'z' && i < n){
                    str.append(ch[i]);
                    i++;
                }
                st.push(str);
            }else if(ch[i] == ']'){
                int k = nums.pop();
                StringBuffer tmp = st.pop();

                while(k-- != 0){
                    st.peek().append(tmp);
                }
                i++;
            }else{
                StringBuffer tmp = new StringBuffer();
                while(i < n && ch[i] <= 'z' && ch[i] >='a'){
                    tmp.append(ch[i]);
                    i++;
                }
                st.peek().append(tmp);
            }
        }
        return st.peek().toString();
    }

    /**
     * 验证栈序列（medium）
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i = 0, n = popped.length;
        for(int x : pushed){
            st.push(x);
            while(!st.isEmpty() && st.peek() == popped[i]){
                st.pop();
                i++;
            }
        }
        return i == n;
    }
}
