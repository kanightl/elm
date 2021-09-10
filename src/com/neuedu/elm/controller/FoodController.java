package com.neuedu.elm.controller;

import com.neuedu.elm.entity.Food;
import com.neuedu.elm.service.FoodService;
import com.neuedu.elm.service.FoodServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FoodController {
    private FoodService service=new FoodServiceImpl();

    //http://localhost:8890/elm/FoodController/listFoodByBusinessId?businessId=1
    public List<Food> listFoodByBusinessId(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String businessId=req.getParameter("businessId");
        Integer businessId2=null;
        if (businessId!=null && !"".equals(businessId)){
            businessId2=Integer.valueOf(businessId);
        }

        List<Food> list=service.listFoodByBusinessId(businessId2);
        return list;
    }
}
