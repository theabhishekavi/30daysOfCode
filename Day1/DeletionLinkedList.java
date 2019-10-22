
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

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Day1 day = new Day1();
		day.push(5);
		day.push(4);
		day.push(20);
		day.ammend(13);
		day.insertAfter(head.next.next, 14);
		day.ammend(45);
		day.push(16);
		day.printList();
		day.deleteKey(20);
		day.printList();
		day.deletePos(6);
		day.printList();

	}

}
