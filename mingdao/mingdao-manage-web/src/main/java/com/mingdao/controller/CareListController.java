package com.mingdao.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IUserInfoBaseServiceItf;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.common.utils.HttpRequest;
import com.mingdao.domain.CareUser;
import com.mingdao.domain.ResultMessage;
import com.mingdao.domain.UserInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * <code>UserInfoBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月25日 上午3:45:32
 * @author libin
 */
@Controller
@RequestMapping("/carList")
public class CareListController extends BaseController {

  private static final String TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
  private static final String APPID="wx10f2d9caa94df544";
  private static final String APPSECRET="22b416fcc1e4504105dfcd9623fbbeba";
  private static final String USER_LIST_URL="https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
  private static final String USER_INFO_URL="https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

  @Autowired
  private IUserInfoBaseServiceItf uiBaseService;

  
  @RequestMapping("carLists")
  @ResponseBody
  public JSONObject getUserInfo(HttpServletRequest request){
      String pageStr = request.getParameter("page");
      int page = Integer.valueOf(pageStr);
      JSONObject reulst = new JSONObject();
      String token =  getTokenUrl();
      Map<Integer,JSONArray> data= getUserIds(token);
      JSONArray list = getCarUserList(data,page,token);
      reulst.put("data",list);
    return reulst;
  }


  private static String getTokenUrl(){
    String requestUrl = TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
    String token = HttpRequest.sendGet(requestUrl,null);
    JSONObject jsonObject = JSONObject.parseObject(token);
    return jsonObject.getString("access_token");
  }

  private static Map<Integer,JSONArray> getUserIds(String token){
    String requestUrl = USER_LIST_URL.replace("ACCESS_TOKEN", token).replace("NEXT_OPENID", "");
    String userList = HttpRequest.sendGet(requestUrl,null);
    JSONObject jsonObject = JSONObject.parseObject(userList);
    JSONArray array =  jsonObject.getJSONObject("data").getJSONArray("openid");
    Map<Integer,JSONArray> data = new HashMap<>();
    int page = array.size()/10 + 1;
    for(int k=0;k<page;k++){
      JSONArray userIds = new JSONArray();
      for(int i=0;i<array.size();i++){
        if(i/10==k){
          userIds.add(array.getString(i));
        }
      }
      data.put(k+1,userIds);
    }
    return data;
  }

  private static JSONArray getCarUserList(Map<Integer,JSONArray> data,int position,String token){
      JSONArray curPageInfo = data.get(position);
      JSONArray list = new JSONArray();
      for(int i=0;i<curPageInfo.size();i++){
        String openid = curPageInfo.getString(i);
        String requestUrl = USER_INFO_URL.replace("ACCESS_TOKEN", token).replace("OPENID", openid);
        String userList = HttpRequest.sendGet(requestUrl,null);
        userList = filterEmoji(userList);
        JSONObject jsonObject = JSONObject.parseObject(userList);
        CareUser user = new CareUser();
        user.setCity(jsonObject.getString("city"));
        user.setCountry(jsonObject.getString("country"));
        user.setSex(jsonObject.getInteger("sex"));
        user.setHeadimgurl(jsonObject.getString("headimgurl"));
        user.setNickname(jsonObject.getString("nickname"));
        user.setOpenid(jsonObject.getString("openid"));
        user.setSubscribe(jsonObject.getInteger("subscribe"));
        user.setSubscribe_time(jsonObject.getString("subscribe_time"));
        list.add(user);
      }
    return list;
  }


  public static String filterEmoji(String source) {
    if (source == null) {
      return source;
    }
    Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
            Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
    Matcher emojiMatcher = emoji.matcher(source);
    if (emojiMatcher.find()) {
      source = emojiMatcher.replaceAll("*");
      return source;
    }
    return source;
  }

    public static void main(String[] args){
    String token =  getTokenUrl();
    String requestUrl = USER_LIST_URL.replace("ACCESS_TOKEN", token).replace("NEXT_OPENID", "");
    String userList = HttpRequest.sendGet(requestUrl,null);
    JSONObject jsonObject = JSONObject.parseObject(userList);
    JSONArray array =  jsonObject.getJSONObject("data").getJSONArray("openid");
    Map<Integer,JSONArray> data = new HashMap<>();
    int page = array.size()/10 + 1;
    for(int k=0;k<page;k++){
      JSONArray userIds = new JSONArray();
      for(int i=0;i<array.size();i++){
        if(i/10==k){
          userIds.add(array.getString(i));
        }
      }
      data.put(k+1,userIds);
    }
    System.out.println(data);
  }

}
