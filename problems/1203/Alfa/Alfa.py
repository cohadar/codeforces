import sys

def left(l, r, n):
    return (l + 1) % n == r

def right(l, r, n):
    return (r + 1) % n == l

def main():
    lines = (line for line in sys.stdin)
    for q in range(int(next(lines))):
        n = int(next(lines))
        a = [int(x) - 1 for x in next(lines).split()]
        z1 = zip(a[:-1], a[1:])
        z2 = zip(a[:-1], a[1:])
        if all(left(*x, n) for x in z1) or all(right(*x, n) for x in z2):
            print('YES')
        else:
            print('NO')

if __name__ == '__main__':
    main()
