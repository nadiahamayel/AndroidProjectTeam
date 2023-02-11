package com.example.androidproject.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.UserManager;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidproject.Authentication.LoginActivity;
import com.example.androidproject.R;
import com.example.androidproject.AdminSide.UsersAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

//user
public class ListUsersFragment extends Fragment {

    //Declare a list to hold the identifiers
    List<String> identifiers = new ArrayList<>();

    //Get a reference to the Firebase authentication
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    //Get a reference to the Firebase database
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    public ListUsersFragment() {
        //Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.list_users_fragment, container, false);

        // Create the layout for the Fragment
//        LinearLayout layout = new LinearLayout(getActivity());
//        layout.setOrientation(LinearLayout.VERTICAL);

        // Create the ListView

     // ListView listView = view.findViewById(R.id.usersListView);
//      layout.addView(listView);

//        List<String> list = new ArrayList<>();
//        for(int i=0;i<100;i++)
//            list.add("Item "+i);UsersAdapter listAdapter = new UsersAdapter(identifiers);
////                    listView.setAdapter(listAdapter);




        return view;
    }
}