package com.github.giovane;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Application;

public class MainApplication extends Application {

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("jersey.config.server.provider.packages", "com.github.giovane");
        return properties;
    }

}
