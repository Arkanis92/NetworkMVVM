package com.example.networkmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.networkmvvm.R;
import com.example.networkmvvm.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private MainViewModel viewModel;
//    private TextView tvDisplay;
//    private Button btnLoad;
//    private EditText etCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tvDisplay = findViewById(R.id.tvDisplay);
//        btnLoad = findViewById(R.id.btnLoad);
//        etCount = findViewById(R.id.etCount);
//        etCount.setText("5");
//        viewModel = new ViewModelProvider.NewInstanceFactory().create(MainViewModel.class);
//
//        setupObservers();
//        btnLoad.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String count = etCount.getText().toString();
//                viewModel.fetchShibeData(Integer.parseInt(count));
//            }
//        });

        launchRecyclerViewFragment();
    }

    private void launchRecyclerViewFragment() {
        loadFragment(new RecyclerViewFragment());
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }

//    private void setupObservers() {
//        viewModel.getShibesLiveData().observe(this, new Observer<List<String>>() {
//            @Override
//            public void onChanged(List<String> strings) {
//                if (strings != null) {
//                    if (strings.isEmpty())
//                        tvDisplay.setText("EMPTY LIST");
//                    else
//                        tvDisplay.setText(strings.toString());
//                }
//            }
//        });
//
//        viewModel.getErrorLiveData().observe(this, isError -> {
//            if (!isError.isEmpty())
//                Toast.makeText(this, isError, Toast.LENGTH_SHORT).show();
//        });
//    }
}
