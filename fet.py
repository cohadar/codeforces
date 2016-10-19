#!/usr/bin/python
import urllib
import re
import sys

def extract(html):
	input_pattern = '<div class="input"><div class="title">Input</div><pre>(.*?)</pre></div>'
	output_pattern = '<div class="output"><div class="title">Output</div><pre>(.*?)</pre></div>'
	inputs = re.findall(input_pattern, html)
	outputs = re.findall(output_pattern, html)
	assert len(inputs) == len(outputs)
	inputs = map(lambda s: s.replace("<br />", "\n"), inputs)
	outputs = map(lambda s: s.replace("<br />", "\n"), outputs)
	return inputs, outputs

def write_files(bodies, extension, name):
	for i, text in enumerate(bodies):
		with open(name + "." + str(i + 1) + extension, "w") as f:
			f.write(text)

def fetch_tests(problem_name, url):
	html = urllib.urlopen(url).read()
	inputs, outputs = extract(html)
	write_files(inputs, "in", problem_name)
	write_files(outputs, "out", problem_name)

if __name__ == '__main__':
	if len(sys.argv) == 3:
		fetch_tests(sys.argv[1], sys.argv[2])
	else:
		print "usage: fet.py <NAME> <URL>"
