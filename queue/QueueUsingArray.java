package queue;

public class QueueUsingArray {
  static int[] A = new int[0];
  static int front = -1;
  static int rear = -1;

  public static void enqueue(int e) {
    System.out.println("Enqueue: " + e);
    int n = A.length;
    int[] R = new int[n + 1];
    System.arraycopy(A, 0, R, 0, n);
    // System.out.println(Arrays.toString(A));
    // System.out.println(Arrays.toString(R));
    R[n] = e;
    A = R;
    if (front == rear && front == -1) {
      front = n;
    } else if (front == -1) {
      front++;
    }
    rear = n;
  }

  public static void dequeue() {
    if (front == -1) {
      return;
    }
    System.out.println("Dequeue: " + A[(front)]);
    // A[front] = -A[front]; // for understand
    front++;
    if (front > A.length) {
      front = -1;
    } else if (front == A.length) {
      front = rear = -1;
    }
  }

  public static int front() {
    if (front == -1) {
      return -1;
    }
    return A[front];
    // return front;
  }

  public static int rear() {
    if (rear == -1) {
      return -1;
    }
    return A[rear];
  }

  public static int size() {
    if (front == -1) {
      return 0;
    }
    return rear - front + 1;
  }

  public static boolean isEmpty() {
    return rear == -1 && front == -1;
  }

  public static int[] getArray() {
    return A;
  }
}
