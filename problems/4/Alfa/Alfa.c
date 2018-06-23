#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);
    puts(((n >= 4) && (n % 2 == 0))?"YES":"NO");
}
