package practicejavacore.com;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private List<Taskable> listTask = new ArrayList<>();
    private List<InMemoryHistoryManager> arrayList = new ArrayList<>();
    InMemoryHistoryManager prev;
    InMemoryHistoryManager next;
    InMemoryHistoryManager first;
    InMemoryHistoryManager last;
    Taskable e;


    public InMemoryHistoryManager(InMemoryHistoryManager prev, InMemoryHistoryManager next, Taskable e) {
        this.prev = prev;
        this.next = next;
        this.e = e;
    }

    public InMemoryHistoryManager() {

    }


//    public void history() {
//        for (Taskable taskable : listTask) {
//            System.out.println(taskable);
//        }
//    }

    public void getHistory() {
        for (InMemoryHistoryManager history : arrayList) {
            System.out.println(history.e);
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

    public void add(Taskable taskable) {
        if (arrayList.isEmpty()) {
            first = new InMemoryHistoryManager(null, null, taskable);
            arrayList.add(first);
        } else if (arrayList.size() < 10) {
            final InMemoryHistoryManager newTask = new InMemoryHistoryManager(arrayList.get(arrayList.size() - 1), first, taskable);
            next = newTask;
            arrayList.add(newTask);
            arrayList.get(arrayList.size() - 2).setNext(arrayList.get(arrayList.size() - 1));
        } else if (arrayList.size() == 11) {
            final InMemoryHistoryManager newTask = new InMemoryHistoryManager(arrayList.get(arrayList.size() - 1), first, taskable);
            next = newTask.first;
            arrayList.add(newTask);
        } else {
            final InMemoryHistoryManager newTask = new InMemoryHistoryManager(next, first, taskable);
            arrayList.add(arrayList.size(), newTask);
            arrayList.remove(0);
        }
    }

//    public void historyAdd(Taskable taskable) {
//        if (arrayList.isEmpty()) {
//            first = new HistoryManager(null, null, taskable);
//            arrayList.add(first);
////            listTask.add(taskable);
//        } else if (arrayList.size() < 10) {
//            final HistoryManager newTask = new HistoryManager(arrayList.get(arrayList.size() - 1), first, taskable);
//            next = newTask;
//            arrayList.add(newTask);
//            arrayList.get(arrayList.size() - 2).setNext(arrayList.get(arrayList.size() - 1));
////            listTask.add(newTask.e);
//        } else if (arrayList.size() == 11) {
//            final HistoryManager newTask = new HistoryManager(arrayList.get(arrayList.size() - 1), first, taskable);
//            next = newTask.first;
//            arrayList.add(newTask);
////            listTask.add(newTask.e);
//        } else {
//            final HistoryManager newTask = new HistoryManager(next, first, taskable);
////            first = next;
////            first.next = newTask.next;
//            arrayList.add(arrayList.size(), newTask);
//            arrayList.remove(0);
////            listTask.add(listTask.size(), newTask.e);
////            listTask.remove(0);
//        }
//    }

//    public void historyAdd(Taskable taskable) {
//        if (listTask.isEmpty()) {
////            first = new HistoryManager(null, null, taskable);
//            listTask.add(taskable);
//        } else if (listTask.size() < 10) {
////            final HistoryManager newTask = new HistoryManager(first, null, taskable);
////            next = newTask;
//            listTask.add(taskable);
//        } else if (listTask.size() == 11) {
////            final HistoryManager newTask = new HistoryManager(first, next, taskable);
////            next = newTask.first;
//            listTask.add(taskable);
//        } else {
////            final HistoryManager newTask = new HistoryManager(first, next, taskable);
////            first = next;
////            first.next = newTask.next;
//            listTask.add(listTask.size(), taskable);
//            listTask.remove(0);
//        }
//    }


    public void setNext(InMemoryHistoryManager next) {
        this.next = next;
    }

    public List<InMemoryHistoryManager> getArrayList() {
        return arrayList;
    }

    public List<Taskable> getListTask() {
        return listTask;
    }

    public InMemoryHistoryManager getPrev() {
        return prev;
    }

    public InMemoryHistoryManager getNext() {
        return next;
    }

    public InMemoryHistoryManager getFirst() {
        return first;
    }

    public InMemoryHistoryManager getLast() {
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