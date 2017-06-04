package com.seunghoshin.android.fragment_2;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListFragment list;
    DetailFragment detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createFragments();
        addList();

    }

    public void createFragments(){
        //프래그먼트 생성
        list = new ListFragment();
        // 나를 던져줄것이다
        list.setActivity(this);
        detail = new DetailFragment();
    }

    public void addList(){
        //Transaction 꺼내기
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //contain에다가 지금만든 transaction을 넣겠다고 알려줌
        transaction.add(R.id.contain, list);
        // transaction을 커밋해줌
        transaction.commit();
    }

    public void addDetail(){
        //Transaction 꺼내기
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //contain에다가 지금만든 transaction을 넣겠다고 알려줌
        transaction.add(R.id.contain, detail);
        // transaction을 커밋해줌
        transaction.commit();
    }

}
