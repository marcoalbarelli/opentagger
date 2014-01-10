package it.opencontent.android.opentagger.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "google", "http://www.google.com"));
        addItem(new DummyItem("2", "opentagger", "http://opentagger.opencontent.it"));
        addItem(new DummyItem("3", "ez publish", "http://ez.no"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;
        public String uri;

        public DummyItem(String id, String content, String uri) {
            this.id = id;
            this.content = content;
            this.uri = uri;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
