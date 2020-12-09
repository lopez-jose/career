import math


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
    search = 0
    while searching:
        index = (int(math.pow(2, search)))
        print(index)
        if(index < right):
            if(searchNum < array[index]):
                print(binarySearch(array, left, index, searchNum))
                searching = False
        else:
            print(binarySearch(array, left, right, searchNum))
            searching = False
        search = search+1


def main():
    array = []
    maxValue = 10000000
    for i in range(0, maxValue):
        array.append(i)

    # position = binarySearch(array, 0, len(array), maxValue-2)
    exponentialSearch(array, 0, maxValue, (maxValue-1))
    # print("Number %s is found at position %s" % (maxValue-1, position))


main()
