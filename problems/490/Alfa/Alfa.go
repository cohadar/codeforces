package main

import "fmt"

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	var n int
	fmt.Scan(&n)
	var t [3][]int
	for i := 0; i < n; i++ {
		var v int
		fmt.Scan(&v)
		t[v-1] = append(t[v-1], i+1)
	}
	w := min(len(t[0]), min(len(t[1]), len(t[2])))
	fmt.Println(w)
	for i := 0; i < w; i++ {
		fmt.Println(t[0][i], t[1][i], t[2][i])
	}
}
