
public class DoubleLinkedList {
	
	static Node head;
	class Node{
		int data;
		Node next;
		Node prev;
		Node(int d){
			data = d;
			next = null;
			prev = null;
		}
	}
	
	//This function is to insert an element in start of doubly linkedlist
	public void push(int data) {
		Node new_node = new Node(data);
		new_node.prev = null;
		new_node.next = head;
		// change prev of head node to new node */
	    if (head != null) 
	        head.prev = new_node; 
		head = new_node;
	}
	
	//This function is to insert an element at the end of doubly linkedlist
	public void ammend(int data) {
		Node temp = head;
		Node new_node = new Node(data);
		if(temp == null) {
			new_node.prev = null;
			new_node.next = head;
			head = new_node;
			return;
		}
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = new_node;
		new_node.prev = temp;
		new_node.next = null;//useless
	}
	
	//This function is to insert an element after a particular node
	public void insertAfter(Node node,int data) {
		if(node == null)
			return ;
		Node new_node = new Node(data);
		new_node.prev = node;
		new_node.next = node.next;
		node.next = new_node;
		new_node.next.prev = new_node;
	}
	
	//This function is to print the list
	public void printList() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.push(20);
		dll.push(30);
		dll.ammend(15);
		dll.ammend(29);
		dll.insertAfter(head, 13);
		dll.printList();
	}

}
