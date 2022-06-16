package com.solvd.taxi.patterns.observer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Observer implements IObserver{
    private static final Logger LOGGER = LogManager.getLogger(Observer.class);

    String name;
    String value;
    static List<Observer> observerList = new ArrayList<>();

    public Observer(String name) {
        this.name = name;
        observerList.add(this);
    }

    public void setValue(String value) {
        this.value = value;
        notifyAllObservers();
    }

    void notifyAllObservers() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }

    @Override
    public void update() {
        LOGGER.info(name + " Current value: " + value);
    }
}
