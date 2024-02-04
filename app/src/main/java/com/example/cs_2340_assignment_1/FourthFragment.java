package com.example.cs_2340_assignment_1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cs_2340_assignment_1.databinding.FragmentFourthBinding;
import com.example.cs_2340_assignment_1.databinding.FragmentSecondBinding;


public class FourthFragment extends Fragment {


    public FourthFragment() {
        // Required empty public constructor
    }

    private FragmentFourthBinding binding;
    private CourseListAdapter courseListAdapter;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFourthBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getActivity().findViewById(R.id.recycler_view_assignments);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        courseListAdapter = new CourseListAdapter(getContext());

        recyclerView.setAdapter(courseListAdapter);
        binding.fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FourthFragment.this)
                        .navigate(R.id.action_SecondFragment_to_thirdFragment);
            }
        });
    }
}