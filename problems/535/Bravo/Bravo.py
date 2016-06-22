C = raw_input()
p = 1
x = 0
for c in C:
	p *= 2
	x *= 2
	if c == '7':
		x += 1
print p - 1 + x