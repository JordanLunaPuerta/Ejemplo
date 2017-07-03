package pe.edu.utp.carcare.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import pe.edu.utp.carcare.R;
import pe.edu.utp.carcare.fragments.DashboardFragment;
import pe.edu.utp.carcare.fragments.EntriesFragment;
import pe.edu.utp.carcare.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BottomNavigationView) findViewById(R.id.navigation))
                .setOnNavigationItemSelectedListener(
                        new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        return navigateAccordingTo(item.getItemId());
                    }
                });
        FloatingActionButton fab = (FloatingActionButton)
                findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),
                        AddEntryActivity.class));
            }
        });
        navigateAccordingTo(R.id.navigation_dashboard);
    }

    private Fragment getFragmentFor(int id) {
        switch (id) {
            case R.id.navigation_dashboard: return new DashboardFragment();
            case R.id.navigation_entries: return new EntriesFragment();
            case R.id.navigation_settings: return new SettingsFragment();
        }
        return null;
    }

    private boolean navigateAccordingTo(int id) {
        try {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, getFragmentFor(id))
                    .commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
