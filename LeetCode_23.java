class ListNode4 {
    int val;
    ListNode4 next;

    ListNode4(int x) {
        this.val = x;
        next = null;
    }
}
public class LeetCode_23 {
    public ListNode4 mergeKLists(ListNode4[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }
    private ListNode4 mergeKListsHelper(ListNode4[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }
        int mid = start + (end - start) / 2;
        ListNode4 left = mergeKListsHelper(lists, start, mid);
        ListNode4 right = mergeKListsHelper(lists, mid + 1, end);
        return merge(left, right);
    }
    private ListNode4 merge(ListNode4 l1, ListNode4 l2) {
        ListNode4 dummy = new ListNode4(0);
        ListNode4 curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        // Create an array of ListNode4
        ListNode4[] lists = new ListNode4[3];
        lists[0] = arrayToListNode(new int[] { 1, 4, 5 });
        lists[1] = arrayToListNode(new int[] { 1, 3, 4 });
        lists[2] = arrayToListNode(new int[] { 2, 6 });

        // Print the input lists
        System.out.println("Input Lists:");
        for (ListNode4 list : lists) {
            printListNode(list);
        }

        // Merge the lists using the LeetCode_23 class
        LeetCode_23 solution = new LeetCode_23();
        ListNode4 result = solution.mergeKLists(lists);

        // Print the merged list
        System.out.println("\nMerged Sorted List:");
        printListNode(result);
    }

    // Helper method to convert an array into a ListNode4
    private static ListNode4 arrayToListNode(int[] arr) {
        ListNode4 dummy = new ListNode4(0);
        ListNode4 current = dummy;
        for (int val : arr) {
            current.next = new ListNode4(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print a ListNode4
    private static void printListNode(ListNode4 head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
