import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class MyHeap {
        private int[] heap;
        private int size;

        public MyHeap(int capacity) {
            this.heap = new int[capacity];
            this.size = 0;
        }

        public int pop() {
            if (size == 0) {
                return 0;
            }
            int top = heap[0];
            heap[0] = heap[--size];
            heapifyDown(0);
            return top;
        }

        public void add(int x) {
            heap[size] = x;
            heapifyUp(size++);
        }

        private void heapifyUp(int idx) {
            int parentIdx = (idx - 1) / 2;
            while (idx > 0 && heap[parentIdx] < heap[idx]) {
                swap(parentIdx, idx);
                idx = parentIdx;
                parentIdx = (idx - 1) / 2;
            }
        }

        private void heapifyDown(int idx) {
            int largest = idx;
            int leftIdx = idx * 2 + 1;
            int rightIdx = idx * 2 + 2;

            if (leftIdx < size && heap[leftIdx] > heap[largest]) {
                largest = leftIdx;
            }
            if (rightIdx < size && heap[rightIdx] > heap[largest]) {
                largest = rightIdx;
            }
            if (largest != idx) {
                swap(largest, idx);
                heapifyDown(largest);
            }
        }

        private void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        MyHeap heap = new MyHeap(n);
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                sb.append(heap.pop() + "\n");
                continue;
            }
            heap.add(x);
        }
        System.out.println(sb);
    }
}