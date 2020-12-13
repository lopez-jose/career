def pancakeSort(array):

    n = len(array)
    while(n >= 1):
        largest = getLargest(array, n)

        if(largest != n-1):
            array = flip(array, largest)
            array = flip(array, n-1)
        n = n - 1


def getLargest(array, n):
    maxIndex = 0
    for i in range(0, n):
        if array[i] > array[maxIndex]:
            maxIndex = i

    return maxIndex


def flip(array, n):

    end = n
    start = 0
    for i in range((n+1)//2):
        temp = array[end]
        array[end] = array[start]
        array[start] = temp
        end = end - 1
        start = start + 1
    return array


# reverses the array
def flipOther(array, n):
    start = 0
    while start < n:
        temp = array[start]
        array[start] = array[n]
        array[n] = temp
        start += 1
        n -= 1


def printArray(array):
    for i in range(len(array)):
        print(array[i], end=' ')
    print("\n")


def main():

    array = [1, 2, 3, 4, 2, 2]
    printArray(array)

    pancakeSort(array)
    print("Sorted array = ")
    printArray(array)


main()
