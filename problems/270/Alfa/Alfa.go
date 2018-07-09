package main

import "fmt"
import "math"

func okAngle(a float64) bool {
	n := 360 / (180 - a)
	if n < 3.0 {
		return false
	}
	return n == math.Round(n)
}

func main() {
	var t int
	fmt.Scan(&t)
	for i := 0; i < t; i++ {
		var a int
		fmt.Scan(&a)
		if okAngle(float64(a)) {
			fmt.Println("YES")
		} else {
			fmt.Println("NO")
		}
	}
}
