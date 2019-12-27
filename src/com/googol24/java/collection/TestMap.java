package com.googol24.java.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map接口
 *
 *      实现Map接口的类用来存储键-值对
 *          -> 注：容器主要包括 Collection 和 Map 两种
 *      Map接口的实现类有HashMap TreeMap等
 *      Map接口实现类中存储的键-值对通过键来标识，所以键不能重复（重复：也即hashCode() 相同，因为比较hashCode比比较equals慢）
 *
 *      常见的Map API
 *          -> Object put(Object key, Object value)
 *          -> Object get(Object key)
 *          -> Object remove(Object key)
 *          -> boolean containsKey(Object key)
 *          -> boolean containsValue(Object value)
 *          -> int size() // map容器中键值对的对数
 *          -> boolean isEmpty()
 *          -> void putAll(Map m)
 *          -> void clear()
 *
 *     Auto-boxing/unboxing 在合适的时机自动打包/解包[JDK 1.5版本之后才支持]
 *          自动打包：自动将基础数据类型转换为对象
 *          自动解包：自动将对象转换为基础数据类型
 *
 */
public class TestMap {
    public static void main(String[] args) {System.out.println(new String("aaa").toString());
        Map map1 = new HashMap();
        Map map2 = new TreeMap();

        map1.put("one", new Integer(1));
        map1.put("two", new Integer(2));
        map1.put("three", new Integer(3));
        map1.put("four", 4);// JDK 1.5以后支持的写法（自动把4打包Integer对象）

        map2.put("A", new Integer(1));
        map2.put("B", new Integer(2));

        System.out.println(map1.size());
        System.out.println(map1.containsKey("one"));
        System.out.println(map2.containsValue(new Integer(1)));
        System.out.println(map2.containsValue(3));// 3自动打包成Integer对象

        if (map1.containsKey("two")) {
//            int i = Integer.parseInt(map1.get("two").toString());
            int i = ((Integer)map1.get("two")).intValue();
            System.out.println(i);

            int j = (Integer)map1.get("two");// 自动解包需要强制转换
            System.out.println(j);
        }

        // Constructs a new HashMap with the same mappings as the specified Map： map1
        Map map3 = new HashMap(map1);
        map3.putAll(map2);

        System.out.println(map3);

    }
}
