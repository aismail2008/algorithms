package com.code.test.designpatterns.facade;

/**
 * Created by aliismail on 28/12/2017.
 * Facade design pattern hides complexity of a task and provides a simple interface.
 * The startup of a computer is a good example.
 * When a computer starts up, it involves the work of cpu, memory, hard drive, etc.
 * To make it easy to use for users, we can add a facade which wrap the complexity of the task,
 * and provide one simple interface instead
 */
class CPU {
    public void processData() { }
}

class Memory {
    public void load() { }
}

class HardDrive {
    public void readdata() { }
}

/* Facade */
class Computer {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void run() {
        cpu.processData();
        memory.load();
        hardDrive.readdata();
    }
}


public class User {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.run();
    }
}

