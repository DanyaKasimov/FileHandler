package app.utils;

import app.exceptions.InvalidDataException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

@Component
public class MaxHeap {

    public int getMinNum(final List<Integer> numbers, final int number) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : numbers) {
            if (maxHeap.size() < number) {
                maxHeap.offer(num);
            } else if (num < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(num);
            }
        }

        Integer result = maxHeap.peek();
        if (result == null) {
            throw new RuntimeException("Не удалось определить результат");
        }
        return result;
    }
}
