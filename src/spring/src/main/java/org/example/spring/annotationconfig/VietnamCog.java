package org.example.spring.annotationconfig;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class VietnamCog implements Cog {
    @Override
    public String getType() {
        return "VietnamCog";
    }
}
