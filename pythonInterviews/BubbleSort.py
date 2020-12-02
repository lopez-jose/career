

def bubbleSort(arr):
    n = len(arr)

    for i in range(n):
        for j in range(n-i-1):
            if arr[j] > arr[j+1]:
                temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp


def main():
    array = [32, 32, 2, 1, 5, 38, 9]

    bubbleSort(array)

    for i in range(len(array)):
        print("%d" % array[i]),


main()
