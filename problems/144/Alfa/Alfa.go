package main

import "fmt"

func main() {
	var n int
	fmt.Scan(&n)
	imin, imax := 0, 0
	A := make([]int, n)
	for i := 0; i < len(A); i++ {
		fmt.Scan(&A[i])
		if A[imin] >= A[i] {
			imin = i
		}
		if A[imax] < A[i] {
			imax = i
		}
	}
	time := imax
	time += (len(A) - 1 - imin)
	if imax > imin {
		time--
	}
	if imax == imin {
		panic("impossible")
	}
	fmt.Println(time)
}

