
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day1 day = new Day1();
		day.push(5);
		day.push(4);
		day.push(20);
		day.ammend(13);
		day.insertAfter(head.next.next, 14);
		day.printList();

	}

}
