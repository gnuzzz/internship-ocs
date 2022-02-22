package ru.digitalleague.ocs.internship.lesson05.ch2;

class Laptop extends Computer {
    Display display;

    public Laptop(CPU cpu, Memory memory, Storage storage, Display display) {
        super(cpu, memory, storage);
        this.display = display;
    }

    public int getPower() {
        return super.getPower() + display.power;
    }
}

class Display extends Device {
    public Display(String name, int power) {
        super(name, power);
    }
}

//class LaptopWithHDD extends ComputerWithHDD {
//    String display;
//    int displayPower;
//
//    public LaptopWithHDD(String cpu, int cpuPower, String memory, int memoryPower, String storage, int storagePower, int platesNumber, String display, int displayPower) {
//        super(cpu, cpuPower, memory, memoryPower, storage, storagePower, platesNumber);
//        this.display = display;
//        this.displayPower = displayPower;
//    }
//
//    public int getPower() {
//        return super.getPower() + displayPower;
//    }
//}
//
//class LaptopWithSSD extends ComputerWithSSD {
//    String display;
//    int displayPower;
//
//    public LaptopWithSSD(String cpu, int cpuPower, String memory, int memoryPower, String storage, int storagePower, String cellType, String display, int displayPower) {
//        super(cpu, cpuPower, memory, memoryPower, storage, storagePower, cellType);
//        this.display = display;
//        this.displayPower = displayPower;
//    }
//
//    public int getPower() {
//        return super.getPower() + displayPower;
//    }
//}