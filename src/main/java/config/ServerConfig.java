package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface ServerConfig extends Config {

    @Key("url")
    @DefaultValue("http://ya.ru")
    String url();
}
