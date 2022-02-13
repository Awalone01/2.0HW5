package pro.sky2.HW5.node;

import pro.sky2.HW5.data.Employee;

public class Node {
    Node next;
    Employee item;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Employee getItem() {
        return item;
    }

    public void setItem(Employee item) {
        this.item = item;
    }
}
