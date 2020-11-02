package com.example.step_1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class AddItemActivity extends AppCompatActivity {

    private EditText name_c;
    private EditText price_c;

    private String mPrice;
    private String mName;

    private Button mAddButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        name_c = findViewById(R.id.cell_name);
        price_c = findViewById(R.id.cell_price);

        name_c.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mName = s.toString();
                checkEditTexHasText();
            }
        });

        price_c.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPrice = s.toString();
                checkEditTexHasText();
            }
        });

        mAddButton = findViewById(R.id.add_button);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Пока ничего нет
            }
        });

    }

    public void checkEditTexHasText() {
        mAddButton.setEnabled(!TextUtils.isEmpty(mName) && !TextUtils.isEmpty(mPrice));
    }
}
