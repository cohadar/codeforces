package main

import "fmt"

func main() {
	var n, m int
	fmt.Scan(&n, &m)
	for day := 1; ; day++ {
		if n == 0 {
			fmt.Println(day - 1)
			return
		}
		n--
		if day%m == 0 {
			n++
		}
	}
}
