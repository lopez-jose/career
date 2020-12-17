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
        # print(computations)
        computations = computations*computation_count

    # print("\n")
    return computation_count-1


def main():
    time_figures = ["1 second", "1 minute", "1 hour",
                    "1 day", "1 month", "1 year", "1 century"]
    big_o = ["lg n", "sqrt(n)", "n", "n lg n", "n^2", "n^3", "2^n", "n!"]

    for i in range(len(time_secs)):
        print(time_secs[i], end=" ")
    print("\n")
    print(calculate_n_log_n(1000000))

    print("Factorial limit = %s" % (calculate_n_factorial(1000000)))

    print("Two to the N limit = %s" % (calculate_two_n(1000000)))

    print("N squared = %s" % (calculate_n_squared(1000000)))

    print("N Cubed= %s" % (calculate_n_cubed(1000000)))
    for i in range(len(time_figures)):
        print(f'{time_figures[i]:<20s}', end="")
    print()
    for j in range(len(big_o)):
        print(big_o[j], end="\t")
        for i in range(len(time_secs)):
            print(
                f'{str(time_secs[i]*calculate_n_factorial(1000000)):<19s}', end=" ")
        print()


main()
