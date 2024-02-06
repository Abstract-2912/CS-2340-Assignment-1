package com.example.cs_2340_assignment_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.cs_2340_assignment_1.databinding.FragmentFirstBinding;

public class Home extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.bcourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Home.this)
                        .navigate(R.id.navigateFromHomeToCourses);
            }
        });
        binding.btodolist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Home.this)
                        .navigate(R.id.navigateFromHomeToTodoLists);
            }
        });
        binding.bassignments.setOnClickListener(e -> {
            NavHostFragment.findNavController(Home.this)
                    .navigate(R.id.navigateFromHomeToAssignments);
        });
        binding.bexams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Home.this)
                        .navigate(R.id.navigateFromHomeToExams);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}