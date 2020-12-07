import time


def linearSearch(array, numSearch):
    millisStart = int(round(time.time()*1000))
    for i in range(len(array)):
        if(array[i] == numSearch):
            millisEnd = int(round(time.time()*1000))
            return i, millisEnd-millisStart
    millisEnd = int(round(time.time()*1000))
    return -1, millisEnd


def binarySearch(array, numSearch):
    millisStart = int(round(time.time()*1000))
    isFound = False

    start = 0
    end = len(array)-1
    middle = (end+start)//2

    while isFound == False:
        print("running")
        if(array[middle] == numSearch):
            millisEnd = int(round(time.time()*1000))
            return middle, millisEnd-millisStart
        if middle == end or middle == start:
            millisEnd = int(round(time.time()*1000))
            if(array[end] == numSearch):
                return end, millisEnd-millisStart
            if(array[start] == numSearch):
                return start, millisEnd-millisStart
            return -1, millisEnd-millisStart
        if(array[middle] > numSearch):
            end = middle
            middle = (end+start)//2
        else:
            start = middle
            middle = (end+start)//2


def main():

    array = []
    listSize = 1000000000
    for i in range(1, listSize):
        array.append(i)

    millis = int(round(time.time()*1000))
    maxValue = listSize-1

    position, timeLinear = linearSearch(array, maxValue)

    print("Linear Search: %s found at Position: %s in %s ms" %
          (maxValue, position, timeLinear))

    position, timeBinary = binarySearch(array, maxValue)
    print("Binary Search: %s found at Position: %s in %s ms" %
          (maxValue, position, timeBinary))


main()
