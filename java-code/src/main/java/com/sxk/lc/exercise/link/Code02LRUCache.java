package com.sxk.lc.exercise.link;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sxk
 */
public class Code02LRUCache {


  private int capacity;
  private int size;
  private Node head;
  private Node tail;
  private Map<Integer, Node> map;

  private class Node {

    private int key;
    private int value;
    private Node next;
    private Node pre;

  }

  /**
   * LRU 缓存机制
   * 146 -> https://leetcode-cn.com/problems/lru-cache/
   *
   * @param capacity
   */
  public Code02LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>();
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.pre = head;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      moveToHead(node);
      return node.value;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (size == capacity) {
      if (map.containsKey(key)) {
        Node cur = map.get(key);
        cur.value = value;
        moveToHead(cur);
      } else {
        Node tail = removeTail();
        map.remove(tail.key);
        Node cur = new Node();
        cur.key = key;
        cur.value = value;
        addHead(cur);
        map.put(key, cur);
      }
    } else {
      if (map.containsKey(key)) {
        Node cur = map.get(key);
        cur.value = value;
        moveToHead(cur);
      } else {
        Node cur = new Node();
        cur.key = key;
        cur.value = value;
        addHead(cur);
        map.put(key, cur);
      }
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
