import math


def isLucky(num):
    lucky = 1
    # here we store an array that has 10 elements
    array = [0]*10

    temp = num
    while temp > 0:
        temp = math.floor(temp % 10)
        if array[temp] == 0:
            array[temp] = 1
        else:
            return 0
        temp = temp/10

    return lucky


def main():
    print("hello")
    print(isLucky(231))


main()
