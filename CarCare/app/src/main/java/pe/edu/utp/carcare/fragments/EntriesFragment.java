package pe.edu.utp.carcare.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pe.edu.utp.carcare.CarCareApp;
import pe.edu.utp.carcare.R;
import pe.edu.utp.carcare.adapters.EntriesAdapter;
import pe.edu.utp.carcare.models.FuelUpEntry;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntriesFragment extends Fragment {
    private RecyclerView entriesRecyclerView;
    private EntriesAdapter entriesAdapter;
    private RecyclerView.LayoutManager entriesLayoutManager;
    private List<FuelUpEntry> entries;


    public EntriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_entries, container, false);
        entriesRecyclerView = (RecyclerView) view.findViewById(R.id.entriesRecyclerView);
        entries = CarCareApp.getInstance().getEntries();
        entriesAdapter = (new EntriesAdapter()).setEntries(entries);
        entriesLayoutManager = new LinearLayoutManager(view.getContext());
        entriesRecyclerView.setAdapter(entriesAdapter);
        entriesRecyclerView.setLayoutManager(entriesLayoutManager);
        return view;

    }

}
