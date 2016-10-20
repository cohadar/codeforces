package main

import "fmt"

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}

func main() {
	var x, y int
	out:
	for y = 0; y < 5; y++ {
		for x = 0; x < 5; x++ {
			var v int
			fmt.Scan(&v)
			if v == 1 {
				break out
			}
		}
	}
	fmt.Println(abs(y - 2) + abs(x - 2))
}

