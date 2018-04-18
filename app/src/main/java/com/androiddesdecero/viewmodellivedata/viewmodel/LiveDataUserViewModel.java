package com.androiddesdecero.viewmodellivedata.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.androiddesdecero.viewmodellivedata.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertopalomarrobledo on 18/4/18.
 */

public class LiveDataUserViewModel extends ViewModel {

    private MutableLiveData<List<User>> userListLiveData;
    private List<User> userList;

    public LiveData<List<User>> getUserList(){
        if(userListLiveData==null){
            userListLiveData = new MutableLiveData<List<User>>();
            userList = new ArrayList<>();
        }
        return userListLiveData;
    }

    public void addUser(User user){
        userList.add(user);
        userListLiveData.setValue(userList);
    }

}
