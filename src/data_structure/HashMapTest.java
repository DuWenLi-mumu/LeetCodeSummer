package data_structure;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Key,Integer> hashMap = new HashMap<>();
        Key key1 = new Key(1);
        Key key2 = new Key(1);
        hashMap.put(key1,2);
        System.out.println(hashMap.get(key2));

    }
    static class Key{
        int id;
        public Key(int id){
            this.id = id;
        }

        @Override
        public int hashCode() {
            return this.id;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Key && this.id == ((Key) obj).id;
        }
    }
}
