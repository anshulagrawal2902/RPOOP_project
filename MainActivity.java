package com.example.android.rpoop_api_fetcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.rpoop_api_fetcher.adapters.QuestionAdapter;
import com.example.android.rpoop_api_fetcher.models.QuestionModel;
import com.example.android.rpoop_api_fetcher.viewmodel.MainActivityViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<QuestionModel> questionList;
    private RecyclerView recyclerView;
    private QuestionAdapter questionAdapter;
    private MainActivityViewModel mainActivityViewModel;
    private String companyName = "adobe";
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, QuestionUploadActivity.class);
                startActivity(i);
            }
        });

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        LoadQuestions(companyName);

    }

    public void LoadQuestions(String companyName){
        mainActivityViewModel.getQuestions(companyName).observe(this, new Observer<List<QuestionModel>>() {
            @Override
            public void onChanged(List<QuestionModel> questionModels) {
                questionList =(ArrayList<QuestionModel>)questionModels;
                showOnRecyclerView();
            }
        });
    }

    public void showOnRecyclerView(){
        recyclerView = findViewById(R.id.recyclerView);
        questionAdapter = new QuestionAdapter(this, questionList);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(questionAdapter);
        questionAdapter.notifyDataSetChanged();
    }
}