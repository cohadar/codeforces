def rest(n):
	# R = [0] * 10
	# for x in xrange(1, n + 1):
	# 	R[x % 10] += 1
	d = n / 10
	r = n % 10
	R = [d] * 10
	R[0] -= 1
	R[0] += 1
	for x in xrange(1, r + 1):
		R[x] += 1
	return R

na, nb = map(int, raw_input().split())
A = rest(na)
B = rest(nb)
count = 0
for ia, a in enumerate(A):
	for ib, b in enumerate(B):
		if (ia + ib) % 5 == 0:
			count += a * b;
print count
