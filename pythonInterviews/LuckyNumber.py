import math


def isLucky(num):
    lucky = True
    # here we store an array that has 10 elements
    array = [0]*10

    temp = num
    while temp > 0:
        temp = math.floor(temp % 10)
        if array[temp] == False:
            array[temp] = True
        else:
            lucky = False
        temp = temp/10

    return lucky


def main():
    print("hello")
    print(isLucky(232))


main()
