def solve(l, r):
	bc = bin(l).count('1')
	best = l
	x = l
	for i in xrange(64):
		x |= (1 << i)
		if l <= x <= r:
			nbc = bin(x).count('1')
			if bc < nbc:
				bc = nbc
				best = x
		else:
			break
	return best

n = input()
for _ in xrange(n):
	l, r = map(int, raw_input().split())
	print solve(l, r)