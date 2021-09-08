package com.example.demo.domain;

import com.example.demo.domain.enumeration.EngineType;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car  extends AbstractAuditingEntity {


    private int seatCount;
    private boolean convertible;
    private int rating;
    private String  licensePlate;
    private EngineType engineType;
    @Column(name = "driver_id",  updatable = true)
    private long driverId=00;

    public long getdriverId() {
        return driverId;
    }

    public void setdriverId(long driverId) {
        this.driverId = driverId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }


}
