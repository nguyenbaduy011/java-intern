package org.example.spring.annotationconfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BikeSetter {
    private Cog cog;

    @Autowired
    public void setCog(@Qualifier("CC") Cog cog) {
        this.cog = cog;
    }

    public void showCog() {
        System.out.println("Setter Configuration: " + cog.getType());
    }
}
