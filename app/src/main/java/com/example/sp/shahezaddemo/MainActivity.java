package com.example.sp.shahezaddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sp.shahezaddemo.bean.Book;
import com.example.sp.shahezaddemo.util.UtilLog;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton bt2;

    @OnClick(R.id.bt2)
    public void button2Click(){
        Intent intent = new Intent(this, DialogueActivity.class);
        startActivityForResult(intent, 2);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        toastShort("onStart");
    }

    private void initialView()
    {
        bt1 = (ImageButton)findViewById(R.id.bt1);
        bt3 = (ImageButton)findViewById(R.id.bt3);
        bt2 = (ImageButton)findViewById(R.id.bt2);


    }



    private void initialListener()
    {
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bt1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(v.getContext(), "Button1 was clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(),ViewPagerActivity.class);
                intent.putExtra("key","value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);
                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Panjwani");
                bundle.putSerializable("book", book);
                intent.putExtras(bundle);
                startActivity(intent);
                startActivityForResult(intent,1);
            }
        });


        bt3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ListViewActivity.class);
                startActivityForResult(intent,3);
//                Intent intent = new Intent(v.getContext(),ListViewActivity.class);
//                startActivity(intent);
            }
            });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                String message = data.getStringExtra("message");
                toastShort(message);
                break;
            case 2:
                toastShort("Dialog");
                break;
            case 3:
                toastShort("ListView");
                break;
            default:
        }
    }

    public void onClick(View v)
    {
//        Toast.makeText(this, "Button2 was clicked", Toast.LENGTH_LONG).show();
        toastLong("Button 2 was clicked");
        UtilLog.logD("testD", "Toast");
        UtilLog.logE("testE","Toast");
        UtilLog.logI("testI","Toast");
        UtilLog.logV("testV","Toast");
        UtilLog.logW("testW","Toast");




    }
}
