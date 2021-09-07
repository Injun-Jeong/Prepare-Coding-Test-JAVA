package leetcode;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Q146_LRU_Cache {
    class DataObj {
        int key;
        int value;
        LocalDateTime localDateTime;

        DataObj(int key, int value, LocalDateTime localDateTime) {
            this.key = key;
            this.value = value;
            this.localDateTime = localDateTime;
        }

        public boolean isBefore(DataObj obj) {
            return localDateTime.isBefore(obj.localDateTime);
        }
    }

    final int CAPACITY;
    PriorityQueue<DataObj> pq;
    Map<Integer, DataObj> cacheMap;

    public Q146_LRU_Cache(int capacity) {
        CAPACITY = capacity;
        pq = new PriorityQueue<>((o1, o2) -> o2.isBefore(o1) ? 1 : -1);
        cacheMap = new HashMap();
    }

    public int get(int key) {
        DataObj dataObj = cacheMap.get(key);
        if (Objects.isNull(dataObj) ) {
            return -1;
        } else {
            pq.remove(dataObj);
            dataObj.localDateTime = LocalDateTime.now();
            pq.add(dataObj);
            return dataObj.value;
        }
    }

    public void put(int key, int value) {
        DataObj dataObj;
        if (cacheMap.keySet().contains(key)) {
            dataObj = cacheMap.get(key);
            dataObj.value = value;
            pq.remove(dataObj);
            dataObj.localDateTime = LocalDateTime.now();
        } else {
            dataObj = new DataObj(key, value, LocalDateTime.now());
            cacheMap.put(key, dataObj);
            removeIfOverCapacity();
        }
        pq.add(dataObj);
    }

    private void removeIfOverCapacity() {
        if (pq.size() == CAPACITY) {
            DataObj dataObj = pq.poll();
            cacheMap.remove(dataObj.key);
        }
    }
}
