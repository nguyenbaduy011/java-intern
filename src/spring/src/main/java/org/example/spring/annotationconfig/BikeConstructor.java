package org.example.spring.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BikeConstructor {
    private final Cog cog;

    @Autowired
    BikeConstructor(@Qualifier("vietnamCog") Cog cog) {
        this.cog = cog;
    }

    public void showCog() {
        System.out.println("Constructor Configuration: " + cog.getType());
    }
}
