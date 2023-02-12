package com.example.androidproject.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidproject.R;
import com.example.androidproject.RecipesModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;

//add
public class AddFragment extends Fragment {

    EditText recipe_name ,recipe_time, recipe_description , recipe_category ;
    Button add;

//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    //object from database reference class , must add child user or recipe
//    DatabaseReference reference = database.getReference();
//
//    //this reference for get data from database and I don't need to child
//    DatabaseReference referenceToGet = database.getReference();


    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.add_fragment, container, false);
//        recipe_id = view.findViewById(R.id.rec_id);
        recipe_name = view.findViewById(R.id.rec_name);
        recipe_time = view.findViewById(R.id.rec_time);
        recipe_description = view.findViewById(R.id.rec_description);
        recipe_category = view.findViewById(R.id.rec_category);
//        recipe_img = view.findViewById(R.id.rec_img);
        add = view.findViewById(R.id.addRecipeBtn);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert ();

            }
        });
        // Inflate the layout for this fragment
        return view ;
    }

    public void insert (){
        Map<String,Object> map=new HashMap<>();
        //map.put("recipe_id",recipe_id.getText().toString());
        map.put("recipe_name",recipe_name.getText().toString());
        map.put("recipe_time",recipe_time.getText().toString());
        map.put("recipe_description",recipe_description.getText().toString());
        map.put("recipe_category",recipe_category.getText().toString());
       // map.put("recipe_img",recipe_img.getText().toString());
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("/recipe").child("recipes");
        String id =  reference.push().getKey();
      //  reference.child(id).setValue(map);
        RecipesModel recipe = new RecipesModel();
        recipe.setRecipe_id(id);
        recipe.setRecipe_category(recipe_category.getText().toString());
        recipe.setRecipe_description(recipe_description.getText().toString());
        recipe.setRecipe_time(recipe_time.getText().toString());
        recipe.setRecipe_name(recipe_name.getText().toString());


        reference.child(id).setValue(recipe)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                      //  recipe_id.setText("");
                        recipe_name.setText("");
                        recipe_time.setText("");
                        recipe_description.setText("");
                        recipe_category.setText("");
                       // recipe_img.setText("");
                        Toast.makeText(getView().getContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(getView().getContext(),"Could not insert",Toast.LENGTH_LONG).show();
                    }
                });

    }
}