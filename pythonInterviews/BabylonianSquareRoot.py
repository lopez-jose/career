

def babylonian(num, loops):
    y = 1
    square = 3
    for i in range(5):
        square = (square+y)/2
        y = num/square
        print(square)
        print(i)

    return 0


def main():
    y = 1
    number = input("Enter a num to find the square root of= ")
    number = babylonian(float(number), 5)


main()
