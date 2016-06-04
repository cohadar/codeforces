def dangerous(S):
	if '1' * 7 in S or '0' * 7 in S:
		return True
	return False

print "YES" if dangerous(raw_input()) else "NO"