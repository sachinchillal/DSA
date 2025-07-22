package helper;

public class ListNode {
  public int val;
  public ListNode next = null;
  public ListNode pre = null;

  public ListNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    String S = "val: " + val + "\t";
    if (next != null) {
      S += "next: " + next.val + "\t";
    } else {
      S += "next: null\t";
    }
    if (pre != null) {
      S += "pre: " + pre.val + "\t";
    } else {
      S += "pre: null\t";
    }

    return S;
  }

}
