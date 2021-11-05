#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define BUFFER_SIZE 128
#define ARRAY_SIZE 32000

// データ数（任意で設定，0~32000）
#define MAX_LENGTH 8000

int *array = NULL;

void bubbleSort(){
    for(int i = 0; i < MAX_LENGTH; i++){
        for(int j = 0; j < MAX_LENGTH - i - 1; j++){
            if(array[j] > array[j+1]){
                int tmp = array[j];
                array[j] = array[j+1];
                array[j+1] = tmp;
            }
        }
    }
}

void load(){
    char buffer[BUFFER_SIZE];
    int n = 0;
    int i = 0;
    FILE *fp = fopen("text.txt", "r");
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
    clock_t start, end;
    array = (int*)malloc(sizeof(int) * ARRAY_SIZE);

    load();
    
    start = clock();
    bubbleSort();
    end = clock();
    
    printf("data: %d.\n", MAX_LENGTH);
    printf("time elapsed: %ld ms.\n", end - start);
}