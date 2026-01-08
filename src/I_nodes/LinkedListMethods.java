
import I_nodes.ListNode;

void main() {
    // one way to build a linked list (= a list of linked nodes)
    ListNode<String> head1 = new ListNode<>("A", new ListNode<>("B", new ListNode<>("C")));
    // represents [A, B, C]

    // an empty linked list
    ListNode<String> head2 = null;
    // represents []

    // another way to build a linked list
    ListNode<Integer> head3 = new ListNode<>(1);
    head3.next = new ListNode<>(2);
    head3.next.next = new ListNode<>(3);
    head3.next.next.next = new ListNode<>(4);
    // represents [1, 2, 3, 4]

    printIteratively(head1); // A B C
    IO.println();
    printIteratively(head2); //
    IO.println();
    printIteratively(head3); // 1 2 3 4
    IO.println();

    printRecursively(head1); // A B C
    IO.println();
    printRecursively(head2); //
    IO.println();
    printRecursively(head3); // 1 2 3 4
    IO.println();

    IO.println(getSizeIteratively(head1)); // 3
    IO.println(getSizeRecursively(head1)); // 3

    printReversedIteratively(head1); // C B A
    IO.println();
    printReversedRecursively(head1); // C B A
    IO.println();
}

// Given the head of a (possibly empty) linked list, prints the list's elements.
// O(n) time, O(1) space
<E> void printIteratively(ListNode<E> head) {
    while (head != null) {
        IO.print(head.data + " ");
        head = head.next;
    }
}


// O(n) time, O(n) space
<E> void printRecursively(ListNode<E> head) {
    if (head != null) {
        IO.print(head.data + " ");
        printRecursively(head.next);
        // recursively print the rest of the list, which begins at head.next
    }
}

// Given the head of a (possibly empty) linked list, returns the number of nodes in the list.
// O(n) time, O(1) space
<E> int getSizeIteratively(ListNode<E> head) {
    int size = 0;

    while (head != null) {
        size++;
        head = head.next;
    }

    return size;
}

// O(n) time, O(n) space
<E> int getSizeRecursively(ListNode<E> head) {
    if (head == null) {
        return 0;
    } else {
        return 1 + getSizeRecursively(head.next);
    }
}

// Given the head of a (possibly empty) linked list, prints
// the list's elements in reverse order.
// O(n) time, O(n) space
<E> void printReversedIteratively(ListNode<E> head) {
    List<E> aux = new ArrayList<>();

    while (head != null) {
        aux.add(head.data);
        head = head.next;
    }

    for (int i = aux.size() - 1; i >= 0; i--) {
        IO.print(aux.get(i) + " "); // O(1)
    }
}

// O(n) time, O(n) space
<E> void printReversedRecursively(ListNode<E> head) {
    if (head != null) {
        printReversedRecursively(head.next);
        IO.print(head.data + " ");
    }
}
