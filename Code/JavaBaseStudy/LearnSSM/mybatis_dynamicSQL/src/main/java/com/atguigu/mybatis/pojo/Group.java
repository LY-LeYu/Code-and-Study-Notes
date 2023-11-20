package com.atguigu.mybatis.pojo;

import java.util.List;

public class Group {
    String gname;
    int gid;

    List<User> users;


    public Group() {
    }

    @Override
    public String toString() {
        return "Group{" +
                "gname='" + gname + '\'' +
                ", gid=" + gid +
                ", users=" + users +
                '}';
    }

    public Group(String gname, int gid, List<User> users) {
        this.gname = gname;
        this.gid = gid;
        this.users = users;
    }
}
