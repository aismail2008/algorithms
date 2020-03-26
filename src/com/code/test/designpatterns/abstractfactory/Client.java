package com.code.test.designpatterns.abstractfactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

interface Human {
    String talk();
}

class Boy implements Human {
    private String name;

    public Boy(String name) {
        this.name = name;
    }

    public String talk() {
        System.out.println(name + ": I am a Boy in thread:" + Thread.currentThread().getName());
        return name + ": I am a Boy";
    }
}

class Girl implements Human {
    private String name;

    public Girl(String name) {
        this.name = name;
    }

    public String talk() {
        System.out.println(name + ": I am a Girl");
        return name + ": I am a Girl";
    }
}

//---------------------------
interface HumanFactory {
    Human createHuman();
}

class BoyFactory implements HumanFactory {
    public Human createHuman() {
        return new Boy(Client.counter.incrementAndGet()+"");
    }
}

class GirlFactory implements HumanFactory {
    public Human createHuman() {
        return new Girl(Client.counter.incrementAndGet()+"");
    }
}
//.... add more factories as our business grows

//----------------------------
class HumanCreator {
    private HumanFactory humanFactory;

    public HumanCreator(HumanFactory factory) {
        this.humanFactory = factory;
    }

    public Human createHuman() {
        return humanFactory.createHuman();
    }
}

public class Client {
    static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        HumanCreator creator = new HumanCreator(createSpecificFactory());

        int i = 0;
        while (i++ < 1000) {
            CompletableFuture.supplyAsync(() -> creator.createHuman().talk());
        }

        Thread.sleep(5000);
        System.out.println("==========" + counter);
    }

    public static HumanFactory createSpecificFactory() {
        int sys = 0; // based on specific requirement
        if (sys == 0)
            return new BoyFactory();
        else
            return new GirlFactory();
    }
}