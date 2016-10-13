package main

import "fmt"

func main() {
	var n int
	fmt.Scanln(&n)
	count := 0
	for i, a, b, c := 0, 0, 0, 0; i < n; i++ {
		fmt.Scanln(&a, &b, &c)
		if a + b + c >= 2 {
			count++
		}
	}
	fmt.Println(count)
}
