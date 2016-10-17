package main

import (
	"fmt"
	"strings"
)

func main() {
	var s string
	fmt.Scanln(&s)
	ans := "NO"
	if strings.ContainsAny(s, "HQ9") {
		ans = "YES"
	}
	fmt.Println(ans)
}

