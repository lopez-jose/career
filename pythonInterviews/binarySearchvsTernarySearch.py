def binarySearch(array, left, right, searchNum):

    if(right >= 1):
        middle = (left+(right-1))//2
        if(array[middle] == searchNum):
            return middle
        if(array[middle] > searchNum):
            return binarySearch(array, left, middle-1, searchNum)
        else:
            return binarySearch(array, middle+1, right, searchNum)
    return -1


def ternarySearch(array, left, right, searchNum):
    mid1 = left+(right-left)//3
    mid2 = right-(right-left)//3
    return 0


def main():
    array = []
    maxValue = 100000000
    for i in range(1, maxValue):
        array.append(i)
    print("hello")
    position = binarySearch(array, 0, len(array), maxValue-1)

    print("Binary Search: %s" % (position))


main()
