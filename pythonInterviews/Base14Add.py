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

    return 0


def rajMethod(num1, num2):
    return 0


def main():

   # num1 = input("base 14 number = ")
    #num2 = input("base 14 number = ")
    convertToBase10("AAA", 14)
    print(convertValue.get('A', 0))


main()
