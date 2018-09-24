package kartollika.hw2_list;

import java.util.Collection;

public class CollectionsStart {

    private void listExecute() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("#1");
        myLinkedList.add("#2");
        myLinkedList.add("#3");
        myLinkedList.add("#4");
        myLinkedList.remove("#4");
        myLinkedList.remove("4");
        myLinkedList.remove(0);
        System.out.println(myLinkedList.toString());
    }

    private void queueExecute() {
        MyQueue myQueue = new MyQueue();
        myQueue.add("#1");
        myQueue.add("#2");
        myQueue.add("#3");
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());

        System.out.println(myQueue.toString());
    }

    public static void main(String[] args) {
        CollectionsStart collectionsStart = new CollectionsStart();
        collectionsStart.listExecute();
        System.out.println();
        collectionsStart.queueExecute();
    }
}
