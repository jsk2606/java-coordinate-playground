package fuelinjection.domain;

public class Car {
    private final String modelName;
    private final int fuelEfficiency;

    public Car(String modelName, int fuelEfficiency) {
        this.modelName = modelName;
        this.fuelEfficiency = fuelEfficiency;
    }

//    public String getModelName() {
//        return modelName;
//    }

    public int getFuelEfficiency() {
        return fuelEfficiency;
    }
}
