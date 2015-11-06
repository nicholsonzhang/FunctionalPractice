package com.functionalpractice.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nichol on 15/11/6.
 */
public class Group {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private Long id;
    private List<User> users = new ArrayList<User>();
}
