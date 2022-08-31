import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lists {
    public static void main(String[] args) {
        int count = 100_000;

        System.out.println("Linked vs Array insert to the end:");
        System.out.println("Array: " + addToList(new ArrayList<>(), count, "end") + " ms");
        System.out.println("Link: " + addToList(new LinkedList<>(), count, "end") + " ms");
//////////////////////////////////////////////////////////////////////////
        System.out.println("Linked vs Array insert to the start:");
        System.out.println("Array: " + addToList(new ArrayList<>(), count, "start") + " ms");
        System.out.println("Link: " + addToList(new LinkedList<>(), count, "start") + " ms");
///////////////////////////////////////////////////////////////////////////////////
        System.out.println("Linked vs Array insert to the center:");
        System.out.println("Array: " + addToList(new ArrayList<>(), count, "center") + " ms");
        System.out.println("Link: " + addToList(new LinkedList<>(), count, "center") + " ms");

        System.out.println("---------------------------------------");

        System.out.println("Linked vs Array getting from the end:");
        System.out.println("Array: " + getFromTheList(getArrayList(count), "end") + " ms");
        System.out.println("Link: " + getFromTheList(getLinkedList(count), "end") + " ms");
//////////////////////////////////////////////////////////////////////////
        System.out.println("Linked vs Array getting from the start:");
        System.out.println("Array: " + getFromTheList(getArrayList(count), "start") + " ms");
        System.out.println("Link: " + getFromTheList(getLinkedList(count), "start") + " ms");
/////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Linked vs Array getting from the center:");
        System.out.println("Array: " + getFromTheList(getArrayList(count), "center") + " ms");
        System.out.println("Link: " + getFromTheList(getLinkedList(count), "center") + " ms");

        System.out.println("---------------------------------------");

        System.out.println("Linked vs Array delete from the end:");
        System.out.println("Array: " + deleteFromTheList(getArrayList(count), "end") + " ms");
        System.out.println("Link: " + deleteFromTheList(getLinkedList(count), "end") + " ms");
//////////////////////////////////////////////////////////////////////////
        System.out.println("Linked vs Array delete from the start:");
        System.out.println("Array: " + deleteFromTheList(getArrayList(count), "start") + " ms");
        System.out.println("Link: " + deleteFromTheList(getLinkedList(count), "start") + " ms");
/////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Linked vs Array delete from the center:");
        System.out.println("Array: " + deleteFromTheList(getArrayList(count), "center") + " ms");
        System.out.println("Link: " + deleteFromTheList(getLinkedList(count), "center") + " ms");
    }

    private static ArrayList<Integer> getArrayList(int count) {
        return IntStream.range(0, count).boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    private static LinkedList<Integer> getLinkedList(int count) {
        return IntStream.range(0, count).boxed().collect(Collectors.toCollection(LinkedList::new));
    }

    private static long addToList(List<Integer> list, int count, String position) {
        long start = System.currentTimeMillis();
        switch (position) {
            case "start" -> IntStream.range(0, count).forEach(i -> list.add(0, i));
            case "center" -> IntStream.range(0, count).forEach(i -> list.add(list.size() / 2, i));
            case "end" -> IntStream.range(0, count).forEach(list::add);
        }
        return System.currentTimeMillis() - start;
    }

    private static long getFromTheList(List<Integer> list, String position) {
        int pos = switch (position) {
            case "start" -> 0;
            case "center" -> list.size() / 2;
            case "end" -> list.size() - 1;
            default -> -1;
        };
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(pos);
        }
        return System.currentTimeMillis() - start;
    }

    private static long deleteFromTheList(List<Integer> list, String position) {
        long start = System.currentTimeMillis();
        while (list.size() > 0) {
            int pos = switch (position) {
                case "start" -> 0;
                case "center" -> list.size() / 2;
                case "end" -> list.size() - 1;
                default -> -1;
            };
            list.remove(pos);
        }
        return System.currentTimeMillis() - start;
    }
}
