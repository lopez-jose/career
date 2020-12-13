
def InsertionSort(array):

    for i in range(1, len(array)):
        key = array[i]
        j = i-1
        while j >= 0 and key < array[j]:
            array[j+1] = array[j]
            j -= 1
        array[j+1] = key


def printInsertionSortStep(array):
    for i in range(len(array)):
        print(array[i], end=" ")
    print("\n")


def main():
    print("This program runs insertionSort on an array")

    array = [12, 11, 13, 5, 6]
    arrayBinary = [1, 2, 3, 4, 7, 9]
    InsertionSort(array)


main()
