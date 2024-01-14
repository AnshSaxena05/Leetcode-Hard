import java.util.HashMap;
import java.util.Map;

public class LeetCode_146 {

    class ListNode6 {
        int key;
        int val;
        ListNode6 next;
        ListNode6 prev;

        ListNode6(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    int capacity;
    Map<Integer, ListNode6> mp;
    ListNode6 head;
    ListNode6 tail;

    public LeetCode_146(int capacity) {
        this.capacity = capacity;
        head = new ListNode6(0, 0);
        tail = new ListNode6(0, 0);
        head.next = tail;
        tail.prev = head;
        this.mp = new HashMap<>();
    }

    private void addToFront(ListNode6 node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    private void remove(ListNode6 node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if(mp.containsKey(key)){
            ListNode6 temp = mp.get(key);
            int ans = temp.val;
            remove(temp);
            addToFront(temp);
            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(mp.containsKey(key)){
            ListNode6 temp = mp.get(key);
            remove(temp);
            mp.remove(temp.key);
        } else if(mp.size() == capacity){
            ListNode6 temp = tail.prev;
            remove(temp);
            mp.remove(temp.key);
        }

        ListNode6 newNode = new ListNode6(key, value);
        addToFront(newNode);
        mp.put(key, newNode);
    }

    private void printMap() {
        System.out.println("Current Map: ");
        for (Map.Entry<Integer, ListNode6> entry : mp.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue().val);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        LeetCode_146 lruCache = new LeetCode_146(2);

        lruCache.put(1, 1);
        lruCache.printMap();

        lruCache.put(2, 2);
        lruCache.printMap();

        System.out.println(lruCache.get(1)); // Output: 1
        lruCache.printMap();

        lruCache.put(3, 3); // Removes key 2
        lruCache.printMap();

        System.out.println(lruCache.get(2)); // Output: -1 (not found)
        lruCache.printMap();

        lruCache.put(4, 4); // Removes key 1
        lruCache.printMap();

        System.out.println(lruCache.get(1)); // Output: -1 (not found)
        lruCache.printMap();

        System.out.println(lruCache.get(3)); // Output: 3
        lruCache.printMap();

        System.out.println(lruCache.get(4)); // Output: 4
        lruCache.printMap();
    }
}
