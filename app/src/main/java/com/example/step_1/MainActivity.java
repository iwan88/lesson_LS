package com.example.step_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    // My code BEGIN

    private RecyclerView recycler;
    private itemViewAdaprer adapter = new itemViewAdaprer();


    // My code END
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //My code section BEGIN

        System.out.println("Hello WORLD!!!"); //Lesson_1

        configRecyclerView();

        generateItem();

        //My code section END
    }
    //My code BEGIN

    public void generateItem() {
        List<Item> test_item = new ArrayList<>();
        test_item.add(new Item("Зубная щетка", "66,6 р."));
        test_item.add(new Item("Зубная нить","25,5 р."));

        adapter.SetData(test_item);
    }

    public void configRecyclerView(){
        recycler = findViewById(R.id.items_view);
        recycler.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,false);

        recycler.setLayoutManager(layoutManager);
        }

    //My code END
}