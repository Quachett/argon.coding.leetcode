package uk.co.argon.leetcode;

import java.util.Arrays;
import java.util.List;

import uk.co.argon.leetcode.LinkedList.Node;

public class LinkedList2 extends LinkedList {
	
	private static int i = 0;

	public static void main(String[] args) {
		Node<Integer> head = getNode(getArray(),0);
		print(head);
		System.out.println();
		sort(head);
		print(head);
		
	}
	
	private static Node<Integer> sort(Node<Integer> head) {
		split(head, getEnd(head));
		return head;
	}
	
	private static void split(Node<Integer> start, Node<Integer> end) {
		if(start==end)
			return;
		
		Node<Integer> mid = getMid(start, end);
		//System.out.println("start: " + start.data + "\tmid: " + mid.data);

		split(start, mid);
		split(mid.next, end);
		merge(start, end);
	}
	
	private static void merge(Node<Integer> start, Node<Integer> end) {
		Node<Integer> mid = getMid(start, end);
		System.out.println("Start: " + start.data + "\tmid: " + mid.data + "\tend: " + end.data);
		
		
	}
	
	private static Node<Integer> getMid(Node<Integer> start, Node<Integer> end) {
		
		if(start==end)
			return start;
		
		Node<Integer> fast = start;
		while(fast!=end && fast.next!=end) {
			if(fast.next.next == null) {
				return start;
			}
			start = start.next;
			fast = fast.next.next;
		}
		return start;
	}
	
	private static Node<Integer> getEnd(Node<Integer> head) {
		if(head==null)
			return head;
		if(head.next==null)
			return head;
		return getEnd(head.next);
	}
	
	private static Node<Integer> sortAsc(Node<Integer> head) {
		if(head!=null) {
			Node<Integer> a = head, b = head, temp = null;
			int l = head.data;
			while(b!=null) {
				if(b.next!=null && b.next.data<l) {
					if(b.next.data<head.data) {
						temp = b.next;
						b.next = b.next.next;
						temp.next = head;
						head = temp;
					}
					else {
						while(a!=null) {
							if(b.next.data<a.next.data) {
								temp = b.next;
								b.next = b.next.next;
								temp.next = a.next;
								a.next=temp;
								break;
							}
							a=a.next;
						}
					}
					a=head;
					
				}
				else {
					l = (b.next!=null)?b.next.data:l;
					b=b.next;
				}
			}
		}
		return head;
	}
	
}
