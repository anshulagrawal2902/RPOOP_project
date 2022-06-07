package com.example.android.rpoop_api_fetcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.rpoop_api_fetcher.viewmodel.MainActivityViewModel;

public class QuestionUploadActivity extends AppCompatActivity {
    EditText question;
    EditText questionLink;
    EditText companyName;
    Button submit;
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_upload);

        question = (EditText)findViewById(R.id.question);
        questionLink = (EditText)findViewById(R.id.questionLink);
        companyName = (EditText)findViewById(R.id.companyName);
        submit = findViewById(R.id.button);

        viewModel =new  ViewModelProvider(this).get(MainActivityViewModel.class);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.uploadQuestion( companyName.getText().toString(), question.getText().toString(), questionLink.getText().toString());
            }
        });





    }
}