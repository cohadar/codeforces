n = input()
curr = 0
cap = 0
for _ in xrange(n):
	a, b = map(int, raw_input().split())
	curr -= a
	curr += b
	cap = max(cap, curr)
print cap
