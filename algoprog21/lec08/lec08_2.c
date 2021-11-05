//
// Created by oketa on 2021/11/05.
//

#include <stdio.h>

#define size 7

int array[size] = {4,2,6,1,3,7,5};

// mは最も大きいインデックス. m+1番目以降の要素はソート済みとする
int m = size-1;

// 1行で表示
void view() {
    int i;
    for (i=0; i<size; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");
}

// 二分木を簡易的なツリーで表示する
void viewTree() {
    int i, j;
//    system("clear");
    for ( i=1; i<=size; i*=2 ) {
        for ( j=0; j<i; j++ ) {
            printf("%d ", array[i+j-1]);
        }
        printf("\n");
    }
    getchar();
}

// 2変数の値の交換を行う
void swap( int *a, int *b ) {
    int tmp;
    tmp = *a;
    *a = *b;
    *b = tmp;
}

// jを根としてヒープ構造化する
void heapDown( int j ) {
    if ( 2*j+2 <= m && array[j] < array[2*j+2] && array[2*j+1] < array[2*j+2] ) {
        swap( &array[j], &array[2*j+2] );
        // view();
        heapDown(2*j+2);
    } else if ( 2*j+1 <= m && array[j] < array[2*j+1] ) {
        swap( &array[j], &array[2*j+1] );
        // view();
        heapDown(2*j+1);
    }
}

// ヒープ構造にする
void heap() {
    int i;
    for ( i=(m-1)/2; i>=0; i-- ) {
        heapDown(i);
    }
}

// ヒープソートを行う
void heapSort() {
    while ( m >= 1 ) {
        heap();
        swap(&array[0], &array[m]);
        viewTree();
        m--;
    }
}

int main() {
    // printf("source: ");
    // view();
    heapSort();
    // printf("sorted: ");
    // view();
}
