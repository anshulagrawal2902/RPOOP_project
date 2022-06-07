package com.example.android.rpoop_api_fetcher.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.android.rpoop_api_fetcher.Repository;
import com.example.android.rpoop_api_fetcher.models.QuestionModel;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    Repository repository ;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }

    public LiveData<List<QuestionModel>> getQuestions(String companyName){
        return repository.getQuestionModelMutableLiveData(companyName);
    }

    public void uploadQuestion(String companyName, String question, String questionLink){
        repository.uploadQuestion(question, questionLink, companyName);
        return;
    }
}
