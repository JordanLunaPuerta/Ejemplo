package pe.edu.utp.carcare.models;

import com.orm.SugarRecord;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by GrupoUTP on 27/05/2017.
 */

public class FuelUpEntry extends SugarRecord {
    private Double gallons;
    private Double unitPrice;
    private String odometer;
    private String locationReference;
    private Date createdAt;

    public FuelUpEntry() {

    }

    public FuelUpEntry(Double gallons, Double unitPrice, String odometer, String locationReference, Date createdAt) {
        this.gallons = gallons;
        this.unitPrice = unitPrice;
        this.odometer = odometer;
        this.locationReference = locationReference;
        this.createdAt = createdAt;
    }

    public Double getGallons() {
        return gallons;
    }

    public String getGallonsAsString() {
        return String.format("%.2f", getGallons());
    }

    public FuelUpEntry setGallons(Double gallons) {
        this.gallons = gallons;
        return this;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Double getTotalPrice() {
        return getGallons()*getUnitPrice();
    }

    public String getTotalPriceAsString() {
        return String.format("%.2f", getTotalPrice());
    }

    public FuelUpEntry setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public String getOdometer() {
        return odometer;
    }

    public FuelUpEntry setOdometer(String odometer) {
        this.odometer = odometer;
        return this;
    }

    public String getLocationReference() {
        return locationReference;
    }

    public FuelUpEntry setLocationReference(String locationReference) {
        this.locationReference = locationReference;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getCreatedAtAsString() {
        return (new SimpleDateFormat("EEEE MMMM, d yyyy"))
                .format(getCreatedAt());
    }

    public FuelUpEntry setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getContext() {
        return "On " + getCreatedAtAsString() +
                (locationReference.isEmpty() ? "" :
                        " at " + locationReference);
    }
}







