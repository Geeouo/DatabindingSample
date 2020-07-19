package com.gee.databindingsample;

import android.os.Bundle;

import com.gee.databindingsample.databinding.ActivityFragmentBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * Create by Gee on 2020/7/19.
 *  _____
 * / ____|
 * | |  __  ___  ___
 * | | |_ |/ _ \/ _ \
 * | |__| |  __/  __/
 * \_____|\___|\___|
 */
public class FragmentActivity extends AppCompatActivity {

    private List<Student> students;
    private ActivityFragmentBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this
                , R.layout.activity_fragment);

        students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student("student" + i, new Random().nextInt(100));
            if (i == 2) student.setResourceId(R.drawable.helloworld2);
            students.add(student);
        }
        StudentAdapter adapter = new StudentAdapter(students);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(FragmentActivity.this, LinearLayoutManager.VERTICAL, false));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapter);
    }
}
