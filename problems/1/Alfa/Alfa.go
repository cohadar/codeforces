package main

import "fmt"

func main() {
	var n, m, a int64
	fmt.Scan(&n, &m, &a)
	n1 := (n + a - 1) / a
	m1 := (m + a - 1) / a
	fmt.Println(n1 * m1)
}
