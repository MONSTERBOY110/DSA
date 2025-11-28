#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
};

struct node *front = NULL, *rear = NULL;

void enqueue(int x) {
    struct node *newnode = malloc(sizeof(struct node));
    newnode->data = x;
    newnode->next = NULL;

    if (front == NULL) {
        front = rear = newnode;
        rear->next = front;
    } else {
        rear->next = newnode;
        rear = newnode;
        rear->next = front;
    }

    printf("Inserted %d\n", x);
}

int dequeue() {
    if (front == NULL) {
        printf("Queue underflow\n");
        return -1;
    }

    int val;
    if (front == rear) {
        val = front->data;
        free(front);
        front = rear = NULL;
    } else {
        struct node *temp = front;
        val = temp->data;
        front = front->next;
        rear->next = front;
        free(temp);
    }

    return val;
}

void display() {
    if (front == NULL) {
        printf("Queue is empty\n");
        return;
    }

    struct node *temp = front;
    printf("Queue: ");

    while (temp->next != front) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("%d\n", temp->data);
}

void main() {
    enqueue(10);
    enqueue(21);
    enqueue(50);
    display();
    printf("Dequeued: %d\n", dequeue());
    display();
}
