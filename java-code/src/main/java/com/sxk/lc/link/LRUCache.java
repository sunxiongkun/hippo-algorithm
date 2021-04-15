package com.sxk.lc.link;

import java.util.HashMap;
import java.util.Map;

/***
 * @author sxk
 * @date 2021/4/6 7:21 下午
 * https://leetcode-cn.com/problems/lru-cache/
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * Least Recently Used
 */
public class LRUCache {

  static class DLinkNode {

    int key;
    int value;
    DLinkNode pre;
    DLinkNode next;

    DLinkNode() {
    }

    DLinkNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  Map<Integer, DLinkNode> cache = new HashMap<>();
  int capacity;
  DLinkNode head;
  DLinkNode tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    head = new DLinkNode();
    tail = new DLinkNode();
    head.next = tail;
    tail.pre = head;
  }

  public int get(int key) {
    if (!containsKey(key)) {
      return -1;
    }
    final DLinkNode cur = cache.get(key);
    moveToHead(cur);
    return cur.value;
  }

  public void put(int key, int value) {
    if (capacity == cache.size()) {
      if (containsKey(key)) {
        final DLinkNode cur = cache.get(key);
        cur.value = value;
        moveToHead(cur);
      } else {
        final DLinkNode tailNode = removeTail();
        cache.remove(tailNode.key);
        final DLinkNode newNode = new DLinkNode(key, value);
        cache.put(key, newNode);
        addHead(newNode);
      }
    } else {
      if (containsKey(key)) {
        final DLinkNode cur = cache.get(key);
        cur.value = value;
        moveToHead(cur);
      } else {
        final DLinkNode newNode = new DLinkNode(key, value);
        addHead(newNode);
        cache.put(key, newNode);
      }

    }
  }

  private boolean containsKey(int key) {
    return cache.containsKey(key);
  }

  private void remove(DLinkNode curr) {
    curr.pre.next = curr.next;
    curr.next.pre = curr.pre;
  }

  private void addHead(DLinkNode curr) {
    curr.next = head.next;
    curr.pre = head;
    head.next.pre = curr;
    head.next = curr;
  }

  private DLinkNode removeTail() {
    final DLinkNode pre = tail.pre;
    final DLinkNode tailNode = cache.get(pre.key);
    remove(tailNode);
    return tailNode;
  }

  private void moveToHead(DLinkNode curr) {
    remove(curr);
    addHead(curr);
  }

  public static void main(String[] args) {
    final LRUCache lruCache = new LRUCache(2);
    lruCache.put(1, 1);
    lruCache.put(2, 2);
    System.out.println(lruCache.get(1));
    lruCache.put(3, 3);
    System.out.println(lruCache.get(2));
  }

}
