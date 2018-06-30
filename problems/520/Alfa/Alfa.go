package main

import "fmt"
import "strings"

func main() {
	var n int
	var s string
	m := make(map[rune]bool)
	fmt.Scanf("%d\n", &n)
	fmt.Scanf("%s\n", &s)
	for _, v := range strings.ToLower(s) {
		m[v] = true
	}
	if len(m) == 26 {
		fmt.Println("YES")
	} else {
		fmt.Println("NO")
	}
}
