package main 

import "fmt"

func solve(a, b int) int {
	if a % 2 == 0 || b % 2 == 0 {
		return a * b / 2
	} else {
		return (a * b - 1) / 2
	}
}

func main() {
	var a, b int
	fmt.Scanln(&a, &b)
	fmt.Println(solve(a, b))
}
