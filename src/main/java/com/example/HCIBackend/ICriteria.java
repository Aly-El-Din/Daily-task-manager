package com.example.HCIBackend;

import java.util.HashMap;
import java.util.LinkedList;

public interface ICriteria {

    LinkedList<WorkTask> meetCriteria(HashMap<String, LinkedList<WorkTask>> tasks, String subString);


}
