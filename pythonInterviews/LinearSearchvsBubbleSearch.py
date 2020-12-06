import time


def linearSearch(array, numSearch):
    millisStart = int(round(time.time()*1000))
    for i in range(len(array)):
        if(array[i] == numSearch):
            millisEnd = int(round(time.time()*1000))
            return i, millisEnd-millisStart


def binarySearch(array, numSearch):
    millisStart = int(roun)

def main():

    array = []
    listSize = 10000000
    for i in range(1, listSize):
        array.append(i)

    millis = int(round(time.time()*1000))
    maxValue = listSize-1

    position, timeLinear = linearSearch(array, maxValue)

    print("Linear Search: %s found at Position: %s in %s ms" %
          (maxValue, position, timeLinear))


main()
