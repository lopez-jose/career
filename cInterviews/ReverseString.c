#include <string.h>
#include <stdio.h>

void reverseString(char *str)
{
    int l, i;
    char *begin_ptr, *end_ptr, ch;

    l = strlen(str);

    begin_ptr = str;
    end_ptr = str;
    //Move the end_ptr to the last character
    for (int i = 0; i < l - 1; i++)
    {
        end_ptr++;
    }

    for (int i = 0; i < l / 2; i++)
    {
        ch = *end_ptr;
        printf("%c", ch);
        *end_ptr = *begin_ptr;
        *begin_ptr = ch;

        begin_ptr++;
        end_ptr--;
    }
}

int main()
{

    printf("Hello world");
    char str[100] = "hello";
    reverseString(str);

    printf("Reverse = %s\n", str);

    return 0;
}
