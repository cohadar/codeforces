package main

import "fmt"

func main() {
	var n, k int
	fmt.Scan(&n, &k)
	mins := 240 - k
	sol := 0
	for i := 1; i <= n; i++ {
		mins -= 5 * i
		if mins >= 0 {
			sol++
		}
	}
	fmt.Println(sol)
}
