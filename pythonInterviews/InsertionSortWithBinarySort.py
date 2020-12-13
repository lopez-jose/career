

def binary_search(array, start, end, searchNum):

    if start == end:
        if array[start] > searchNum:
            return start
        else:
            return start+1

    if start > end:
        return start
    middle = (start+end)//2

    if array[middle] > searchNum:
        return binary_search(array, start, middle-1, searchNum)
    elif array[middle] < searchNum:
        return binary_search(array, middle+1, end, searchNum)
    else:
        return middle


def insertion_sort(array):
    for i in range(1, len(array)):
        searchNum = array[i]
        # the value where you put the number
        # the boundes of binary search are inputted

        j = binary_search(array, 0, i-1, searchNum)
        print(j)
        array = array[:j]+[searchNum]+array[j:i]+array[i+1:]
        print_array(array)
    return array


def print_array(array):
    for i in range(len(array)):
        print(array[i], end=' ')
    print("\n")


def main():
    array = [4, 2, 3, 2]
    insertion_sort(array)

    print(array)


main()
