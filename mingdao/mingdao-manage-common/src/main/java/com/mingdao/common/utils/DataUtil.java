package com.mingdao.common.utils;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by Administrator on 2017/10/28.
 */
public class DataUtil {

  public static JSONArray list2JsonArray(List list) {
    JSONArray array = new JSONArray();
    if (list == null || list.size() == 0) {
      return array;
    }
    for (int i = 0; i < list.size(); i++) {
      JSONObject object = (JSONObject) JSONObject.toJSON(list.get(i));
      array.add(object);
    }
    return array;
  }

  public static JSONObject superVOToJsonObject(Object obj) {
    JSONObject object = (JSONObject) JSONObject.toJSON(obj);
    return object;
  }
}
