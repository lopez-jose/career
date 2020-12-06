import time
# returns linear search position


def linearSearch(arr, num):

    for i in range(len(arr)):
        if arr[i] == num:
            millis = int(round(time.time()*1000))
            return i, millis
            break
    millis = int(round(time.time()*1000))
    return -1, millis


def main():
    array = [0]
    for i in range(0, 10000000):
        array.append(i)

    element = 9999999
    millis = int(round(time.time()*1000))
    position, millisSearch = linearSearch(array, element)

    timeRunning = millisSearch-millis
    print("Number: %s is found at position: %s in %s ms" %
          (element, position, timeRunning))


main()
