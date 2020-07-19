package com.gee.databindingsample;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.gee.databindingsample.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Student student;
    private Handler handler;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setClickListener(this);
        student = new Student("Gee", 99);
        binding.setStudent(student);


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                student.setName(student.getName().substring(0, 3) + System.currentTimeMillis());
                System.out.println("student.getName()-->" + student.getName());
                if (handler != null)
                    handler.postDelayed(this, 2000);
            }
        };

        handler = new Handler();
        handler.post(runnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null)
            handler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_1:
                //System.out.println("v.getId()-->" + v.getId());
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, FragmentActivity.class);
                startActivity(intent);
                break;
            case R.id.button:
                System.out.println("removeCallbacksAndMessages success! ");
                if (handler != null)
                    handler.removeCallbacksAndMessages(null);
                break;
            default:
                break;
        }
    }
}