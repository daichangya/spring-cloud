package com.daicy.configclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.springframework.util.StringUtils;


@Component
@RefreshScope
public class Utils {

    private static Utils utils = null;

    public static Utils getUtils() {
        if (null == utils) {
            utils = SpringAppContextUtil.getBean(Utils.class);
        }
        return utils;
    }

    @Value("${daicy.lucky-word}")
    private String luckyWord;

    private List<String> appList = Lists.newArrayList();

    @Value("${sms.applist:api}")
    public void setAppList(String apps) {
        if(!StringUtils.isEmpty(apps)){
            appList = Splitter.on(",").trimResults().splitToList(apps);
        }
    }

    public List<String> getAppList() {
        return appList;
    }

    public static boolean isChinaMobile(String mobile) {
        return mobile.startsWith("+86") || !mobile.startsWith("+");
    }
}
