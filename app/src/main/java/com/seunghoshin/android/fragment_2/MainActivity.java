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
        detail.setActivity(this);
    }

    public void addList(){
        // 1. 프래그먼트 트랜잭션 시작하기
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // 2. contain에다가 지금만든 transaction을 넣겠다고 알려줌 ( 화면에 프래그먼트 넣기 )
        transaction.add(R.id.contain, list);
        // 3. transaction을 커밋해줌 (트랜잭션 완료)
        transaction.commit();
    }

    public void addDetail(){
        //Transaction 꺼내기
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //contain에다가 지금만든 transaction을 넣겠다고 알려줌
        transaction.add(R.id.contain, detail);
        // 트랜잭션 처리 전체를 stack에 담아놨다가 , 안드로이드의 back 버튼으로 뒤로가기를 할 수 있다.
        transaction.addToBackStack(null);
        // transaction을 커밋해줌
        transaction.commit();
    }

    public void backToList(){
        super.onBackPressed();
    }

}
