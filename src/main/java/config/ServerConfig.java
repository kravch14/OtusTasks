package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface ServerConfig extends Config {

    @Key("url1")
    //@DefaultValue("http://ya.ru")
    String url1();

    @Key("url2")
        //@DefaultValue("http://ya.ru")
    String url2();
}
