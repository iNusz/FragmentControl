# Fragment
Fragment를 이용한 화면연결 및 활용

<br/>

## Fragment 생성


```java
public void createFragments(){
        //프래그먼트 생성
        list = new ListFragment();
        // 나를 던져줄것이다
        list.setActivity(this);
        detail = new DetailFragment();
    }
```

## Transaction
MainActivity에 있는 FrameLayout에다가 Transaction을 넣고 커밋을 해준다
```java
        //Transaction 꺼내기
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //contain에다가 지금만든 transaction을 넣겠다고 알려줌
        transaction.add(R.id.contain, list);
        // transaction을 커밋해줌
        transaction.commit();
```

## ListFragment
onCreateView는 onBindViewHolder랑 똑같다고 보면 된다
버튼을 클릭해서 DetailFragment로 넘어가는 방법이다.

```java
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
```
