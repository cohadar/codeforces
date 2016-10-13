package main

import "fmt"
import "strings"

func main() {
	var n int
	fmt.Scanln(&n)
	x := 0
	for i := 0; i < n; i++ {
		var s string
		fmt.Scanln(&s)
		if strings.ContainsRune(s, '+') {
			x++
		} else {
			x--
		}
	}
	fmt.Println(x)
}
