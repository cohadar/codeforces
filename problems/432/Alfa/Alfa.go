package main

import "fmt"

func main() {
	var n, k int
	fmt.Scan(&n, &k)
	count := 0
	for i := 0; i < n; i++ {
		var x int
		fmt.Scan(&x)
		if x <= 5 - k {
			count++
		}
	}
	fmt.Println(count / 3)
}
