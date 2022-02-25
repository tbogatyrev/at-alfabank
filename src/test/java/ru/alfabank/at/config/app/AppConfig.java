package ru.alfabank.at.config.app;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/app/app.properties"
})
public interface AppConfig extends Config {

    String webUrl();
}
