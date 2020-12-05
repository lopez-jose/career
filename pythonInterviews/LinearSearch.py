
# returns linear search position
def linearSearch(arr, num):
    for i in range(len(arr)):
        if arr[i] == num:
            return i
            break


def main():
    array = [1, 5, 3, 25, 2, 5, 32, 5]

    print(linearSearch(array, 5))


main()
