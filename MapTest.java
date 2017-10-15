import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/*
* hashMap的测试
* 使用get就可以获取key所对应的Value
* 如果不知道有哪些key,则可以使用迭代器.
*
* */
public class MapTest {
    public static void test1(){
        HashMap <String, String> hm1 = new HashMap <String, String>();
        //HashMap <String, String> hm2 = new HashMap <String, String>();
        hm1.put("int", "1");
        hm1.put("float", "1.0f");
        hm1.put("double", "1.0d");
        System.out.println(""+hm1.get("float"));
        Iterator iter = hm1.entrySet().iterator();//使用迭代器来遍历Map
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key: "+key+"->Value: "+value);
        }

    }

    public static void main(String[] args) {
        test1();
    }
}