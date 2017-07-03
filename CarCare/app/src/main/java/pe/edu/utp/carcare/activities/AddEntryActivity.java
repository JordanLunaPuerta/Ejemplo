package pe.edu.utp.carcare.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Date;

import pe.edu.utp.carcare.CarCareApp;
import pe.edu.utp.carcare.R;
import pe.edu.utp.carcare.models.FuelUpEntry;

public class AddEntryActivity extends AppCompatActivity {
    TextInputEditText gallonsTextInputEditText;
    TextInputEditText unitPriceTextInputEditText;
    TextInputEditText odometerTextInputEditText;
    TextInputEditText locationReferenceTextInputEditText;

    TextInputLayout gallonsTextInputLayout;
    TextInputLayout unitPriceTextInputLayout;
    TextInputLayout odometerTextInputLayout;
    TextInputLayout locationReferenceTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gallonsTextInputEditText = (TextInputEditText)
                findViewById(R.id.gallonsTextInputEditText);
        unitPriceTextInputEditText = (TextInputEditText)
                findViewById(R.id.unitPriceTextInputEditText);
        odometerTextInputEditText = (TextInputEditText)
                findViewById(R.id.odometerTextInputEditText);
        locationReferenceTextInputEditText = (TextInputEditText)
                findViewById(R.id.locationReferenceTextInputEditText);

        gallonsTextInputLayout = (TextInputLayout)
                findViewById(R.id.gallonsTextInputLayout);
        unitPriceTextInputLayout = (TextInputLayout)
                findViewById(R.id.unitPriceTextInputLayout);
        odometerTextInputLayout = (TextInputLayout)
                findViewById(R.id.odometerTextInputLayout);
        locationReferenceTextInputLayout = (TextInputLayout)
                findViewById(R.id.locationReferenceTextInputLayout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputIsValid() && addEntry()) { finish(); return; }
                Snackbar.make(view, "Review your input", Snackbar.LENGTH_LONG)
                        .setAction("Clear", onClickListenerForClearAction()).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private View.OnClickListener onClickListenerForClearAction() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }

        };
    }

    private void clearFields() {
        gallonsTextInputEditText.setText("");
        unitPriceTextInputEditText.setText("");
        odometerTextInputEditText.setText("");
        locationReferenceTextInputEditText.setText("");
    }
    private boolean addEntry() {
        FuelUpEntry entry = new FuelUpEntry();
        entry.setGallons(Double.parseDouble(
                gallonsTextInputEditText.getText().toString()))
        .setUnitPrice(Double.parseDouble(
                unitPriceTextInputEditText.getText().toString()))
        .setOdometer(odometerTextInputEditText.getText().toString())
        .setLocationReference(locationReferenceTextInputEditText
        .getText().toString())
        .setCreatedAt(new Date());

        return CarCareApp.getInstance().addEntry(entry);
    }

    private boolean inputIsValid() {
        boolean hasErrors = false;
        gallonsTextInputLayout.setError(null);
        if(gallonsTextInputEditText.getText().toString().length() == 0) {
            gallonsTextInputLayout.setError(getString(R.string.error_message_field_empty));
            hasErrors = true;
        }
        unitPriceTextInputLayout.setError(null);
        if(unitPriceTextInputEditText.getText().toString().length() == 0) {
            unitPriceTextInputLayout.setError(getString(R.string.error_message_field_empty));
            hasErrors = true;
        }
        odometerTextInputLayout.setError(null);
        if(odometerTextInputEditText.getText().toString().length() == 0) {
            odometerTextInputLayout.setError(getString(R.string.error_message_field_empty));
            hasErrors = true;
        }
        locationReferenceTextInputLayout.setError(null);
        if(locationReferenceTextInputEditText.getText().toString().length() == 0) {
            locationReferenceTextInputLayout.setError(getString(R.string.error_message_field_empty));
            hasErrors = true;
        }
        return !hasErrors;
    }

}
