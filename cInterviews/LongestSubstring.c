#include <stdio.h>
#include <stdlib.h>
#include <string.h>

static int length_of_longest_substring(char *str1)
{
    int offset[128];
    int substr_max_len = 0;
    int len = 0;
    int index = 0;

    memset(offset, 0xff, sizeof(offset));

    while (*str1 != '\0')
    {

        if (offset[*str1] == -1)
        {

            len++;
            printf("len = %d, index = %d\n", len, index);
        }

        else
        {

            if (index - offset[*str1] > len)
            {
                len++;
                printf("if: len = %d, index = %d\n", len, index);
            }
            else
            {
                len = index - offset[*str1];
                printf("else: len = %d, index = %d\n", len, index);
                for (int i = 0; i < 128; i++)
                {
                    printf("%d ", offset[i]);
                }
            }
        }
        if (len > substr_max_len)
        {
            substr_max_len = len;
        }
        offset[*str1++] = index++;
        printf("\n\n");
        for (int i = 0; i < 128; i++)
        {
            printf("%d ", offset[i]);
        }
        printf("\n\n\n");
    }

    return substr_max_len;
}
static void printArray()
{
}
int main(void)
{
    char *str1 = "abcabcd";
    printf("\nOriginal String: %s", str1);
    printf("\nLength of the longest substring without repeating characters: %d\n", length_of_longest_substring(str1));
    return 0;
}