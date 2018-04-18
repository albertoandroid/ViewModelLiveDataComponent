package com.androiddesdecero.viewmodellivedata.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.androiddesdecero.viewmodellivedata.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertopalomarrobledo on 18/4/18.
 */

public class UserViewModel extends ViewModel {

    private List<User> userList;

    public UserViewModel(){
        userList = new ArrayList<>();
    }

    public void addUser(User user){
        userList.add(user);
    }

    private UserViewModel(List<User> userList){
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
