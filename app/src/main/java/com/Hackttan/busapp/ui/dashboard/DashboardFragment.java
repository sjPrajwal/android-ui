package com.Hackttan.busapp.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Hackttan.busapp.APIClient;
import com.Hackttan.busapp.APIInterface;
import com.Hackttan.busapp.BusInfo;
import com.Hackttan.busapp.Dashboard;
import com.Hackttan.busapp.MyRecyclerViewAdapter;
import com.Hackttan.busapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {
    private static final String TAG = "DashboardFragment";
    private HomeViewModel homeViewModel;
    APIInterface apiInterface;
    APIClient mApiClient;
    MyRecyclerViewAdapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        // data to populate the RecyclerView with
        ArrayList<String> busInfo = new ArrayList<>();
        busInfo.add("Hyderabad");
        busInfo.add("Chittoor");
        busInfo.add("Tirupati");
        busInfo.add("Pune");
        busInfo.add("Gova");

        // set up the RecyclerView
        RecyclerView recyclerView = root.findViewById(R.id.rv_dashboard);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MyRecyclerViewAdapter(getActivity(), busInfo);
        recyclerView.setAdapter(adapter);

        /*APIInterface apiInterface = APIClient.retrofit.create(APIInterface.class);
        apiInterface.getDashboard().enqueue(new Callback<BusInfo>() {
            @Override
            public void onResponse(Call<BusInfo> call, Response<BusInfo> response) {
                Log.d(TAG, "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<BusInfo> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });*/
        return root;
    }
}