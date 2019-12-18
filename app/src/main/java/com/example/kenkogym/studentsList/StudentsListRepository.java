package com.example.kenkogym.studentsList;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.utils.FireBaseRepository;
import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.objects.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class StudentsListRepository implements RepositoryUserImpl {

    private static StudentsListRepository instance;
    private static DatabaseReference myRef;
    private static FireBaseRepository database;

    public static StudentsListRepository getInstance() {
        if (instance == null) {
            instance = new StudentsListRepository();
        }
        return instance;
    }

    private StudentsListRepository() {
        database=FireBaseRepository.getInstance();
        myRef= database.getDatabase().getReference("Users");

    }

//    @Override
//    public LiveData<Base> login(String email, String password) {
//        return FireBaseRepository.getInstance().login(email, password);
//    }
//    public DatabaseReference getMyRef(){
//        return myRef;
//    }
    public void tempGetUsers(){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
//                User value = dataSnapshot.getValue(User.class);
//                Log.d("Users", "Value is: " + value.getEmail());
//                Log.e("Count " ,""+dataSnapshot.getChildrenCount());
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    User post = postSnapshot.getValue(User.class);
                    Log.e("Get Data", post.getName());
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Users", "Failed to read value.", error.toException());
            }
        });
    }
    @Override
    public LiveData<Base> getUsers() {

        return ApiRepository.getInstance().getUsers();
    }

    @Override
    public LiveData<Base> getUserDetails(String uuid) {
        return null;
    }
}
