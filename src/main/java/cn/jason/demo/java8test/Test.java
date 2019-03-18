package cn.jason.demo.java8test;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.offer("1");
        ll.offer("2");
        ll.offer("3");
        ll.offer("4");
        System.out.println(ll);
//        System.out.println(ll.get(2));
//        System.out.println(ll.peek());
//        System.out.println(ll.remove());
//        System.out.println(ll.poll());
        System.out.println(ll.poll());
        System.out.println(ll.pollLast());
        System.out.println(ll.pollLast());
        System.out.println(ll.pollLast());
    }
}
