def compress(line):
	return line[0] + str(len(line) - 2) + line[-1] if len(line) > 10 else line

n = input()
lines = [compress(raw_input()) for _ in xrange(n)]
print '\n'.join(lines)