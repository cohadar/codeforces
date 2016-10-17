package main

import "fmt"

func main() {
	var n int
	var s string
	fmt.Scanln(&n)
	fmt.Scanln(&s)
	last := 'X'
	b := ""
	for _, v := range s {
		if last != v {
			last = v
			b += string(last)
		}
	}
	fmt.Println(len(s) - len(b))
}
