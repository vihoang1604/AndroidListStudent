package com.example.androidliststudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview=findViewById( R.id.recyclerview );
        recyclerview.setLayoutManager( new LinearLayoutManager( this ) );
        final AdapterStudent studentAdapter=new AdapterStudent();

        recyclerview.setAdapter( studentAdapter );
        final Student st1= new Student("Nam",22,"Quang Binh");
        Student st2= new Student("Lan",34,"Quang Binh");
        Student st3= new Student("Hoa",19,"Quang Binh");

        final List<Student> students = new ArrayList<Student>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        studentAdapter.students=students;
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.add(new Student("Anonymous",20,"Mars"));
                studentAdapter.notifyDataSetChanged();
            }
        });
        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.remove(students.size()-1);
                studentAdapter.notifyDataSetChanged();
            }
        });

    }
}
