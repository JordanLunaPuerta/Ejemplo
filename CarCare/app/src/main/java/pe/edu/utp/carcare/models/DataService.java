package pe.edu.utp.carcare.models;

import android.os.Build;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by GrupoUTP on 27/05/2017.
 */

public class DataService {


    public DataService() {
        initEntries();
    }

    private void initEntries() {
        if(FuelUpEntry.listAll(FuelUpEntry.class).isEmpty() ) {
            (new FuelUpEntry(8.7, 11.0, "123000", "Sample Location 1", new Date())).save();
            (new FuelUpEntry(8.9, 10.5, "123010", "Sample Location 2", new Date())).save();
        }
    }
    public List<FuelUpEntry> getEntries() {
        return FuelUpEntry.listAll(FuelUpEntry.class);
    }

    public boolean addEntry(FuelUpEntry entry) {
        return entry.save() > 0;

    }

    public int getTotalRecords() {
        return getEntries().size();
    }

    public String getTotalRecordsAsString() {
        return String.valueOf(getTotalRecords());
    }

    public Double getTotalGallons() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return getEntries().stream().mapToDouble(FuelUpEntry::getGallons).sum();
        } else {
            double sum = 0;
            for(FuelUpEntry entry : getEntries()) sum += entry.getGallons();
            return sum;
        }
    }

    public String getTotalGallonsAsString() {
        return String.valueOf(getTotalGallons());
    }

    public Double getTotalExpense() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return getEntries().stream().mapToDouble(FuelUpEntry::getTotalPrice).sum();
        } else {
            double sum = 0;
            for(FuelUpEntry entry : getEntries()) sum += entry.getTotalPrice();
            return sum;
        }

    }

    public String getTotalExpenseAsString() {
        return String.valueOf(getTotalExpense());
    }
    public Double getFuelEfficiency() {
        List<FuelUpEntry> entries = getEntries();
        if(entries.size() < 2) return 0.0;
        int size = entries.size();
        Double totalEfficiency = 0.0;
        for(int i = 0; i < size - 2; i++) {
            totalEfficiency +=
                    (Double.parseDouble(entries.get(i + 1).getOdometer()) -
                            Double.parseDouble(entries.get(i).getOdometer()))/
                            entries.get(i).getGallons();
        }
        return totalEfficiency/(size - 1);
    }

    public String getFuelEfficiencyAsString() {
        return String.valueOf(getFuelEfficiency());
    }

}
