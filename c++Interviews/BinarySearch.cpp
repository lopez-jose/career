#include <iostream>
#include <vector>
using namespace std;

int binarySearch(vector<int> &array, int l, int r, int numSearch)
{
    printf("%d", l);
    if (r >= 1)
    {
        int middle = l + (r - 1) / 2;
        if (array[middle] == numSearch)
        {
            return middle;
        }
        if (array[middle] > numSearch)
        {
            return binarySearch(array, l, middle - 1, numSearch);
        }

        return binarySearch(array, r, middle + 1, numSearch);
    }
    //Element is not in sorted array
    return -1;
}

int main()
{
    std::vector<int> v;
    int maxLength = 10000000;
    for (int i = 0; i < maxLength; i++)
    {
        v.push_back(i);
    }
    printf("%d", binarySearch(v, 0, maxLength, maxLength - 1));
}
