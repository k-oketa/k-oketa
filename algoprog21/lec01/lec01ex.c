//
// Created by oketa on 2021/09/17.
//
#include <stdlib.h>
#include <stdio.h>

struct Link {
    char *data;
    struct Link *next;
};

struct Link *head;

struct Link *newLink(char data[10]) {
    struct Link *nLink = (struct Link *) malloc(sizeof(struct Link));
    nLink -> data = data;
    nLink -> next = NULL;
    return nLink;
}

void view() {
    struct Link *itr = head;
    while (itr != NULL) {
        printf("(%p)%s => (%p)\n", itr, itr->data, itr->next);
        itr = itr -> next;
    }
}

int main() {

    struct Link *tmp;

    head = newLink("Apple");
    head -> next = newLink("Banana");
    head -> next -> next = newLink("Orange");
    tmp = head -> next -> next;
    head -> next -> next = newLink("Berry");
    head -> next -> next -> next = tmp;

    view();

    return 0;
}