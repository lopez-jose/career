def InsertionSort(arr):
    for i in range(len(arr)):
        min_idx = i
        for j in range(i+1, len(arr)):
            if arr[min_idx] > arr[j]:
                min_idx = j
        arr[i], arr[min_idx] = arr[min_idx], arr[i]
        printSortStep(arr)


def InsertionSortTest(array):
    for n in range(len(array)):
        # we set the minium index to equal the first item
        min_index = n
        for j in range(n+1, len(array)):
            if(array[min_index] > array[j]):
                min_index = j
        array[n], array[min_index] = array[min_index], array[n]
        printSortStep(array)


def printSortStep(arr):
    for i in range(len(arr)):
        print(arr[i], end=" ")
    print("\n")


def main():
    array = [32, 32, 2, 1, 5, 38, 9]

    InsertionSortTest(array)


main()
