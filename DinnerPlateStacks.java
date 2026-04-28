import java.util.*;

class DinnerPlates {

    private List<Stack<Integer>> stacks;
    private PriorityQueue<Integer> pushPQ; // min-heap
    private int capacity;
    private int rightMost;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        stacks = new ArrayList<>();
        pushPQ = new PriorityQueue<>();
        rightMost = -1;
    }

    public void push(int val) {

        // Remove invalid indices from heap
        while (!pushPQ.isEmpty() && pushPQ.peek() < stacks.size()
                && stacks.get(pushPQ.peek()).size() == capacity) {
            pushPQ.poll();
        }

        int index;

        if (!pushPQ.isEmpty()) {
            index = pushPQ.poll();
        } else {
            index = stacks.size();
            stacks.add(new Stack<>());
        }

        stacks.get(index).push(val);

        // If still not full, add back
        if (stacks.get(index).size() < capacity) {
            pushPQ.offer(index);
        }

        rightMost = Math.max(rightMost, index);
    }

    public int pop() {

        while (rightMost >= 0 && stacks.get(rightMost).isEmpty()) {
            rightMost--;
        }

        if (rightMost < 0) return -1;

        int val = stacks.get(rightMost).pop();

        pushPQ.offer(rightMost);

        return val;
    }

    public int popAtStack(int index) {

        if (index >= stacks.size() || stacks.get(index).isEmpty()) {
            return -1;
        }

        int val = stacks.get(index).pop();

        pushPQ.offer(index);

        return val;
    }
}
