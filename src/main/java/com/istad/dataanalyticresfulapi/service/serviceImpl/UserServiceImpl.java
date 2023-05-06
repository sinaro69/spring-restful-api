package com.istad.dataanalyticresfulapi.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.istad.dataanalyticresfulapi.model.User;
import com.istad.dataanalyticresfulapi.model.UserAccount;
import com.istad.dataanalyticresfulapi.model.request.UserRequest;
import com.istad.dataanalyticresfulapi.repository.UserRepository;
import com.istad.dataanalyticresfulapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // inject repository
    UserRepository userRepository;
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public PageInfo<User> allUsers(int page,int size,String filterName) {
        // PageHelper is here
        PageHelper.startPage(page,size);
        return new PageInfo<>(userRepository.allUsers(filterName));
//        return userRepository.allUsers();
    }

    @Override
    public List<User> findUserByName() {
        return null;
    }

    @Override
    public User findUserByID(int id) {
        return userRepository.findUserByID(id);
    }

    @Override
    public int createNewUser(UserRequest user) {
        return userRepository.createNewUser(user);
    }

    @Override
    public int updateUser(UserRequest user, int id ) {
        return userRepository.updateUser(user, id);
    }

    @Override
    public int removeUser(int id) {
        return userRepository.removeUser(id);
    }

    @Override
    public List<UserAccount> getAllUserAccounts() {
        return userRepository.getAllUserAccounts();
    }
}
