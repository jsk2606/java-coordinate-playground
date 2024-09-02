package fuelinjection;

import fuelinjection.domain.Car;
import fuelinjection.domain.RentCompany;
import fuelinjection.domain.RentCompanyGasPump;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 우리 회사는 고객이 인터넷으로부터 예약할 때 여행할 목적지의 대략적인 이동거리를 입력 받는다. 이 이동거리를 활용해 차량 별로 필요한 연료를 주입한다.
 *
 * 각 차량별 연비는 다음과 같다.
 * * Sonata : 10km/리터
 * * Avante : 15km/리터
 * * K5 : 13km/리터
 */
public class RentCompanyTest {

    private List<Car> testEntrance;

    @BeforeEach
    public void testBeforeEach() {
        List<Car> result = new ArrayList<>();
        result.add(new Car("Sonata", 10));
        result.add(new Car("Avante", 15));
        result.add(new Car("K5", 13));
        testEntrance = result;
    }

    @DisplayName("주유량 계산")
    @Test
    public void fuelAmountCalculationTest(){
        RentCompanyGasPump gasPump = new RentCompanyGasPump();
        int fuelAmount = gasPump.fuelAmountCalculation(10, 31);
        assertEquals(4, fuelAmount);
    }

    @DisplayName("렌트 차량별 주유량 계산")
    @Test
    public void fuelRequiredForEachVehicle(){
        RentCompany company = new RentCompany(testEntrance, new RentCompanyGasPump());
        Map<Car, Integer> testResult = company.fuelRequiredForEachVehicle(300);

        assertEquals(30, testResult.get(testEntrance.get(0)));
        assertEquals(20, testResult.get(testEntrance.get(1)));
        assertEquals(24, testResult.get(testEntrance.get(2)));
    }
}