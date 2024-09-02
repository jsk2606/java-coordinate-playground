package fuelinjection.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentCompany {
    private final List<Car> carList;
    private final RentCompanyGasPump gasPump;

    public RentCompany(List<Car> carList, RentCompanyGasPump gasPump) {
        this.carList = carList;
        this.gasPump = gasPump;
    }

    public Map<Car, Integer> fuelRequiredForEachVehicle(int distanceToDrive) {
        Map<Car, Integer> result = new HashMap<>();
        carList.forEach(car ->
            result.put(car, gasPump.fuelAmountCalculation(car.getFuelEfficiency(), distanceToDrive))
        );
        return result;
    }
}
