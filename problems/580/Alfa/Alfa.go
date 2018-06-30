package main

import "fmt"

func main() {
	var n, prev, curr int
	fmt.Scan(&n)
	max, cmax := 1, 0
	for i := 0; i < n; i++ {
		fmt.Scan(&curr)
		if curr >= prev {
			cmax++
			if cmax > max {
				max = cmax
			}
		} else {
			cmax = 1
		}
		prev = curr
	}
	fmt.Println(max)
}
