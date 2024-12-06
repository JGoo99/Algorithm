import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class MyHeap {

        int[] heap;
        int top;
        int count;

        public MyHeap(int n) {
            this.heap = new int[n];
            this.top = 0;
            this.count = 0;
        }

        public void add(int x) {
            if (count == 0) {
                heap[top] = x;
                count++;
                return;
            }
            
            int idx = search(x);
            move(idx);
            heap[idx] = x;
            top = Math.min(top, idx);
            count++;
        }

        private void move(int idx) {
            for (int i = top + count; i > idx; i--) {
                heap[i] = heap[i - 1];
            }
        }

        public int search(int x) {
            int start = top;
            int end = top + count;

            while (start < end) {
                int mid = (start + end) / 2;
                if (heap[mid] < x) {
                    start = mid + 1;
                    continue;
                }
                end = mid;
            }
            return start;
        }

        public int poll() {
            if (count > 0) {
                count--;
                return heap[top++];
            }
            return heap[top];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        MyHeap heap = new MyHeap(n);

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sb.append(heap.poll() + "\n");
                continue;
            }
            heap.add(num);
        }
        System.out.println(sb);
    }
}