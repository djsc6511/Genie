package org.androidtown.genie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Login extends Activity implements AdapterView.OnItemClickListener{
    String[] setList = {
        "1. 회원가입",
        "2. 로그인",
        "3. 개인정보수정",
        "4. 알림 설정",
        "5. 포인트 충전/환전",
        "6. 나의 이용 내역"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        ArrayAdapter<String> adapter;


        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,setList);

        ListView list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView txtviewClicked = (TextView)view;
        String txt = txtviewClicked.getText().toString();
        if("1. 회원가입".equals(txt)){
            Intent intent = new Intent(this,RegisterActivity.class);
            startActivity(intent);
        }else if("2. 로그인".equals(txt)){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }
}
