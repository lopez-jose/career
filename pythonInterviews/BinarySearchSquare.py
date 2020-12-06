import math


def binarySearch(num, limit, increment):
    array = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    start = 0
    end = len((array))-1
    print(end)
    middle = (start+end)//2
    print(middle)
    startEqualsEnd = False

    while startEqualsEnd == False:
        evaluated = (num+(array[middle])*increment)**2
        if middle == start or middle == end:
            startEqualsEnd = True
            return increment*array[middle]
        if evaluated > limit:
            end = middle
            middle = (start+end)//2
        else:
            start = middle
            middle = (start+end)//2


def binarySquareRoot(toFind, precision):
    lessThan = True
    i = 1
    while(i**2 < toFind):
        i = i + 1
    number = i-1

    increment = 1.0
    for j in range(precision):
        increment /= 10
        print(increment)
        toAdd = binarySearch(number, toFind, increment)
        print(toAdd)
        number += toAdd

    return number


def main():
    toFind = 123
    precision = 8
    print(binarySquareRoot(toFind, precision))


main()
