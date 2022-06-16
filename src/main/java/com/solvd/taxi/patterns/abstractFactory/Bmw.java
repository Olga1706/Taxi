package com.solvd.taxi.patterns.abstractFactory;

public class Bmw implements ICarServices {

    @Override
    public IGas refunGas() {
        return new BmwGas();
    }

    @Override
    public IDiesel refunDiesel() {
        return new BmwDiesel();
    }
}
