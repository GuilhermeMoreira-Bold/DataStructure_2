package src.algorithms;

import java.lang.reflect.Type;
import java.util.LinkedList;

public interface SortingAlgorithm<T> {
    LinkedList<T> sort(LinkedList<T> lista);
}
