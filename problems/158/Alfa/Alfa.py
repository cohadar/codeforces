from __future__ import print_function
import sys

def debug(*args, **kwargs):
    print(*args, file=sys.stderr, **kwargs)

def load(stdin):
	n, k = map(int, stdin.readline().split())
	A = map(int, stdin.readline().split())
	border = A[k-1] if A[k-1] > 0 else 1
	print(len([x for x in A if x >= border]));
	debug(A)

if __name__ == '__main__':
	load(sys.stdin)

