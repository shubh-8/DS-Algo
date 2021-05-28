private void reversePRHelper(Node node) {
  if (node == tail) {
    return;
  }
  reversePRHelper(node.next);
  node.next.next = node;
}

public void reversePR() {
  reversePRHelper(head);
  Node temp = head;
  head = tail;
  tail = temp;
  tail.next = null;
}
