package kr.uk.dh.a20200317_04_androidfunction02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import kr.uk.dh.a20200317_04_androidfunction02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                다른 화면으로 이동 : Intent
//                => 우리가 만든게 아니라, 안드로이드가 제공하는 화면으로 이동.
//                => 전화걸기 화면
//                        어디 화면으로 갈지 => 안드로이드가 요구하는 양식으로 작성 : Uri
                String phoneNum = binding.phoneNum.getText().toString();
//                Log.d("입력한 폰번,phoneNum") 확인용
                String phoneUriStr = String.format("tel:%s", phoneNum);
                Uri uri = Uri.parse(phoneUriStr);
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);


            }
        });


        binding.callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//              현재까지 배운것만으론 실행 불가 : 권한 획득 X
                Uri uri = Uri.parse("tel:01051121212");
                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent);
            }
        });



    }
}
