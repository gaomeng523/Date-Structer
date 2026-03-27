import java.util.Map;
import java.util.TreeMap;

public class TestMap {



    public static void main(String[] args) {
        Map<String , String> map = new TreeMap<>();
        //put插入方法
        map.put("林冲" , "豹子头");
        map.put("鲁智深", "花和尚");
        map.put("武松", "⾏者");
        map.put("宋江", "及时⾬");
        String str = map.put("李逵", "⿊旋⻛");

        System.out.println(map.size());
        System.out.println(map);


        System.out.println(map.get("鲁智深"));
        System.out.println(map.get("史进"));
        //getOrDefault() : 如果key存在 ， 返回与key对应的value ， 如果key不存在 ， 返回一个后面的默认值
        System.out.println(map.getOrDefault("李逵" , "铁牛"));
        System.out.println(map.getOrDefault("史进" , "九纹龙"));

        //containKey(key)：检测key是否包含在Map中，时间复杂度：O(logN)
        // 按照红⿊树的性质来进⾏查找
        // 找到返回true，否则返回false
        System.out.println(map.containsKey("林冲"));
        System.out.println(map.containsKey("史进"));

        // containValue(value): 检测value是否包含在Map中，时间复杂度: O(N)
        // 找到返回true，否则返回false
        System.out.println(map.containsValue("豹⼦头"));
        System.out.println(map.containsValue("九纹⻰"));

        // 打印所有的key
        // keySet是将map中的key防⽌在Set中返回的
        for(String s : map.keySet()){
            System.out.print(s + " ");
        }
        System.out.println();

        // 打印所有的value
        // values()是将map中的value放在collect的⼀个集合中返回的
        for(String s : map.values()){
            System.out.print(s + " ");
        }
        System.out.println();

        // 打印所有的键值对
        // entrySet(): 将Map中的键值对放在Set中返回了
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
        System.out.println();

    }
}
