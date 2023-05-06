package com.istad.dataanalyticresfulapi.repository.provider;

import org.apache.ibatis.jdbc.SQL;

public class UserProvider {
    public static String getAllUsers(String filterName){
        return new SQL(){{
            SELECT("*");
            FROM("users");
            if (!filterName.isEmpty()){
                WHERE("upper(username) like upper('%' || #{filterName} || '%') ");
            }
        }}.toString();
    }


}
