package com.t2008m.accuwheather.entity;

public class Temperature {
    private Float Value;
    private String Unit;
    private int UnitType;

    public Temperature() {
    }

    public Temperature(Float value, String unit, int unitType) {
        this.Value = value;
        this.Unit = unit;
        UnitType = unitType;
    }

    public Float getValue() {
        return Value;
    }

    public void setValue(Float value) {
        this.Value = value;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        this.Unit = unit;
    }

    public int getUnitType() {
        return UnitType;
    }

    public void setUnitType(int unitType) {
        UnitType = unitType;
    }
}
