package fr.javageek.infinispan;


import org.infinispan.client.hotrod.RemoteCacheManager;

public class ConfigLoader {

    private  ConfigLoader() { /* utility class */ }

    public static RemoteCacheManager loadHotRodClientConfig() {
        // by default, look for a file "hotrod-client.properties"
        RemoteCacheManager cacheContainer = new RemoteCacheManager(true);
        return cacheContainer;
    }
}
