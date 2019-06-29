package com.sxk.lessons.link;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SinglyLinkedList {

  private Node head = null;

  //顺序插入
  //链表尾部插入
  public void add(String element) {

    Node newNode = new Node(element, null);
    //空链表，可以插入新节点作为head，也可以不操作
    if (head == null) {
      head = newNode;
    } else {
      Node last = head;
      while (last.next != null) {
        last = last.next;
      }
      last.next = newNode;
    }
  }

  //先将下一节点纪录下来，然后让当前节点指向上一节点，再将当前节点纪录下来,再让下一节点变为当前节点
  public Node inverseLinkList(Node head) {
    Node prev = new Node("999", null);
    Node cur = head;
    while (cur != null) {
      Node next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }


  public void printAll() {
    Node p = head;
    while (p != null) {
      System.out.print(p.e + "->");
      p = p.next;
    }
    System.out.println();
  }


  public static void main(String[] args) {
    SinglyLinkedList link = new SinglyLinkedList();
    link.add("a");
    link.add("b");
    link.add("c");
    link.add("d");
    link.printAll();
    Node newHead = link.inverseLinkList(link.head);
    Node p = newHead;
    while (p.next != null) {
      System.out.print(p.e + "->");
      p = p.next;
    }
  }

  @Data
  @AllArgsConstructor
  private static class Node {

    private String e;
    private Node next;
  }

}
