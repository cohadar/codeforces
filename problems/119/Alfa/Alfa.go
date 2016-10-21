package main

import "fmt"

func b2i(b bool) int {
	if b {
		return 1
	} else {
		return 0
	}
}

func gcd(a, b int) int {
	if b == 0 {
		return a
	} else {
		return gcd(b, a % b)
	}
}

func main() {
	var a, b, n int
	fmt.Scan(&a, &b, &n)
	simon := true // who plays now?
	for {
		g := 0
		if simon {
			g = gcd(a, n)
		} else {
			g = gcd(b, n)
		}
		if n < g {
			fmt.Println(b2i(simon))
			return
		}
		n -= g
		simon = !simon
	}
}

