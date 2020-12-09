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


def recursiveBinarySearch(array, left, right, searchNum):
    while(left <= right):
        middle = (left+(right-1))//2
        if(array[middle] == searchNum):
            return middle
        if(array[left] < searchNum):
            return recursiveBinarySearch(array, middle+1, right, searchNum)
        else:
            return recursiveBinarySearch(array, left, middle-1, searchNum)
    return -1


def ternarySearch(array, left, right, searchNum):
    mid1 = left+(right-left)//3
    mid2 = right-(right-left)//3
    if(right >= 1):
        if(searchNum == array[mid1]):
            return mid1
        if(searchNum == array[mid2]):
            return mid2
        if(searchNum < array[mid1]):
            return ternarySearch(array, left, mid1-1, searchNum)
        if(searchNum > array[mid2]):
            return ternarySearch(array, mid2+1, right, searchNum)
        else:
            return ternarySearch(array, mid1+1, mid2-1, searchNum)
    return -1


def main():
    array = []
    maxValue = 100000000
    for i in range(1, maxValue):
        array.append(i)
    print("hello")
    position = binarySearch(array, 0, len(array), maxValue-1)

    print("Binary Search: %s" % (position))

    position = ternarySearch(array, 0, len(array), maxValue-1)
    print("Ternary Search: %s" % (position))


main()
