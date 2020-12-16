import math


def time_comparison(n):
    return (100*n*n) > (2**n)


def main():
    for i in range(1, 100):
        print("%s\t100n^2 is slower than 2^n: %s" % (i, time_comparison(i)))


main()
