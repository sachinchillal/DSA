package queue;

import java.util.Arrays;
import java.lang.reflect.Method;
// core concept in Java called reflection and
// highlights a key difference between how code is written and how it can be controlled at runtime.
// Pass a class as an argument and invoke its static methods

public class QueueTests {
  public static void main(String[] args) {
    System.out.println();
    // testForList();
    // testsForQueue(QueueUsingList.class);
    // testsForQueue(QueueUsingArray.class);
    // testsForQueue(QueueUsingStack.class);
    testsForQueue(QueueUsingLinkedList.class);
  }

  static void testsForQueue(Class<?> clazz) {
    try {
      Method isEmpty = clazz.getMethod("isEmpty");
      Method enqueue = clazz.getMethod("enqueue", int.class);
      Method dequeue = clazz.getMethod("dequeue");
      Method front = clazz.getMethod("front");
      Method rear = clazz.getMethod("rear");
      Method size = clazz.getMethod("size");
      Method getArray = clazz.getMethod("getArray");

      enqueue.invoke(null, 10);
      enqueue.invoke(null, 20);
      validator(getArray, front, rear, size, isEmpty, new int[] { 10, 20 }, 10, 20, 2, false);

      enqueue.invoke(null, 30);
      validator(getArray, front, rear, size, isEmpty, new int[] { 10, 20, 30 }, 10, 30, 3, false);

      dequeue.invoke(null);
      validator(getArray, front, rear, size, isEmpty, new int[] { 10, 20, 30 }, 20, 30, 2, false);

      dequeue.invoke(null);
      validator(getArray, front, rear, size, isEmpty, new int[] { 10, 20, 30 }, 30, 30, 1, false);

      dequeue.invoke(null);
      validator(getArray, front, rear, size, isEmpty, new int[] { 10, 20, 30 }, -1, -1, 0, true);

      dequeue.invoke(null);
      enqueue.invoke(null, 40);
      enqueue.invoke(null, 50);

      validator(getArray, front, rear, size, isEmpty, new int[] { 10, 20, 30, 40, 50 }, 40, 50, 2, false);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static void testForList() {
    QueueUsingList.enqueue(10);
    QueueUsingList.enqueue(20);
    QueueUsingList.enqueue(30);

    QueueUsingList.dequeue();

    System.out.println();
    System.out.println(Arrays.toString(QueueUsingList.getArray()));
    System.out.println("Front: " + QueueUsingList.front());
    System.out.println("Rear: " + QueueUsingList.rear());
    System.out.println("Size: " + QueueUsingList.size());
    System.out.println("IsEmpty: " + QueueUsingList.isEmpty());

    QueueUsingList.dequeue();
    QueueUsingList.dequeue();
    QueueUsingList.dequeue();

    System.out.println();
    System.out.println(Arrays.toString(QueueUsingList.getArray()));
    System.out.println("Front: " + QueueUsingList.front());
    System.out.println("Rear: " + QueueUsingList.rear());
    System.out.println("Size: " + QueueUsingList.size());
    System.out.println("IsEmpty: " + QueueUsingList.isEmpty());
  }

  static void validator(Method getArray, Method front, Method rear, Method size, Method isEmpty, int[] A, int f, int r,
      int s, boolean is) {
    try {
      System.out.println();
      int[] R = (int[]) getArray.invoke(null);
      if (!Arrays.equals(A, R)) {
        System.out.println("Queue is not matching");
      }
      System.out.println(Arrays.toString(R));
      int F = (int) front.invoke(null);
      System.out.println("Front: " + F);
      if (F != f) {
        System.out.println("Front is not matching");
      }
      int Rr = (int) rear.invoke(null);
      System.out.println("Rear: " + Rr);
      if (Rr != r) {
        System.out.println("Rear is not matching");
      }
      int S = (int) size.invoke(null);
      System.out.println("Size: " + S);
      if (S != s) {
        System.out.println("Size is not matching");
      }
      boolean I = (boolean) isEmpty.invoke(null);
      System.out.println("IsEmpty: " + I);
      if (I != is) {
        System.out.println("IsEmpty is not matching");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
