package com.example.HCIBackend;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CriteriaDescription  implements ICriteria{

    @Override
    public LinkedList<WorkTask> meetCriteria(HashMap<String, LinkedList<WorkTask>> tasks, String subString) {
        LinkedList<WorkTask> filtered = new LinkedList<>();

        for (Map.Entry<String, LinkedList<WorkTask>> entry : tasks.entrySet()){
            for(WorkTask task:entry.getValue()) {
                if (task.getTaskDescription().contains(subString)) {
                    filtered.add(task);
                }
            }
        }
        return filtered;
    }
}
