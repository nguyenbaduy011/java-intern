package org.example.spring.xmlconfig;

public class CarSetter {
    private Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void showEngine() {
        System.out.println("Setter Configuration: " + engine.getType());
    }
}
