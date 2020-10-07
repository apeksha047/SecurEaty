package com.example.secureaty.ui.home;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.secureaty.ChoosefileFragement;
import com.example.secureaty.R;
import com.example.secureaty.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {
    Button btnScan;


    private HomeViewModel homeViewModel;
    FragmentHomeBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       /* homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;*/

        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        return  binding.getRoot();

    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        binding.Scanbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment cf_fragment=new ChoosefileFragement();
                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,cf_fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
    }
    //to avoid memory leakage
    public void onDestroy(){
        super.onDestroy();
        binding=null;
    }

}