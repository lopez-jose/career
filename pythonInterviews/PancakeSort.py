def pancakeFlip(array):

    n = len(array)
    while(n >= 1):
        largest = getLargest(array, n)

        if(largest != n-1):
            array = flip(array, largest)
            array = flip(array, n-1)
        n = n - 1
    return array


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


def printArray(array):
    for i in range(len(array)):
        print(array[i], end=' ')
    print("\n")


def main():

    array = [1, 2, 3, 4, 2, 2]
    print("Original array = ", end=" ")
    printArray(array)

    pancakeFlip(array)

   # array = [1, 2, 3, 4, 5, 6]
    # flip(array, len(array)-4)
    printArray(array)


main()
