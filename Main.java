import java.util.Scanner;

class Node{
    public int data;
    public Node next;
}

class LinkedListHandler{
    private Scanner sc = new Scanner(System.in);
    private Node list;
    private Node giveNode(int ele){
        Node newNode = new Node();
        newNode.data = ele;
        newNode.next=null;
        return newNode;
    }
    private void displayList(){
        Node temp = list;
        if(temp==null)
            System.out.println("Empty list.");
        else{
            System.out.println();
            System.out.println("The list has the elements:");
            while(temp!=null){
                System.out.print(temp.data+"   ");
                temp = temp.next;
            }
            System.out.println("\n\n\n");
        }
    }
    public void infLoop(){
        while(true){
            System.out.println("\nMenu\n1)Add an element at the front.\n2)Add an element at the rear.\n3)Display the present list.\n4)Delete an item from the front.\n5)Delete an item from the rear\n6)Exit");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter the data item to be added: ");
                    int ele = sc.nextInt();
                    if(list==null){
                        this.list = giveNode(ele);
                    }
                    else{
                        Node newN = giveNode(ele);
                        newN.next = list;
                        this.list = newN;
                    }
                    break;
                case 2:
                    System.out.println("Enter the data item to be added: ");
                    int ele1 = sc.nextInt();
                    if(list==null){
                        this.list = giveNode(ele1);
                    }
                    else{
                        Node temp = this.list;
                        while(temp.next!=null)
                            temp = temp.next;
                        temp.next = giveNode(ele1);
                    }
                    break;
                case 3:
                    displayList();
                    break;
                case 4:
                    if(list==null){
                        System.out.println("Empty list.");
                    }
                    else{
                        System.out.println(list.data+" is deleted from the list");
                        list = list.next;
                    }
                    break;
                case 5:
                    if(list==null){
                        System.out.println("Empty list.");
                    }
                    else{
                        Node curr=list,prev=null;
                        while(curr.next!=null){
                            prev=curr;
                            curr=curr.next;
                        }
                        System.out.println(curr.data+" is deleted from the list");
                        prev.next=null;
                    }
                    break;
                case 6:
                    System.out.println("The final list is: ");
                    displayList();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, refer to the menu!");
                    break;
            }
        }
    }
}

public class Main
{
	public static void main(String[] args) {
	    LinkedListHandler handler = new LinkedListHandler();
	    handler.infLoop();
	}
}
