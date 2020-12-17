import math


def calculate_n_log_n(number):
    computation_count = 1
    computations = computation_count*math.log(computation_count, 2)
    while(computations < number):
        computation_count += 1
        computations = computation_count*math.log(computation_count, 2)

    print(computation_count)

    return computation_count


def main():
    x = math.log(8, 2)
    print(x)
    calculate_n_log_n(1000000)
    return 0


main()
