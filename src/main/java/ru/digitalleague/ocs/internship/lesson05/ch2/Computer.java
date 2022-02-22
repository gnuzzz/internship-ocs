package ru.digitalleague.ocs.internship.lesson05.ch2;

public class Computer {
    CPU cpu;
    Memory memory;
    Storage storage;

    public Computer(CPU cpu, Memory memory, Storage storage) {
        this.cpu = cpu;
        this.memory = memory;
        this.storage = storage;
    }

    public int getPower() {
        return cpu.power + memory.power + storage.power;
    }
}

class Device {
    String name;
    int power;

    public Device(String name, int power) {
        this.name = name;
        this.power = power;
    }
}

class CPU extends Device{
    public CPU(String name, int power) {
        super(name, power);
    }
}

class Storage extends Device{
    public Storage(String name, int power) {
        super(name, power);
    }
}

class Memory extends Device {
    public Memory(String name, int power) {
        super(name, power);
    }
}

class HDDStorage extends Storage {
    int platesNumber;

    public HDDStorage(String name, int power, int platesNumber) {
        super(name, power);
        this.platesNumber = platesNumber;
    }
}

class SSDStorage extends Storage {
    String cellType;

    public SSDStorage(String name, int power, String cellType) {
        super(name, power);
        this.cellType = cellType;
    }
}

//class ComputerWithHDD extends Computer {
//    int platesNumber;
//
//    public ComputerWithHDD(String cpu, int cpuPower, String memory, int memoryPower, String storage, int storagePower, int platesNumber) {
//        super(cpu, cpuPower, memory, memoryPower, storage, storagePower);
//        this.platesNumber = platesNumber;
//    }
//}
//
//class ComputerWithSSD extends Computer {
//    String cellType;
//
//    public ComputerWithSSD(String cpu, int cpuPower, String memory, int memoryPower, String storage, int storagePower, String cellType) {
//        super(cpu, cpuPower, memory, memoryPower, storage, storagePower);
//        this.cellType = cellType;
//    }
//}