import math


def isLucky(num):
    lucky = 1
    # here we store an array that has 10 elements
    array = [0]*10

    temp = num
    print(temp)
    while temp > 0:
        print(temp)
        digit = math.floor(temp % 10)
        if (array[digit] == 0):
            array[digit] = 1
        else:
            return 0
        temp = (temp/10)

    return lucky


def main():
    print("hello")
    print(isLucky(231))


main()
