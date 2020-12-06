import math
convertValue = {
    'A': 10,
    'B': 11,
    'C': 12,
    'D': 13,
    'E': 14,
    'F': 15
}


def convertToBase10(num, base):
    # The base will be started with
    sum = 0
    for i in range(len(num)):
        base10 = convertValue.get(num[i], num[i])
        print(base10)
        sum += base10 * base**i
    return sum


def convertToBase(num, base):
    returnNum = ""
    while num > 0:
        remainder = math.floor(num % base)
        returnNum = returnNum+str(remainder)
        num = math.floor(num/base)

    returnNum = returnNum[::-1]
    return returnNum


def rajMethod(num1, num2, base):
    num1Converted = convertToBase10(num1, base)
    num2Converted = convertToBase10(num2, base)

    # this sum is then converted back to the original base
    sum = num1Converted+num2Converted
    print(sum)

    sumConverted = convertToBase(sum, 14)
    return sumConverted


def main():

    print(rajMethod("AA", "AA", 14))


main()
