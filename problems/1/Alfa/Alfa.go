package main

import "fmt"

func main() {
	var n int64
	var m int64
	var a int64
	fmt.Scanf("%d %d %d", &n, &m, &a)
	x := (n + a - 1) / a
	y := (m + a - 1) / a
	fmt.Printf("%d\n", x * y)
}
