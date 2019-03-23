package com.csp.Utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 敏感词集合
 */
public class WordsUtil {
    private static List<String> list = new ArrayList<>();
    static {
        list.add("中共中央");
        list.add("昆山龙哥");
        list.isEmpty();

    }

    public static List<String> getWords(){

        String str = "fds";


        StringUtils.isNotBlank(str);
        StringUtils.isNotEmpty(str);
        //StringUtils.substring();
        //StringUtils.indexOf();
        return list;
    }

}
