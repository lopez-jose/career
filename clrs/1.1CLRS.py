import math


def calculate_log_n(number):
    return 0


def calculate_n_log_n(number):
    computation_count = 1
    computations = computation_count*math.log(computation_count, 2)
    while(computations < number):
        computation_count += 1
        computations = computation_count*math.log(computation_count, 2)

    # print(computation_count)

    return computation_count


def main():
    x = math.log(8, 2)
    time_seconds = [1, 60, 3600, 3600*24, 3600 *
                    24*30, 3600*24*30*365, 3600*24*30*365*100]

    for i in range(len(time_seconds)):
        print(time_seconds[i], end=" ")
    print(calculate_n_log_n(time_seconds[1]))
    print(x)
    calculate_n_log_n(1000000)
    return 0


main()
