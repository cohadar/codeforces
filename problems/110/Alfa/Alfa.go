package main

import "fmt"

func main() {
	var s string
	fmt.Scan(&s)
	count := 0
	for _, v := range s {
		if v == '4' || v == '7' {
			count++
		}
	}
	if count == 4 || count == 7 {
		fmt.Println("YES")
	} else {
		fmt.Println("NO")
	}
}
