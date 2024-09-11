package com.rasion.map;

import java.security.Key;
import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        calc();
    }
    public static void calc(){
        List<String> location=new ArrayList<>();
        String[] locat={"北京","上海","广州","深圳"};
        Random random=new Random();
        for(int i=1;i<=80;i++){
            int index=random.nextInt(locat.length);
            location.add(locat[index]);
        }
//        System.out.println(location);

        //最终统计为键值对集合
        Map<String,Integer> map=new HashMap<>();
        for(String str:location){
            if(map.containsKey(str)){//判断是否包含键
                map.put(str,map.get(str)+1);
            }else{
                map.put(str,1);//键不存在，添加键值对
            }
        }
        map.forEach((k,v)-> System.out.println(k+":"+v));

        //选出最多的城市
        Collection<Map.Entry<String,Integer>> col=map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator=col.iterator();//collection的迭代器
        while(iterator.hasNext()){
            Map.Entry<String,Integer> entry=iterator.next();
            if(entry.getValue()==Collections.max(map.values())){
                System.out.println("投票最多的城市是："+entry.getKey());
            }
        }
    }
}
