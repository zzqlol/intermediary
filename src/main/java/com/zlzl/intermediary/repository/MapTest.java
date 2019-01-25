package com.zlzl.intermediary.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        List<Object> list=new ArrayList<Object>();
        Map<Integer,Object> map=new HashMap<Integer, Object>();
        for(int i=0;i<3;i++){
            list.add(i);
            map.put(i,list);
        }

    }
}
