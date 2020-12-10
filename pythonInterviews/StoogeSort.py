def stoogeSort(array, l, h):
    if l >= h:
        return
    if array[l] > array[h]:
        temp = array[l]
        array[l] = array[h]
        array[h] = temp
    if h-1+1 > 2:
        t = (h-1+1)//3

        # recursively sorts first 2/3 of elements
        stoogeSort(array, l, (h-t))

        # recursively sorts last 2/3 of elements
        stoogeSort(array, l+t, h)
        # recursively sorts first 2/3 of elements to confirm
        stoogeSort(array, l, (h-t))


def main():
    array = [2, 4, 5, 3, 1]

    stoogeSort(array, 0, len(array)-1)

    for i in range(0, len(array)):
        print(array[i], end=' ')


main()
