package com.example.kenkogym.excercises;

import com.example.kenkogym.utils.FireBaseRepository;

public class ExcercisesRepository {
import java.util.List;

public class ExcercisesRepository implements RepositoryImplRoom {
    private static ExcercisesRepository instance;
    private FireBaseRepository repository;

    private LocalRepository local;

    public static ExcercisesRepository getInstance(Application application) {
        if (instance == null) {
            instance = new ExcercisesRepository(application);
        }
        return instance;
    }

    public ExcercisesRepository(Application application){
        repository=FireBaseRepository.getInstance();
        local= new LocalRepository(application);
    }

    public LiveData<List<String>> getExercises(Long id){
       return repository.getExercises(id);


    public void
    getExercises(Long id){
        repository.getExercises(id);
    }

    //Room methods, for insert Exercise and get all Excercises
    //Folder com.example.kenkogym.mussles.local
    @Override
    public void insert(Exercise exercise) {
        local.insert(exercise);
    }

    @Override
    public LiveData<List<Exercise>> getAllExercises() {
        return local.getAll();
    }
}
