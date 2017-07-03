package pe.edu.utp.carcare;

import android.app.Application;

import com.orm.SugarApp;

import java.util.List;

import pe.edu.utp.carcare.models.DataService;
import pe.edu.utp.carcare.models.FuelUpEntry;

/**
 * Created by GrupoUTP on 27/05/2017.
 */

public class CarCareApp extends SugarApp {
    private static CarCareApp instance;
    private DataService service;

    public CarCareApp() {
        super();
        instance = this;
    }

    public static CarCareApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        service = new DataService();
    }

    public List<FuelUpEntry> getEntries() {
        return service.getEntries();
    }

    public boolean addEntry(FuelUpEntry entry) {
        return service.addEntry(entry);
    }
}
