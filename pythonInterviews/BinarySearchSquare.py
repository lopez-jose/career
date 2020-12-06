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
        evaluated = num+(array[middle])*increment
        print(evaluated)

        if start == end:
            startEqualsEnd = True
            return array[middle]
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
        # print(i)
    digit = i-1
    increment = 0.1
    binarySearch(digit, toFind, increment)
    return digit


def main():
    toFind = 123
    precision = 5
    print(binarySquareRoot(toFind, precision))


main()
