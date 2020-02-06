package com.example.networkmvvm.view;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.networkmvvm.R;
import com.example.networkmvvm.viewmodel.MainViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    private MainViewModel viewModel;
    private TextView tvDisplay;
    private Button btnLoad;
    private EditText etCount;


    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvDisplay = view.findViewById(R.id.tvDisplay);
        btnLoad = view.findViewById(R.id.btnLoad);
        etCount = view.findViewById(R.id.etCount);
        viewModel = new ViewModelProvider.NewInstanceFactory().create(MainViewModel.class);

        setupObservers();
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String count = etCount.getText().toString();
                viewModel.fetchShibeData(Integer.parseInt(count));
            }
        });
    }

    private void setupObservers() {
        viewModel.getShibesLiveData().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                if (strings != null) {
                    if (strings.isEmpty())
                        tvDisplay.setText("EMPTY LIST");
                    else
                        tvDisplay.setText(strings.toString());
                }
            }
        });

        viewModel.getErrorLiveData().observe(this, isError -> {
            if (!isError.isEmpty())
                Toast.makeText(getContext(), isError, Toast.LENGTH_SHORT).show();
        });
    }

}
