for _ in range(int(input())):
    x, y = input()[::-1], input()[::-1]
    iy = y.index('1')
    ix = x.index('1', iy)
    print(ix - iy)
