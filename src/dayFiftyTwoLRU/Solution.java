package dayFiftyTwoLRU;
import java.util.*;

public class Solution {
    public static class DLinkedList {
        String key;
        DLinkedList prev;
        DLinkedList next;

        public DLinkedList(String key) {
            this.key = key;
        }
    }

    public static class LRU {
        HashMap<String,String> cacheValues;
        HashMap<String,DLinkedList> cacheLRU;
        DLinkedList oldest;
        DLinkedList first;
        int size;

        public LRU(int size) {
            this.cacheValues = new HashMap<String,String>();
            this.cacheLRU = new HashMap<String,DLinkedList>();
            this.size = size;
        }

        public void set(String key, String value) {
            if(!this.cacheValues.containsKey(key)) {
                DLinkedList newNode = new DLinkedList(key);
                newNode.next = first;
                if(first != null) {
                    first.prev = newNode;
                }
                first = newNode;


                if(this.cacheValues.size() < size) {
                    if(oldest == null) {
                        oldest = first;
                    }
                } else {
                    String oldestKey = oldest.key;
                    oldest = oldest.prev;
                    oldest.next = null;
                    cacheValues.remove(oldestKey);
                    cacheLRU.remove(oldestKey);
                }

                cacheValues.put(key, value);
                cacheLRU.put(key, newNode);
            } else {
                updateUsedKey(key);
            }
        }

        public String get(String key) {
            if(!this.cacheValues.containsKey(key)) {
                return null;
            }
            updateUsedKey(key);
            return this.cacheValues.get(key);
        }

        private void updateUsedKey(String key) {
            DLinkedList keyList = cacheLRU.get(key);
            if(keyList == first) {
                return;
            }

            if(keyList == oldest) {
                oldest = oldest.prev;
                oldest.next = null;
                keyList.next = first;
                first = keyList;
                return;
            }

            DLinkedList prevNode = keyList.prev;
            DLinkedList nextNode = keyList.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            keyList.next = first;
            first = keyList;
        }

        public void printCache() {
            DLinkedList aux = first;
            while(aux != null) {
                System.out.println(aux.key);
                aux = aux.next;
            }
        }
    }

    public static void main(String[] args) {
        LRU cache = new LRU(2);

        cache.set("Teste", "1");
        cache.set("Teste2", "2");
        cache.printCache();
        System.out.println("");
        System.out.println(cache.get("Teste"));
        cache.printCache();


    }
}
