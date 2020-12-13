

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
        array = array[:j]+[searchNum]+array[j:i]+array[i+1:]
    return array


def main():
    return 0


main()
