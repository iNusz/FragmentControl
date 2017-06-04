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
        // 1. 프래그먼트 트랜잭션 시작하기
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // 2. contain에다가 지금만든 transaction을 넣겠다고 알려줌 ( 화면에 프래그먼트 넣기 )
        transaction.add(R.id.contain, list);
        // 3. transaction을 커밋해줌 (트랜잭션 완료)
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

## DetailFragment
DetailFragment는 위에 있는 ListFragment와 비슷한데 다른점이 한가지 있다.
바로 화면전환시인데 , 위의 경우에는 activity.addDetail() 을 했지만 DetailFragment 또한 그렇게 할시 이미 ListFragment가 이미 추가되어있는데 또 불러오게 되므로 에러를 발생하게 된다.
**따라서 stack에 담아서 하나씩 Pop 하는식으로 해야한다**

```java
@Override
            public void onClick(View v) {
                activity.backToList();
            }
        });
        return view;
```
###### 뒤로가게 해주는 메소드이다
```java
public void backToList(){
        super.onBackPressed();
    }
```

__제일 중요한건 위에 처럼 실행을 시켰을 경우 뒤에화면이 눌리면 에러가 발생한다는 것이다.
따라서 우리는 위에 덧붙여진 Fragment만 클릭하게 만들어야 하는데 이때 해주는 행동이 fragment_detail 에 들어가 clickable을 체크해주는 것이다__
