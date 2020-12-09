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


def recursiveTernarySearch(array, left, right, searchNum):
    mid1 = left+(right-left)//3
    mid2 = right-(right-left)//3
    if(right >= 1):
        if(searchNum == array[mid1]):
            return mid1
        if(searchNum == array[mid2]):
            return mid2
        if(searchNum < array[mid1]):
            return recursiveTernarySearch(array, left, mid1-1, searchNum)
        if(searchNum > array[mid2]):
            return recursiveTernarySearch(array, mid2+1, right, searchNum)
        else:
            return recursiveTernarySearch(array, mid1+1, mid2-1, searchNum)
    return -1


def iterativeTernarySearch(array, left, right, searchNum):
    while(right >= 1):
        middle1 = left+(right-left)//3
        middle2 = right - (right-left)//3
        if(searchNum == array[middle1]):
            return middle1
        if(searchNum == array[middle2]):
            return middle2
        if(searchNum < array[middle1]):
            right = middle1-1
        if(searchNum > array[middle2]):
            left = middle2+1
        else:
            left = middle1+1
            right = middle2-1

    return -1


def main():
    array = []
    maxValue = 100000000
    for i in range(1, maxValue):
        array.append(i)
    print("hello")
    position = binarySearch(array, 0, len(array), maxValue-1)

    print("Iterative Binary Search: %s" % (position))

    position = recursiveBinarySearch(array, 0, len(array), maxValue-1)
    print("Recursive Binary Search: %s" % (position))

    position = iterativeTernarySearch(array, 0, len(array), maxValue - 1)
    print("Iterative Ternary Search: %s" % (position))

    position = recursiveTernarySearch(array, 0, len(array), maxValue-1)
    print("Recursive Ternary Search: %s" % (position))


main()
