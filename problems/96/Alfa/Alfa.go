package main

import (
	"fmt" 
	"strings"
)

func main() {
	var s string 
	fmt.Scan(&s)
	if strings.Contains(s, "1111111") || strings.Contains(s, "0000000") {
		fmt.Println("YES")
	} else {
		fmt.Println("NO")
	}
}
