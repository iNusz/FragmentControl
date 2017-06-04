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
public class DetailFragment extends Fragment {

    MainActivity activity;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_detail, container, false);
        Button btnGoBack = (Button) view.findViewById(R.id.btnGoBack);
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //이때 addList를 하게되면 ListFragment가 이미 추가되어있는데 또 불러오게 되므로 에러를 발생하게 된다
                //따라서 stack에 담아서 하나씩 Pop하는 식으로 해야한다
                //activity.addList();
                activity.backToList();
            }
        });
        return view;
    }

    public void setActivity(MainActivity acticity){
        this.activity = acticity;
    }

}
