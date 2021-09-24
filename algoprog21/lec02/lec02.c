//
// Created by oketa on 2021/09/24.
//

#include <stdlib.h>
#include <stdio.h>

struct Link {
    int data;
    struct Link *next;
};

struct Link *head;

struct Link *newLink(int data) {
    struct Link *nLink = (struct Link *) malloc(sizeof(struct Link));
    nLink->data = data;
    nLink->next = NULL;
    return nLink;
}

void view() {
    struct Link *itr = head;
    while (itr != NULL) {
        printf("(%p)%d => (%p)\n", itr, itr->data, itr->next);
        itr = itr->next;
    }
}

void insert(int data) {
    struct Link *nLink = newLink(data);
    struct Link *itr;
    struct Link *next;

    if (head == NULL) {
        head = nLink;
        return;
    }

    if (nLink->data <= head->data) {
        nLink->next = head;
        head = nLink;
        return;
    }

    itr = head;
    while (1) {
        if (itr->next == NULL) {
            itr->next = nLink;
            return;
        } else if (nLink->data <= itr->next->data) {
            nLink->next = itr->next;
            itr->next = nLink;
            return;
        }
        itr = itr->next;
    }
}

int main() {

    insert(3);
    insert(1);
    insert(4);
    insert(2);

    view();

    return 0;
}