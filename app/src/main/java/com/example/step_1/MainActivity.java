package com.example.step_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //My code section BEGIN

        RecyclerView recyclerView = findViewById(R.id.recycler);

        System.out.println("Hello WORLD!!!"); //Lesson_1

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setItems(items);

        //My code section END
    }
    //My code BEGIN
    public class ItemActivity extends AppCompatActivity{
        ItemsAdapter adapter = new ItemsAdapter;
    }

    //My code END
}