package fuelinjection.domain;

public class RentCompanyGasPump implements GasPump{
    @Override
    public int fuelAmountCalculation(int fuelEfficiency, int distanceToDrive) {
        if(distanceToDrive % fuelEfficiency == 0){
            return distanceToDrive/fuelEfficiency;
        }
        return distanceToDrive/fuelEfficiency + 1;
    }
}
