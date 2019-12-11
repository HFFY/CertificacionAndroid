package com.example.kenkogym.studentsList.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.kenkogym.studentsList.StudentsListRepository;
import com.example.kenkogym.utils.models.Base;

public class StudentsListViewModel extends ViewModel {

    private StudentsListRepository repository;

    public StudentsListViewModel() {repository = StudentsListRepository.getInstance();}

    public LiveData<Base> getUsers() {

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("Users");
//
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                ArrayList<Object> value = (ArrayList<Object>) dataSnapshot.getValue();
//                Log.d("Hola", "Value is: " + value.get(1));
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                // Failed to read value
//
//            }
//        });


        return repository.getUser();
    }

}
