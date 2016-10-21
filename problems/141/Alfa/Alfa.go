package main

import "fmt"

func b2s(b bool) string {
	if b {
		return "YES"
	} else {
		return "NO"
	}
}

func main() {
	var a, b, c string
	fmt.Scanln(&a)
	fmt.Scanln(&b)
	fmt.Scanln(&c)
	x := new([256]int)
	y := new([256]int)
	for _, c := range a {
		x[c]++
	}
	for _, c := range b {
		x[c]++
	}
	for _, c := range c {
		y[c]++
	}
	for i := 0; i < 256; i++ {
		if x[i] != y[i] {
			fmt.Println("NO")
			return
		}
	}
	fmt.Println("YES")
}

