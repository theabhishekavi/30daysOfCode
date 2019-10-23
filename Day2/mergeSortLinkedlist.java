import java.util.*;

public class Day1 {
	
	static Node head;
	class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	//This function inserts an integer at the beginning of the list
	public void push(int data) {
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}
	
	//This function inserts an integer after the given node
	public void insertAfter(Node prev_node,int data) {
		if(prev_node == null) {
			System.out.println("The given node cannot be null");
			return ;
		}
		Node new_node = new Node(data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
	}
	
	//This function inserts an integer at the end
	public void ammend(int data) {
		Node new_node = new Node(data);
		if(head == null) {
			head = new_node;
			return ;
		}
		Node temp = head;
		while(temp.next!=null)
			temp = temp.next;
		temp.next = new_node;
	}
	
	//This function will print the whole list
	public void printList() {
		Node temp = head;
		while(temp!= null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	//This function will delete the node on the basis of key
	public void deleteKey(int data) {
		Node temp = head,prev = null;
		//head node to be deleted
		if(temp!=null && temp.data == data) {
		head = temp.next;
		return;
		}
		while(temp!=null && temp.data!=data) {
			prev = temp;
			temp=temp.next;
		}
		if(temp == null) {
			System.out.println("The value "+data+"  is not dound in the list");
			return;
		}
		prev.next = temp.next;
		
	}
	
	//This function will delete the node on the basis of position
	public void deletePos(int pos) {
		Node temp = head;
		if(temp == null)
			return;
		if(pos ==1) {
			head = temp.next;
			return;
		}
		for(int i = 1; i<pos-1 && temp!=null;i++) {
			temp = temp.next;
		}
		if(temp == null || temp.next==null ||pos<1)
			return;
		temp.next = temp.next.next;
	}
	
	//This function is used to search an element iteratively
	public boolean searchIter(int data) {
		Node temp = head;
		while(temp!=null) {
			if(temp.data==data)
				return true;
			temp = temp.next;
		}
		return false;
	}
	
	//this function is to search an element recursively
	public boolean searchRec(Node head,int data) {
		if(head==null)
			return false;
		if(head.data == data)
			return true;
		return searchRec(head.next,data);
		
	}
	
	//This function is used to find the middle element(s) 
	public void findMiddle(Node head) {
		if(head == null)
			return;
		Node slow_ptr = head;
		Node fast_ptr = head;
		Node prev_even = head; //for even length there will be two middle
		while(fast_ptr!=null && fast_ptr.next!=null) {
			fast_ptr = fast_ptr.next.next;
			prev_even = slow_ptr;
			slow_ptr = slow_ptr.next;
		}
		if(fast_ptr == null) {
			System.out.println("Two middle elements are "+prev_even.data+" and "+slow_ptr.data);
		}
		else
			System.out.println("Middle element is "+slow_ptr.data);
	}
	
	//This function is used to check whether the list is palindrome or not
	public boolean isPalindrome(Node head) {
		Stack<Integer> stack = new Stack<Integer>();
		Node temp = head;
		while(temp!=null) {
			stack.push(temp.data);
			temp = temp.next;
		}
		while(head!=null) {
			if(head.data!=stack.pop())
				return false;
			head = head.next;
		}
		return true;
	}
	
	//This function is used to remove duplicates from list
	public void removeDuplicates(Node head) {
		HashSet<Integer> hmap = new HashSet<>();
		Node current = head;
		Node prev = null;
		while(current!=null){
			int currval = current.data;
			if(hmap.contains(currval))
				prev.next = current.next;
			else
			{
				hmap.add(currval);
				prev = current;
			}
			current = current.next;
		}
	}
	
	//This function is to reverse a linkedlist iteratively
	public Node reverseIter(Node head) {
		Node current = head;
		Node prev = null;
		Node next = null;
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	
	//This function is to reverse a linkedlist recursively
	public Node reverseRec(Node current,Node prev) {
		//pass null value in prev while calling the function
		if(current.next==null) {
			head = current;
			current.next = prev;
			return head;
		}
		Node next1 = current.next;
		current.next = prev;
		reverseRec(next1,current);
		return head;
	}
	
	//This function is to sort the linkedlist using mergesort
	public Node mergeSort(Node head) {
		if(head == null || head.next == null)
			return head;
		Node middle = getMiddle(head);
		Node nextOfMiddle = middle.next;
		middle.next = null;
		Node left = mergeSort(head);
		Node right = mergeSort(nextOfMiddle);
		Node sortedList = sortMerge(left,right);
		return sortedList;
	}
	
	//This function is to find only one middle of functionfindMiddle
	public Node getMiddle(Node head) {
		if(head == null)
			return head;
		Node slow_ptr = head;
		Node fast_ptr = head;
		while(fast_ptr.next!=null && fast_ptr.next.next!=null) {
			fast_ptr = fast_ptr.next.next;
			slow_ptr = slow_ptr.next;
		}
		return slow_ptr;
	}
	
	//This function is to merge the sortedlist
	public Node sortMerge(Node a,Node b) {
		Node result = null;
		if(a==null)
			return b;
		if(b==null)
			return a;
		if(a.data<=b.data) {
			result = a;
			result.next = sortMerge(a.next,b);
		}
		else {
			result = b;
			result.next = sortMerge(a,b.next);
		}
		return result;
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Day1 day = new Day1();
		day.push(5);
		day.push(4);
		day.push(20);
		day.ammend(4);
		day.insertAfter(head.next.next, 5);
		day.ammend(16);
		day.push(16);
		day.printList();
		day.deleteKey(20);
		day.printList();
		day.deletePos(6);
		day.printList();
		if(day.searchIter(13))
			System.out.println("data is found iteratively");
		else
			System.out.println("data is not found iteratively");
		if(day.searchRec(head,15))
			System.out.println("data is found recursively");
		else
			System.out.println("data is not found recursively");
		day.findMiddle(head);
		if(day.isPalindrome(head))
			System.out.println("list is palindrome");
		else
			System.out.println("list is not palindrome");
//		day.removeDuplicates(head);
		day.printList();
		head = day.reverseRec(head,null);
		day.printList();
		head = day.reverseIter(head);
		day.printList();
		head = day.mergeSort(head);
		day.printList();
		
		

	}

}
