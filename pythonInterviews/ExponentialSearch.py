def binarySearch(array, left, right, searchNum):

    while(left <= right):
        middle = (left+(right-1))//2

        if(array[middle] == searchNum):
            return middle
        if(array[middle] < searchNum):
            left = middle+1
        else:
            right = middle-1
    return -1


def exponentialSearch(array, left, right, searchNum):
    searching = True
    while(searching):
    if

def main():
    array = []
    maxValue = 10000000
    for i in range(0, maxValue):
        array.append(i)

    position = binarySearch(array, 0, len(array), maxValue-2)

    print("Number %s is found at position %s" % (maxValue-1, position))


main()
