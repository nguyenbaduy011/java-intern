package org.example.spring.annotationconfig;

import org.springframework.stereotype.Component;

@Component("CC")
public class ChinaCog implements Cog {
    @Override
    public String getType() {
        return "ChinaCog";
    }
}
