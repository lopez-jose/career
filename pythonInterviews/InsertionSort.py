def InsertionSort(arr):
    print("hello")
    A = []

    for i in range(len(arr)):
        min_idx = i
        for j in range(i+1, len(arr)):
            if arr[min_idx] > arr[j]:
                min_idx = j
        arr[i], arr[min_idx] = arr[min_idx], arr[i]
        printSortStep(arr)


def printSortStep(arr):
    for i in range(len(arr)):
        print(arr[i], end=" ")
    print("\n")


def main():
    array = [32, 32, 2, 1, 5, 38, 9]

    InsertionSort(array)


main()
