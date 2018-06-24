#include <stdio.h>

int main() {
    int m, n;
    scanf("%d %d", &m, &n);
    printf("%d\n", ((n * m) & ~1) / 2);
}
