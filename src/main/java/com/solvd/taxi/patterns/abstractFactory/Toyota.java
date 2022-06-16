package com.solvd.taxi.patterns.abstractFactory;

public class Toyota implements ICarServices {
    @Override
    public IGas refunGas() {
        return new ToyotaGas();
    }

    @Override
    public IDiesel refunDiesel() {
        return new ToyotaDiesel();
    }
}
