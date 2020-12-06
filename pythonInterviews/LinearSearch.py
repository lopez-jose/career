
# returns linear search position
def linearSearch(arr, num):
    for i in range(len(arr)):
        if arr[i] == num:
            return i
            break
    return -1


def main():
    array = [1, 5, 3, 25, 2, 5, 32, 5]
    element = 9
    print("Number: %s is found at position: %s" %
          (element, linearSearch(array, element)))


main()
