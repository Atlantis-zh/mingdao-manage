package com.mingdao.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by Administrator on 2017/10/28.
 */
public class DataUtil {   

    public static JSONArray list2JsonArray(List list){
        JSONArray array = new JSONArray();
        if(list==null ||list.size()==0){
            return array;
        }

        for(int i=0;i<list.size();i++){
            JSONObject object =(JSONObject) JSONObject.toJSON(list.get(i));
            array.add(object);
        }
        return array;
    }
}
