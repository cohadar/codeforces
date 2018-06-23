#include <stdio.h>
#include <inttypes.h>

int main() {
    int n, m, a;
    int64_t n2, m2;
    scanf("%d %d %d", &n, &m, &a);
    n2 = n / a + (n % a != 0);
    m2 = m / a + (m % a != 0);
    printf("%" PRId64, n2 * m2);
}
