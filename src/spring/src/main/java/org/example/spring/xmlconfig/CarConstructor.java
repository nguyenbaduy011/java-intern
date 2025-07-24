package org.example.spring.xmlconfig;

public class CarConstructor {
    private final Engine engine;

    CarConstructor(Engine engine) {
        this.engine = engine;
    }

    public void showEngine() {
        System.out.println("Constructor Configuration: " + engine.getType());
    }
}
