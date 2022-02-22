package ru.digitalleague.ocs.internship.lesson05.ch2;

class Workstation extends Computer {
    Cooler cooler;

    public Workstation(CPU cpu, Memory memory, Storage storage, Cooler cooler) {
        super(cpu, memory, storage);
        this.cooler = cooler;
    }

    public int getPower() {
        return super.getPower() + cooler.power;
    }
}

class Cooler extends Device {
    public Cooler(String name, int power) {
        super(name, power);
    }
}

//class WorkstationWithHDD extends ComputerWithHDD {
//    String cooler;
//    int coolerPower;
//
//    public WorkstationWithHDD(String cpu, int cpuPower, String memory, int memoryPower, String storage, int storagePower, int platesNumber, String cooler, int coolerPower) {
//        super(cpu, cpuPower, memory, memoryPower, storage, storagePower, platesNumber);
//        this.cooler = cooler;
//        this.coolerPower = coolerPower;
//    }
//
//    public int getPower() {
//        return super.getPower() + coolerPower;
//    }
//}
//
//class WorkstationWithSSD extends ComputerWithSSD {
//    String cooler;
//    int coolerPower;
//
//    public WorkstationWithSSD(String cpu, int cpuPower, String memory, int memoryPower, String storage, int storagePower, String cellType, String cooler, int coolerPower) {
//        super(cpu, cpuPower, memory, memoryPower, storage, storagePower, cellType);
//        this.cooler = cooler;
//        this.coolerPower = coolerPower;
//    }
//
//    public int getPower() {
//        return super.getPower() + coolerPower;
//    }
//}