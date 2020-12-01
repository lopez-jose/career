#include <stdio.h>

void swap(int *xp, int *yp)
{
    int temp = *xp;
    //printf("%d ", temp);

    *xp = *yp;
    *yp = temp;
}
void printArray(int array[], int n)
{
    for (int i = 0; i < n; i++)
        printf("%d ", array[i]);
    printf("\n");
}
void bubbleSort(int array[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
            if (array[j] > array[j + 1])
            {
                swap(&array[j], &array[j + 1]);
                printArray(array, n);
            }
        printf("End of loop %d\n", i);
    }
}
int main()
{
    int array[] = {1, 5, 2, 5, 0, 3};
    //get length of array
    int n = sizeof(array) / sizeof(array[0]);
    bubbleSort(array, n);

    return 0;
}