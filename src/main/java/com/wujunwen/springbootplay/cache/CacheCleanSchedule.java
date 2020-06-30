package com.wujunwen.springbootplay.cache;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CacheCleanSchedule {

    @Scheduled(fixedDelay = 60000)
    public void cleanUp(){
      for (Map.Entry<Integer,Long> e: PersonCache.useRecord.entrySet()){
          if (e.getValue()-System.currentTimeMillis()>6000){
              clean(e);
          }
      }
    }

    /**
     * 根据key将PersonCache.personHashMap清楚
     */
    public void clean(Map.Entry entry){
        PersonCache.personHashMap.remove(entry.getKey());
    }
}
