package main 

import "fmt"

func main() {
	var n, k int
	fmt.Scan(&n, &k)
	aa := make([]int, n, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&aa[i])
	}
	count := 0
	for _, v := range aa {
		if v > 0 && v >= aa[k - 1] {
			count++
		}
	}
	fmt.Println(count)
}
