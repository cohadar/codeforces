def dz(y):
    c = 0
    for x in reversed(y):
        if x == '0':
            c += 1
        else:
            break;
    return c

def score(x, y):
    d = dz(y)
    if d == 0:
        return dz(x)
    return dz(x[:-d])

for _ in range(int(input())):
    print(score(input(), input()))
