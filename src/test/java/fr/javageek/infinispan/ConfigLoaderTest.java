package fr.javageek.infinispan;

import org.infinispan.api.BasicCache;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.ServerStatistics;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.Map;

/**
 * Date: 16/06/13
 * Time: 23:29 <br>
 * Description : Test class for ConfigLoader
 *
 * @author JavaGeekFr
 */
public class ConfigLoaderTest {

    @Test
    public void testLoadHotRodClient() {
        RemoteCacheManager cacheContainer = ConfigLoader.loadHotRodClientConfig();
        RemoteCache<String, Object> cache =  cacheContainer.getCache("sessions");
        cache.put("123", "toto");
        Object result = cache.get("123");
        System.out.println(result);

        cacheContainer.stop();
    }

    @Test
    public void testStats() {
        RemoteCacheManager cacheContainer = ConfigLoader.loadHotRodClientConfig();
        RemoteCache<String, Object> cache =  cacheContainer.getCache("sessions");
        for (int i=0 ; i < 100 ; i++) {
            cache.put(Integer.toString(i), "test");
        }
        //Print cache statistics
        ServerStatistics stats = cache.stats();
        for (Map.Entry stat : stats.getStatsMap().entrySet()) {
            System.out.println(stat.getKey() + " : " + stat.getValue());
        }
        cacheContainer.stop();
    }

}
