package com.seunghoshin.android.fragment_2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    // 1. 메인엑티비티 정의를 해주고
    MainActivity activity;

    public ListFragment() {
        // Required empty public constructor
    }

    // 2. setActivty라는 함수를 만들어주고
    public void setActivity(MainActivity activity){
        this.activity = activity;
    }



    @Override
    // onCreateView를 onBindViewHolder랑 똑같다고 보면 됨
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 버튼을 클릭해서 detail로 넘어가는 방법
        // return을 하지 않고 view를 받는다
        // 프래그먼트의 레이아웃을 inflate하고
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        // 안의 위젯들을 코드에 연결한다
        Button btnGoDetail = (Button) view.findViewById(R.id.btnGoDetail);
        btnGoDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3. addDetail() 함수를 호출해준다
                activity.addDetail();
            }
        });

        return view;
    }

}
