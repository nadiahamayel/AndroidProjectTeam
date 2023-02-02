package com.example.androidproject.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.androidproject.R;
import com.example.androidproject.AdminSide.UsersAdapter;

import java.util.ArrayList;
import java.util.List;

//user
public class ListUsersFragment extends Fragment {

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

        ListView listView = view.findViewById(R.id.usersListView);
//        layout.addView(listView);

        List<String> list = new ArrayList<>();
        for(int i=0;i<100;i++)
            list.add("Item "+i);

        // Create the UserAdapter and set it to the ListView
        UsersAdapter listAdapter = new UsersAdapter(list);
        listView.setAdapter(listAdapter);

        return view;
    }
}