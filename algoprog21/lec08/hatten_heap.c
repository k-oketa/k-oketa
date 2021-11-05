#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define BUFFER_SIZE 128
#define ARRAY_SIZE 32000

// データ数（任意で設定，0~32000）
#define MAX_LENGTH 16000

int *array = NULL;
int size = MAX_LENGTH;

// mは最も大きいインデックス. m+1番目以降の要素はソート済みとする
int m = MAX_LENGTH-1;

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
    for ( i=1; i<=size; i*=2 ) {
        for ( j=0; j<i; j++ ) {
            printf("%d ", array[i+j-1]);
        }
        printf("\n");
    }
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
        m--;
    }
}

// GW発展：ファイル読み込み
void load(){
    char buffer[BUFFER_SIZE];
    int n = 0;
    int i = 0;
    FILE *fp = fopen("C:/Users/okete/_/algoprog21/lec08/text.txt", "r");
    if(!fp){
        puts("file cannot open!");
        exit(-1);
    }
    while(fgets(buffer, BUFFER_SIZE, fp)){
        sscanf(buffer, "%d", &n);
        array[i] = n;
        i++;
    }
    fclose(fp);
}

int main() {

    // 【 1 】現在時刻を保存する変数start, endを宣言する
    // clock_t start, end;
    clock_t start, end;

    // 【 2 】int型のメモリ領域をARRAY_SIZE分だけ確保する
    // array = (int*)malloc(sizeof(int) * ARRAY_SIZE);
    array = (int*) malloc(sizeof(int) * ARRAY_SIZE);

    // 【 3 】テキストファイルを読み込む関数を呼び出す
    // load();
    load();
    
    // 【 4 】現在時刻を取得する
    // start = clock();
    start = clock();

    heapSort();

    // 【 4 】現在時刻を取得する
    // end = clock();
    end = clock();
    
    printf("data: %d.\n", MAX_LENGTH);

    // 【 5 】ソートにかかった時間を計算し表示する
    // printf("time elapsed: %ld ms.\n", end - start);
    printf("time elapsed: %ld ms.\n", end - start);
}
