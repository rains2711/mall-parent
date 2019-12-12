package com.wx.disparent.mallparent.commons.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class PageUtil {

    public static Map<String,Object> getPageInfo(HttpServletRequest request){

        Map<String,Object> paraMap = new HashMap<String,Object>();
        int pageSize =  request.getParameter("pageSize") ==null ? 10 : Integer.valueOf(request.getParameter("pageSize"));
        int pageNum = request.getParameter("pageNum")==null ? 1 :Integer.valueOf(request.getParameter("pageNum"));
        paraMap.put("pageSize",pageSize) ;
        paraMap.put("pageNum",pageNum) ;
        return  paraMap ;

    }


    /**
     * 主要用于返回页面信息
     * @param request
     * @param type
     * @return
     */
    public static int getPage(HttpServletRequest request,String type){

        int pageSizeOrPageNum = 0 ;
        if(type.equals("pageSize")){
            pageSizeOrPageNum =  request.getParameter("pageSize") ==null ? 10 : Integer.valueOf(request.getParameter("pageSize"));
        }else if(type.equals("pageNum")){
            pageSizeOrPageNum =  request.getParameter("pageNum") ==null ? 10 : Integer.valueOf(request.getParameter("pageNum"));
        }
        return  pageSizeOrPageNum ;
    }




}
