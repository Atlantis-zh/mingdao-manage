package com.mingdao.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IUserInfoBaseServiceItf;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.common.utils.DateUtil;
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
import java.text.SimpleDateFormat;
import java.util.*;
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
@RequestMapping("/careList")
public class CareListController extends BaseController {



  @Autowired
  private IUserInfoBaseServiceItf uiBaseService;

  
  @RequestMapping("careLists")
  public String getUserInfo(Model model,HttpServletRequest request,Pager pager){
      int page=0;
      String pageStr = request.getParameter("page");
      String count =request.getParameter("pager.offset");
      if(StringUtils.isEmpty(pageStr)){
          page = (Integer.valueOf(count)/10) +1;
      }
      if(StringUtils.isEmpty(count)){
        page = Integer.valueOf(pageStr);
      }
      JSONObject reulst = new JSONObject();
      String token =  getTokenUrl();
      Map<Integer,JSONArray> data= getUserIds(token);
      int cout = getUserCount(token);
      JSONArray list = getCarUserList(data,page,token);
      Pager<CareUser> data1 = new Pager(cout,list.toJavaList(CareUser.class));
      data1.setSize(10);
      reulst.put("data",list);
      model.addAttribute("datas", data1);
    return "careList/list";
  }


  private  String getTokenUrl(){
    String TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    String APPID="wx10f2d9caa94df544";
    String APPSECRET="22b416fcc1e4504105dfcd9623fbbeba";
    String requestUrl = TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
    String token = HttpRequest.sendGet(requestUrl,null);
    JSONObject jsonObject = JSONObject.parseObject(token);
    return jsonObject.getString("access_token");
  }


  private  int getUserCount(String token){
    String USER_LIST_URL="https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
    String requestUrl = USER_LIST_URL.replace("ACCESS_TOKEN", token).replace("NEXT_OPENID", "");
    String userList = HttpRequest.sendGet(requestUrl,null);
    JSONObject jsonObject = JSONObject.parseObject(userList);
    JSONArray array =  jsonObject.getJSONObject("data").getJSONArray("openid");
    return  array.size();
  }

  private  Map<Integer,JSONArray> getUserIds(String token){
    String USER_LIST_URL="https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
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

  private  JSONArray getCarUserList(Map<Integer,JSONArray> data,int position,String token){
    String USER_INFO_URL="https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    JSONArray curPageInfo = data.get(position);
      JSONArray list = new JSONArray();
      for(int i=0;i<curPageInfo.size();i++){
        String openid = curPageInfo.getString(i);
        String requestUrl = USER_INFO_URL.replace("ACCESS_TOKEN", token).replace("OPENID", openid);
        String userList = HttpRequest.sendGet(requestUrl,null);
        JSONObject jsonObject = JSONObject.parseObject(userList);
        CareUser user = new CareUser();
        user.setCity(jsonObject.getString("city"));
        user.setCountry(jsonObject.getString("country"));
        user.setSex(jsonObject.getInteger("sex"));
        user.setHeadimgurl(jsonObject.getString("headimgurl")+".jpg");
        user.setNickname(jsonObject.getString("nickname"));
        user.setOpenid(jsonObject.getString("openid"));
        user.setSubscribe(jsonObject.getInteger("subscribe"));
        user.setSubscribe_time(getTimeString(jsonObject.getString("subscribe_time")));
        list.add(user);
      }
    return list;
  }





  private static String getTimeString(String time){
    long l = Long.valueOf(time+"000");
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    String date = simpleDateFormat.format(new Date(l));
    return date;
  }

    public static void main(String[] args){
  /*  String token =  getTokenUrl();
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
      getCarUserList(data,1,token);
    System.out.println(data);*/

     /* long l = Long.valueOf("1490583149000");
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      String date = simpleDateFormat.format(new Date(l));
      System.out.println(date);*/
      CareListController test=new CareListController();
      String token =  test.getTokenUrl();
      String USER_LIST_URL="https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
      String requestUrl = USER_LIST_URL.replace("ACCESS_TOKEN", token).replace("NEXT_OPENID", "");
      System.out.println(requestUrl);
  }

}
