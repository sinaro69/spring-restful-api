package com.istad.dataanalyticresfulapi.repository;


import com.istad.dataanalyticresfulapi.model.Account;
import com.istad.dataanalyticresfulapi.model.User;
import com.istad.dataanalyticresfulapi.model.UserAccount;
import com.istad.dataanalyticresfulapi.model.request.UserRequest;
import com.istad.dataanalyticresfulapi.repository.provider.UserProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRepository {


//    @Select("select * from users")
    @Result(column = "id", property = "userId")
    @SelectProvider(type = UserProvider.class,method = "getAllUsers")
    List<User> allUsers(String filterName);

    List<User> findUserByUsername(String username);
    @Select("insert into users (username, gender, address)\n" +
            "values (#{user.username},#{user.gender}, #{user.address}) returning id")
    int createNewUser(@Param("user") UserRequest user);




    @Update("update users set username=#{user.username},\n" +
            "                    gender=#{user.gender},\n" +
            "                    address =#{user.address}\n" +
            "where  id = #{id};")
    int updateUser(@Param("user") UserRequest user , int id );

    @Result(property = "userId", column = "id")
    @Select("select  * from users where id = #{id}")
    User findUserByID(int id );


    @Delete("delete  from users where id = #{id}")
    int removeUser(int id );


    @Results({
            @Result(column = "id", property = "userId"),
            @Result(column = "id", property = "accounts", many = @Many(select = "findAccountsByUserId"))
    })
    @Select("select * from users")
    List<UserAccount> getAllUserAccounts();



    @Results({
            @Result(property = "accountName",column = "account_name"),
            @Result(property = "accountNumber", column = "account_no"),
            @Result(property ="transferLimit", column = "transfer_limit"),
            @Result(property = "password", column = "passcode"),
            @Result(property = "accountType", column = "account_type",
                    one = @One(select = "com.istad.dataanalyticrestfulapi.repository.AccountRepository.getAccountTypeByID"))
    })
    @Select("select * from useraccount_tb " +
            "    inner join account_tb " +
            "        a on a.id = useraccount_tb.account_id\n" +
            "    where user_id = #{id};")
    List<Account> findAccountsByUserId(int id);





}
