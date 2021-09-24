//
// Created by oketa on 2021/09/24.
//

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

struct Link {
    char *data;
    struct Link *next;
};

struct Link *head;

struct Link *newLink(char *data) {
    struct Link *nLink = (struct Link *) malloc(sizeof(struct Link));
    nLink->data = data;
    nLink->next = NULL;
    return nLink;
}

void view() {
    struct Link *itr = head;
    while (itr != NULL) {
        printf("(%p)%s => (%p)\n", itr, itr->data, itr->next);
        itr = itr->next;
    }
}

void insert(char *data) {
    struct Link *nLink = newLink(data);
    struct Link *itr;
    struct Link *next;

    // headが空であればそのまま格納する
    if (head == NULL) {
        head = nLink;
        return;
    }

    // 引数のdataがhead.dataよりも後のときは先頭に入れる
    if (strcmp(nLink->data, head->data) < 0) {
        nLink->next = head;
        head = nLink;
        return;
    }

    // headから順に探索する
    itr = head;
    while (1) {
        // 最後まで探索したとき（head以降に比較対象が無いとき）末尾に入れる
        if (itr->next == NULL) {
            itr->next = nLink;
            return;
        }
        // 引数のdataがitr.next.dataよりも後のときは
        else if (strcmp(nLink->data, itr->next->data) < 0) {
            nLink->next = itr->next;
            itr->next = nLink;
            return;
        }
        itr = itr->next;
    }
}

int main() {

    char *fruitList[] = {"apple", "orange", "banana"};
    int size = 3;

    int i;
    for (i = 0; i < size; i++) {
        insert(fruitList[i]);
    }

    view();

    return 0;
}