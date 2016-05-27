package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lizhitao on 15-12-21.
 */
public class TestHash {
    private static Set<String> tables;
    static {
        tables = new HashSet<String>();
        tables.add("tab0");
        tables.add("tab1");
        tables.add("tab2");
        tables.add("tab3");
        tables.add("tab4");
        tables.add("tab5");
        tables.add("tab6");
        tables.add("tab7");
        tables.add("tab8");
        tables.add("tab9");
    }

    public static void main(String[] args) {
        ConsistentHash<String> consistentHash = new ConsistentHash<String>(new HashFunction(), 10, tables);
        System.out.println(consistentHash.get("sfsdfsdf1"));
    }
}
