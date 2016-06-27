n = input()
if n <= 2:
	print -1
else:
	alist = [2, 3]
	alist.extend([1] * (n - 2))
	print " ".join(map(str, alist))
