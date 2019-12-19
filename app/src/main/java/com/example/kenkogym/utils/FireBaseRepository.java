package com.example.kenkogym.utils;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.objects.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FireBaseRepository {
    private static FireBaseRepository instance;
    private  FirebaseDatabase database;
    private static ArrayList<User> users;

    public static FireBaseRepository getInstance() {
        if (instance == null) {
            instance = new FireBaseRepository();
        }
        return instance;
    }


    private FireBaseRepository() {
        database=FirebaseDatabase.getInstance();
    }

    public  FirebaseDatabase getDatabase() {
        return database;
    }

    public LiveData<Base> login(String email, String password) {
        MutableLiveData<Base> results = new MutableLiveData<>();
        //TODO magic
        return results;
    }
    public ArrayList<User> getAllUsers(){
        DatabaseReference myRef=database.getReference("Users");
        users = new ArrayList<>();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    users.add(postSnapshot.getValue(User.class));
                    Log.e("User",users.size()+"");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w("Users", "Failed to read value.", error.toException());
            }
        });
        return users;
    }
    public void insertUser(final User user){

         DatabaseReference myRefTemp=database.getReference("Users");

         ValueEventListener valueEventListener = new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 long count=dataSnapshot.getChildrenCount();
                 Long id= count;

                 DatabaseReference myRef=database.getReference("Users/"+id);

                 user.setuId(id);


                 myRef.setValue(user);
             }

             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {

             }
         };
         myRefTemp.addListenerForSingleValueEvent(valueEventListener);


    }

    public void setExercises(final ArrayList<String> exercises,final Long id) {
        DatabaseReference myRef=database.getReference("Users");
        final ArrayList<User> temp = new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    temp.add(postSnapshot.getValue(User.class));

                }
                temp.get(id.intValue()).setExercises(exercises);
                DatabaseReference myReftemp=database.getReference("Users/"+id.intValue());




                myReftemp.setValue(temp.get(id.intValue()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public ArrayList<String> getExercises(final Long id){
        final ArrayList<String> exercises;
        final ArrayList<User> temp = new ArrayList<>();
        DatabaseReference myRef=database.getReference("Users");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    temp.add(postSnapshot.getValue(User.class));

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        exercises=temp.get(id.intValue()).getExercises();
        return exercises;
    }
}