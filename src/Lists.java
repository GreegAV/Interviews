import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        int count = 1000_000;
        System.out.println("Linked vs Array insert to the end:");
        System.out.println("Link: " + addToList(new LinkedList<>(), count, "end")+" ms");
        System.out.println("Array: " + addToList(new ArrayList<>(), count, "end")+" ms");
////////////////////////////////////////////////////////////////////////////
        System.out.println("Linked vs Array insert to the start:");
        System.out.println("Link: " + addToList(new LinkedList<>(), count, "start")+" ms");
        System.out.println("Array: " + addToList(new ArrayList<>(), count, "start")+" ms");
///////////////////////////////////////////////////////////////////////////////////
        System.out.println("Linked vs Array insert to the center:");
        System.out.println("Link: " + addToList(new LinkedList<>(), count, "center")+" ms");
        System.out.println("Array: " + addToList(new ArrayList<>(), count, "center")+" ms");
    }

    private static long addToList(List<Integer> list, int count, String position) {
        long start = System.currentTimeMillis();
        switch (position) {
            case "start":
                for (int i = 0; i < count; i++) {
                    list.add(0, i);
                }
                break;
            case "center":
                for (int i = 0; i < count; i++) {
                    list.add(list.size() / 2, i);
                }
                break;
            case "end":
                for (int i = 0; i < count; i++) {
                    list.add(i);
                }
                break;
        }
        return System.currentTimeMillis() - start;
    }
}
