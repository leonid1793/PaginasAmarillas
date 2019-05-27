package com.arosado.moviles.paginasamarillasapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.arosado.moviles.paginasamarillasapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText categoryEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryEditText = findViewById(R.id.category_input);

    }

    public void search(View view) {
        String category = categoryEditText.getText().toString().trim();

        if(!category.isEmpty()) {
            Intent intent = new Intent(this, SearchResultActivity.class);

            intent.putExtra("category", category);
            startActivity(intent);
        }else {
            Toast.makeText(this, getString(R.string.main_category_empty), Toast.LENGTH_SHORT).show();
        }

    }

}
