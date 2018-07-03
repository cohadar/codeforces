package main

import "fmt"

func main() {
	var n, t int
	fmt.Scan(&n, &t)
	a := make([]int, n)
	for i := 1; i < n; i++ {
		fmt.Scan(&a[i])
	}
	i := 1
	for {
		if i == t {
			fmt.Println("YES")
			return
		}
		if i > t {
			fmt.Println("NO")
			return
		}
		i += a[i]
	}
}
