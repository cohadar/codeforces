for q in range(int(input())):
    n = int(input())
    a = [int(x) - 1 for x in input().split()]
    b1 = all((l + 1) % n == r for (l, r) in zip(a[:-1], a[1:]))
    b2 = all((l + 1) % n == r for (r, l) in zip(a[:-1], a[1:]))
    print('YES') if b1 or b2 else print('NO')
