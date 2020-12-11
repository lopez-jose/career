

def flip(array, i):
    for i in reversed(range(len(array))):
        print(array[i], end=" ")
    print("\n")


def main():
    array = [1, 5, 3, 29, 3, 1, 5, 2, 5, 388, 92, 39, 5]

    flip(array, len(array))


main()
