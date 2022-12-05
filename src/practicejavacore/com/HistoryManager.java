package practicejavacore.com;

import java.util.List;

interface HistoryManager {

    void add(Taskable taskable);

    List<Taskable> getHistory();

    void remove(int id);

}
