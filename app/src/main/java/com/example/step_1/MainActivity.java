package com.example.step_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.step_1.remote.MoneyRemoteItem;
import com.example.step_1.remote.MoneyResponse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    // My code BEGIN
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    itemViewAdaprer i_adapter = new itemViewAdaprer();

    @Override
    protected void onDestroy() {
        compositeDisposable.dispose();
        super.onDestroy();
    }

    // My code END
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //My code section BEGIN

        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.expences));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.income));

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new BudgetPagerAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText(R.string.expences);
        tabLayout.getTabAt(1).setText(R.string.income);

        generateData();
        //My code section END

    }

    private void generateData() {
        Disposable disposable = ((LoftApp) getApplication()).moneyAPI.GetMoneyItem("income")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<MoneyResponse>) s -> {
                    if (s.getStatus().equals("success")){
                        List<Item> moneyItems = new ArrayList<>();
                        for(MoneyRemoteItem moneyRemoteItem: s.getMoneyItemsList()){
                            moneyItems.add(Item.getInstance(moneyRemoteItem));
                        }

                        i_adapter.SetData(moneyItems);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),getString(R.string.connect_error),Toast.LENGTH_LONG).show();
                    }
                }, (Consumer<Throwable>) throwable -> {
                    Toast.makeText(getApplicationContext(),throwable.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                });
        compositeDisposable.add(disposable);
    }

    //My code BEGIN
    static class BudgetPagerAdapter extends FragmentPagerAdapter{

        public BudgetPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return new BudgetFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
    //My code END
    }