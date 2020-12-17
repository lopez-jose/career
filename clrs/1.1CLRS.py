import math
time_secs = [1, 60, 3600, 3600*24, 3600 *
             24*30, 3600*24*30*365, 3600*24*30*365*100]


def calculate_log_n(number):
    return 0


def calculate_n_log_n(number):
    computation_count = 1
    computations = computation_count*math.log(computation_count, 2)
    while(computations < number):
        computation_count += 1
        computations = computation_count*math.log(computation_count, 2)

    # print(computation_count)

    return computation_count*time_secs[0], computation_count*time_secs[1], computation_count*time_secs[2], computation_count*time_secs[3], computation_count*time_secs[4], computation_count*time_secs[5], computation_count*time_secs[6]


def main():
    x = math.log(8, 2)

    for i in range(len(time_secs)):
        print(time_secs[i], end=" ")
    print("\n")
    print(calculate_n_log_n(1000000))
    print(x)
    calculate_n_log_n(1000000)
    return 0


main()
