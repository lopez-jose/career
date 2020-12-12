def pancakeFlip(array):

    n = len(array)
    while(n >= 1):
        largest = array[0]
        for i in range(1, n):
            if(array[i] >= largest):
                largest = i
        print("Array = ", end=" ")
        printArray(array)
        print("Largest Position = %s n = %s" % (largest, n))

        if(largest != n-1):
            array = flip(array, largest)
            print("Result after flip(arr,mi) = ", end=" ")
            printArray(array)
            array = flip(array, n-1)
            print("Result after flip(arry,curr_size-1) = ", end=" ")
            printArray(array)
        n = n - 1
        entered = input("Enter")

    print("Final = ", end=' ')
    print(array)


def flip(array, n):

    end = n
    start = 0
    for i in range((n+1)//2):
        # print("Start = %s End = %s n = %s" % (start, end, (n+1)//2))
        temp = array[end]
        array[end] = array[start]
        array[start] = temp
        end = end - 1
        start = start + 1

        # entered = input("Press Enter for next step")
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
