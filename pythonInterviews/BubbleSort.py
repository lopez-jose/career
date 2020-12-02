

def bubbleSort(arr):
    n = len(arr)
    swapped = False
    for i in range(n):
        swapped = False
        for j in range(n-i-1):
            if arr[j] > arr[j+1]:
                temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp
                swapped = True

        if swapped == False:
            break


def main():
    array = [32, 32, 2, 1, 5, 38, 9]

    bubbleSort(array)

    for i in range(len(array)):
        print("%d" % array[i]),


main()
