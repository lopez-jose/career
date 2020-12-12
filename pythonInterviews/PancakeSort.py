def pancakeFlip(array, i):
    return 0


def flip(array, i):
    arrayFlipped = []
    for i in reversed(range(len(array))):
        arrayFlipped.append(array[i])

    printArray(array)


def printArray(array):
    for i in range(len(array)):
        print(array[i], end=' ')


def main():
    array = [1, 5, 3, 29, 3, 1, 5, 2, 5, 388, 92, 39, 5]

    arrayFlipped = flip(array, len(array))


main()
