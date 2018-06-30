package main

import "fmt"
import "sort"

func main() {
	var n int
	fmt.Scan(&n)
	a := make([]int, n)
	sum := 0
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
		sum += a[i]
	}
	sort.Sort(sort.Reverse(sort.IntSlice(a)))
	curr := 0
	for i := 0; i < n; i++ {
		curr += a[i]
		if 2*curr > sum {
			fmt.Println(i + 1)
			return
		}
	}
}
