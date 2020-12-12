def pancakeFlip(array):
    largest = array[0]
    for i in range(1, len(array)):
        if(array[i] > largest):
            largest = i

    print("Largest Position = %s" % (largest))

    arrayFlipped = flip(array, largest)
    arrayFlipped = flip(array, len(array)-1)
    # print(arrayFlipped)

    # returns a flipped array from 0 to i


def flip(array, n):
    arrayFlipped = []
    end = n
    start = 0
    for i in range((n+1)//2):
        print("Start = %s End = %s n = %s" % (start, end, (n+1)//2))
        temp = array[end]
        array[end] = array[start]
        array[start] = temp
        end = end - 1
        start = start + 1

        printArray(array)
        entered = input("Press Enter for next step")
    return arrayFlipped


def printArray(array):
    for i in range(len(array)):
        print(array[i], end=' ')
    print("\n")


def main():
    array = [1, 2, 3, 4, 2, 2]
    printArray(array)
    print("Now here")

    pancakeFlip(array)


main()
