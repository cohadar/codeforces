package main

import "fmt"

func solve(a int64) int64 {
	ret := (a + 1) / 2
	if a % 2 != 0 {
		ret = -ret
	}
	return ret
}

func main() {
	var a int64
	fmt.Scan(&a)
	fmt.Println(solve(a))
}

