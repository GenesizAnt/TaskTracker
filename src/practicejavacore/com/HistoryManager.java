package practicejavacore.com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HistoryManager {
    private List<Taskable> listTask = new ArrayList<>();
    HistoryManager prev;
    HistoryManager next;
    HistoryManager first;
    HistoryManager last;
    Taskable e;


    public HistoryManager(HistoryManager prev, HistoryManager next, Taskable e) {
        this.prev = prev;
        this.next = next;
        this.e = e;
    }

    public HistoryManager() {

    }


    public void history() {
        for (Taskable taskable : listTask) {
            System.out.println(taskable);
        }
    }


//    public void historyAdd(Taskable taskable) {
//        if (listTask.isEmpty()) {
//            first = new HistoryManager(null, null, taskable);
//            listTask.add(taskable);
//        } else if (listTask.size() < 10) {
//            final HistoryManager newTask = new HistoryManager(first, null, taskable);
//            next = newTask;
//            listTask.add(newTask.e);
//        } else if (listTask.size() == 11) {
//            final HistoryManager newTask = new HistoryManager(first, next, taskable);
//            next = newTask.first;
//            listTask.add(newTask.e);
//        } else {
//            final HistoryManager newTask = new HistoryManager(first, next, taskable);
//            next = newTask.next;
//            listTask.add(0, newTask.e);
//            listTask.remove(listTask.size() - 1);
//        }
//    }

//    public void historyAdd(Taskable taskable) {
//        if (listTask.isEmpty()) {
//            first = new HistoryManager(null, null, taskable);
//            listTask.add(taskable);
//        } else if (listTask.size() < 10) {
//            final HistoryManager newTask = new HistoryManager(first, null, taskable);
//            next = newTask;
//            listTask.add(newTask.e);
//        } else if (listTask.size() == 11) {
//            final HistoryManager newTask = new HistoryManager(first, next, taskable);
//            next = newTask.first;
//            listTask.add(newTask.e);
//        } else {
//            final HistoryManager newTask = new HistoryManager(first, next, taskable);
//            first = next;
//            first.next = newTask.next;
//            listTask.add(listTask.size(), newTask.e);
//            listTask.remove(0);
//        }
//    }

    public void historyAdd(Taskable taskable) {
        if (listTask.isEmpty()) {
//            first = new HistoryManager(null, null, taskable);
            listTask.add(taskable);
        } else if (listTask.size() < 10) {
//            final HistoryManager newTask = new HistoryManager(first, null, taskable);
//            next = newTask;
            listTask.add(taskable);
        } else if (listTask.size() == 11) {
//            final HistoryManager newTask = new HistoryManager(first, next, taskable);
//            next = newTask.first;
            listTask.add(taskable);
        } else {
//            final HistoryManager newTask = new HistoryManager(first, next, taskable);
//            first = next;
//            first.next = newTask.next;
            listTask.add(listTask.size(), taskable);
            listTask.remove(0);
        }
    }

    public List<Taskable> getListTask() {
        return listTask;
    }

    public HistoryManager getPrev() {
        return prev;
    }

    public HistoryManager getNext() {
        return next;
    }

    public HistoryManager getFirst() {
        return first;
    }

    public HistoryManager getLast() {
        return last;
    }

    public Taskable getE() {
        return e;
    }
}

//    private void linkFirst(E e) {
//        final LinkedList.Node<E> f = first;
//        final LinkedList.Node<E> newNode = new LinkedList.Node<>(null, e, f);
//        first = newNode;
//        if (f == null)
//            last = newNode;
//        else
//            f.prev = newNode;
//        size++;
//        modCount++;
//    }
//
//    /**
//     * Links e as last element.
//     */
//    void linkLast(E e) {
//        final LinkedList.Node<E> l = last;
//        final LinkedList.Node<E> newNode = new LinkedList.Node<>(l, e, null);
//        last = newNode;
//        if (l == null)
//            first = newNode;
//        else
//            l.next = newNode;
//        size++;
//        modCount++;
//    }