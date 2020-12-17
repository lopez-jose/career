import math
time_secs = [1, 60, 3600, 3600*24, 3600 *
             24*30, 3600*24*30*365, 3600*24*30*365*100]


def calculate_two_n(number):
    computation_count = 0
    computations = 1
    while(computations < number):
        computation_count += 1
        print(computations)
        computations = 2**computation_count

    print("\n")
    return computation_count-1


def calculate_log_n(number):
    return 0


def calculate_n_log_n(number):
    computation_count = 1
    computations = computation_count*math.log(computation_count, 2)
    while(computations < number):
        computation_count += 1
        computations = computation_count*math.log(computation_count, 2)

    # print(computation_count)
    computation_count -= 1
    return computation_count*time_secs[0], computation_count*time_secs[1], computation_count*time_secs[2], computation_count*time_secs[3], computation_count*time_secs[4], computation_count*time_secs[5], computation_count*time_secs[6]


def calculate_n_squared(number):
    n = 1
    computations = 0
    while(computations < number):
        computations = n**2
        n += 1
    return n-1


def calculate_n_cubed(number):
    n = 1
    computations = 0
    while(computations < number):
        computations = n**3
        n += 1
    return n-1


def calculate_n_factorial(number):
    computation_count = 0
    computations = 1
    while(computations < number):
        computation_count += 1
        print(computations)
        computations = computations*computation_count

    print("\n")
    return computation_count-1


def main():
    for i in range(len(time_secs)):
        print(time_secs[i], end=" ")
    print("\n")
    print(calculate_n_log_n(1000000))

    print("Factorial limit = %s" % (calculate_n_factorial(1000000)))

    print("Two to the N limit = %s" % (calculate_two_n(1000000)))

    print("N squared = %s" % (calculate_n_squared(1000000)))

    print("N Cubed= %s" % (calculate_n_cubed(1000000)))


main()
