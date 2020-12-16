
def merge_sort(array):
    if(len(array) > 1):
        middle = len(array)//2

        # these are subarrays of the original array
        left = array[:middle]
        right = array[middle:]

        merge_sort(left)
        merge_sort(right)

        i = j = k = 0

        while i < len(left) and j < len(right):
            if(array[left] < array[right]):
                array[k] = array[left]
            else:
                array[k] = array[right]
            k += 1
        while i < len(left):
            array[k] = left[i]
            i += 1
            k += 1
        while i < len(right):
            array[k] = right[i]
            i += 1
            k += 1


def printArray(array):
    for i in range(len(array)):
        print(array[i], end=" ")
    print("\n")


def main():
    array = [38, 27, 43, 3, 9, 82, 10]
    merge_sort(array)
    print


main()
