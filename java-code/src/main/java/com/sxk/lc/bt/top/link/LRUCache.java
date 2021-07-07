package com.sxk.lc.bt.top.link;

import java.util.HashMap;
import java.util.Map;

/***
 * @author sxk
 * https://leetcode-cn.com/problems/lru-cache/
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
public class LRUCache {

  private int size;
  private int capacity;
  private Node head;
  private Node tail;

  private static class Node {

    private int key;
    private int val;
    private Node pre;
    private Node next;
  }


  private Map<Integer, Node> map = new HashMap<>();

  public LRUCache(int capacity) {
    this.size = 0;
    this.capacity = capacity;
    this.head = new Node();
    this.tail = new Node();
    head.next = tail;
    tail.pre = head;

  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      moveToHead(node);
      return node.val;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      node.val = value;
      moveToHead(node);
    } else {
      if (size == capacity) {
        Node node = removeTail();
        map.remove(node.key);
      }
      Node node = new Node();
      node.key = key;
      node.val = value;
      addHead(node);
      map.put(key, node);
    }
  }

  public void moveToHead(Node node) {
    removeNode(node);
    addHead(node);
  }

  public void removeNode(Node node) {
    Node nodeNext = node.next;
    Node nodePre = node.pre;
    nodePre.next = nodeNext;
    nodeNext.pre = nodePre;
    size--;
  }

  public void addHead(Node node) {
    size++;
    Node next = head.next;
    node.next = next;
    next.pre = node;
    head.next = node;
    node.pre = head;
  }


  public Node removeTail() {
    size--;
    Node pre = tail.pre;
    tail.pre.pre.next = tail;
    tail.pre = pre.pre;
    return pre;
  }

}
