package com.example.apiintegration.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.apiintegration.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        }

    public void getData(View view) {
        Intent intent = new Intent(MainActivity.this,GetDataActivity.class);
        startActivity(intent);
    }

    public void commentApi(View view) {

        Intent intent2 = new Intent(MainActivity.this,CommentsActivity.class);
        startActivity(intent2);
    }

    public void usersapi(View view) {

        Intent intent3 = new Intent(MainActivity.this,UserDataActivity.class);
        startActivity(intent3);
    }

    public void photosapi(View view) {

        Intent intent4 = new Intent(MainActivity.this,PhotosActivity.class);
        startActivity(intent4);
    }

}