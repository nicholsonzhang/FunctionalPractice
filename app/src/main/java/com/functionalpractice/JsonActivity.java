package com.functionalpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.functionalpractice.bean.Group;
import com.functionalpractice.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nichol on 15/11/6.
 */
public class JsonActivity extends AppCompatActivity {

    private TextView jsonText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_layout);

        jsonText = (TextView)findViewById(R.id.json_text);

        Group group = new Group();
        group.setId(1L);

        User user1 =new User();
        user1.setName("张三");
        user1.setGender(1);


        User user2 = new User();
        user2.setName("莉莉");
        user2.setGender(0);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        group.setUsers(userList);

        String  content = JSON.toJSONString(group);


        String str = "{'name':'李斯','gender':1}";
        User user =JSON.parseObject(str, User.class);

        jsonText.setText(content+"\n"+user.getName()+user.getGender());




    }
}
