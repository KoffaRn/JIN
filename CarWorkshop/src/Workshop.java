public class Workshop {
    void fixLamps(Car car){
        if(car.lampsWorking == false) car.lampsWorking = true;
    }
    void fixTires(Car car) {
        if(car.tiresWorn) car.tiresWorn = true;
    }
    void fixEngine(Car car) {
        if(car.engineWorking == false) car.engineWorking = true;
    }
    void fixAll(Car car) {
        fixLamps(car);
        fixEngine(car);
        fixTires(car);
    }
    void carStatus(Car car) {
        if(car.engineWorking) System.out.println("Motorn fungerar");
        else System.out.println("Motorn är trasig");
        if(car.lampsWorking) System.out.println("Lamporna fungerar");
        else System.out.println("Lamporna fungerar inte");
        if(car.tiresWorn) System.out.println("Däcken är slitna");
        else System.out.println("Däcken är fräscha");
    }
}
