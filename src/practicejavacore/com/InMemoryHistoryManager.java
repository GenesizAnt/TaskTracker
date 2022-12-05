package practicejavacore.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryHistoryManager implements HistoryManager {
    private List<Taskable> listTask = new ArrayList<>();
    private List<InMemoryHistoryManager> arrayList = new ArrayList<>();
    private InMemoryHistoryManager prev;
    private InMemoryHistoryManager next;
    private InMemoryHistoryManager first;
    private InMemoryHistoryManager last;
    private Taskable e;
    private int size = 0;

    private Map<Integer, Taskable> taskNodes = new HashMap<>();
    private ManagerTask managerTask;
    private TaskNode headTaskNode;

    public void setManagerTask(ManagerTask managerTask) {
        this.managerTask = managerTask;
    }

//    public InMemoryHistoryManager(InMemoryHistoryManager prev, InMemoryHistoryManager next, Taskable e) {
//        this.prev = prev;
//        this.next = next;
//        this.e = e;
//    }
//
//    public InMemoryHistoryManager() {
//
//    }

//    public void removeInMemoryHistoryManager(InMemoryHistoryManager inMemoryHistoryManager) {
//        arrayList.remove(inMemoryHistoryManager);
//    }

//    public void getTask() {
//        for (InMemoryHistoryManager value : arrayList) {
//            listTask.add(value.e);
//        }
//    }

    public List<Taskable> getHistory() {
        return listTask;
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).e.getId() == id) {
                arrayList.remove(i);
            }
        }
    }

    public void linkLastInMemoryHistoryManager(Taskable taskable) {
        final InMemoryHistoryManager l = last;
        final InMemoryHistoryManager newTask = new InMemoryHistoryManager(l, null, taskable);
        last = newTask;
        if (l == null)
            first = newTask;
        else
            l.next = newTask;
        size++;
    }

    public void add(Taskable taskable) {
        //7:19
    }



//    public void add(Taskable taskable) {
//        if (mapList.isEmpty()) {
//            first = new InMemoryHistoryManager(null, null, taskable);
//            mapList.put(first.e.getId(), first);
//        } else if (mapList.size() < 10) {
//            final InMemoryHistoryManager newTask = new InMemoryHistoryManager(mapList.get(mapList.size() - 1), first, taskable);
//            next = newTask;
//            mapList.put(newTask.e.getId(), newTask);
////            mapList.get(n)
////            mapList.get(mapList.size() - 2).setNext(mapList.get(mapList.size() - 1));
//        } else if (mapList.size() == 11) {
//            final InMemoryHistoryManager newTask = new InMemoryHistoryManager(mapList.get(mapList.size() - 1), first, taskable);
//            next = newTask.first;
//            mapList.put(newTask.e.getId(), newTask);
//        } else {
//            final InMemoryHistoryManager newTask = new InMemoryHistoryManager(next, first, taskable);
//            mapList.put(newTask.e.getId(), newTask);
//            mapList.remove(first);
//        }
//    }

    private static class TaskNode {
        private int taskId;
        private TaskNode previousNode;
        private TaskNode nextNode;

        public TaskNode(int taskId) {
            this.taskId = taskId;
        }
    }


    public void setNext(InMemoryHistoryManager next) {
        this.next = next;
    }

    public List<InMemoryHistoryManager> getMapList() {
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
