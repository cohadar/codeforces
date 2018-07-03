package main

import "fmt"

func dist(a, b int) int {
	c, d := (a-b+10)%10, (b-a+10)%10
	if c < d {
		return c
	}
	return d
}

func main() {
	var n int
	var s1, s2 string
	fmt.Scanf("%d\n", &n)
	fmt.Scanf("%s\n", &s1)
	fmt.Scanf("%s\n", &s2)
	sum := 0
	for i := 0; i < n; i++ {
		sum += dist(int(s1[i]-'0'), int(s2[i]-'0'))
	}
	fmt.Println(sum)
}
