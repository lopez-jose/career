

def interpolationSearch(array, size, searchNum):
    low = 0
    high = size-1

    while((array[high] != array[low]) and (searchNum >= array[low])) and (searchNum <= array[high]):
        mid = low+((searchNum-array[low]))*(high-low)//(array[high]-array[low])
        if(array[mid] < searchNum):
            low = mid+1
        elif(searchNum < array[mid]):
            high = mid-1
        else:
            return mid

    if(searchNum == array[low]):
        return low
    else:
        return -1


def main():
    array = []
    maxValue = 1000
    for i in range(1, maxValue):
        array.append(i)
    print("hello")
    print(interpolationSearch(array, len(array), maxValue-1))
    print("hello")


main()
