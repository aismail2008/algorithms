package com.code.test.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aliismail on 16/12/2017.
 */
public class HeadHunter implements Subject {
    //define a list of users, such as Mike, Bill, etc.
    private ArrayList<Observer> userList;
    private ArrayList<String> jobs;

    public HeadHunter() {
        userList = new ArrayList<>();
        jobs = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        userList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        userList.remove(o);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer o : userList) {
            o.update(this);
        }
    }

    public void addJob(String job) {
        this.jobs.add(job);
        notifyAllObservers();
    }

    public List<String> getJobs() {
        return jobs;
    }
}