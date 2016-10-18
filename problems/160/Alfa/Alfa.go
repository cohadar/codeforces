package main

import "fmt"
import "sort"

func main() {
	var n int
	fmt.Scanln(&n)
	a := make([]int, n)
	sum := 0
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
		sum += a[i]
	}
	sort.Ints(a)
	l, r := 0, sum
	nr := len(a)
	for _, v := range a {
		if l + v < r - v {
			l += v
			r -= v
			nr--
		}
	}
	fmt.Println(nr)
}

