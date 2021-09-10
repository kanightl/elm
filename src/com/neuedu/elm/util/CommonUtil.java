package com.neuedu.elm.util;

import javafx.scene.input.DataFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {
    public static   String  getCurrentDate(){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date d=new Date();
        return sf.format(d);
    }
}
