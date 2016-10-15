package main

import "fmt"

func main() {
	var n int
	fmt.Scanln(&n)
	if n <= 0 {
		panic("bad n:" + string(n))
	}
	var nn [5]int
	for i := 0; i < n; i++ {
		var s int
		fmt.Scan(&s)
		if s < 1 || s > 4 {
			panic("bad s:" + string(s))
		}
		nn[s]++
	}
	count := 0
	// 4 4 4 4
	count += nn[4]
	// 31 31 31 31
	count += nn[3]
	nn[1] -= nn[3]
	// 22 22 22 22
	count += nn[2] / 2
	// 211
	if nn[2] % 2 != 0 {
		count++
		nn[1] -= 2
	}
	// 1111 1111 1111 1
	if nn[1] > 0 {
		count += nn[1] / 4
		if nn[1] % 4 != 0 {
			count++
		}
	}
	fmt.Println(count)
}
