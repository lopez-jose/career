import time


def interpolationSearch(array, size, searchNum):
    millisStart = int(round(time.time()*1000))
    low = 0
    high = size-1

    while((array[high] != array[low]) and (searchNum >= array[low])) and (searchNum <= array[high]):
        mid = low+((searchNum-array[low]))*(high-low)//(array[high]-array[low])
        if(array[mid] < searchNum):
            low = mid+1
        elif(searchNum < array[mid]):
            high = mid-1
        else:
            millisEnd = int(round(time.time()*1000))

            return mid, millisEnd-millisStart

    if(searchNum == array[low]):
        millisEnd = int(round(time.time()*1000))
        return low, millisEnd-millisStart
    else:
        millisEnd = int(round(time.time()*1000))
        return -1, millisEnd-millisStart


def binarySearch(array, left, right, searchNum):

    millisStart = int(round(time.time()*1000))

    while(left <= right):
        middle = (left+(right-1))//2
        if(array[middle] == searchNum):
            millisEnd = int(round(time.time()*1000))
            return middle, millisEnd-millisStart
        if(array[middle] < searchNum):
            left = middle+1
        else:
            right = middle-1
    millisEnd = int(round(time.time()*1000))
    return -1, millisEnd-millisStart


def main():
    array = []
    maxValue = 100000000
    for i in range(1, maxValue):
        array.append(i)
    position, timeInterpol = interpolationSearch(array, len(array), maxValue-1)

    print("Number found at position: %s, in %s ms" % (position, timeInterpol))

    position, timeBinary = binarySearch(array, 0, len(array), maxValue-1)

    print("Number found at position: %s, in %s ms" % (position, timeBinary))


main()
