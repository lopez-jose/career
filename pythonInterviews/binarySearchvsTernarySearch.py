def binarySearch(array, left, right, searchNum):

    if(right >= 1):
        middle = left+(right-1)//2
        if(array[middle] == searchNum):
            return middle
        if(array[middle] > searchNum):
            return binarySearch(array, left, middle-1, searchNum)
        else:
            return binarySearch(array, middle+1, right, searchNum)
    return -1


def main():
    array = []
    maxValue = 1000000000
    for i in range(1, maxValue):
        array.append(i)
    position = binarySearch(array, 0, len(array), maxValue-1)

    print("Binary Search: %s" % (position))


main()
